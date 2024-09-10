$(document).ready(function() {
    var table = $('#example').DataTable({
        ajax: {
            url: '/MovieRecommendationSystem/admin',
            dataSrc: '',  // Since the data is a flat array
            error: function(xhr, status, error) {
                console.error("AJAX error:", status, error);
            }
        },
        columns: [
            { title: "ID", data: "movId" },
            { title: "Name", data: "movName" },
            { title: "About", data: "about" },
            { title: "Year", data: "movYear" },
            {
                title: "Edit",
                orderable: false,
                searchable: false,
                render: function() {
                    return '<button class="editRow btn btn-primary"><i class="bi bi-pencil"></i></button>';
                }
            },
            {
                title: "Delete",
                orderable: false,
                searchable: false,
                render: function() {
                    return '<button class="deleteRow btn btn-danger"><i class="bi bi-trash"></i></button>';
                }
            }
        ]
    });

    // Delete functionality
    table.on('click', 'button.deleteRow', function() {
        var $row = $(this).closest('tr');
        var rowData = table.row($row).data();
        var movieId = rowData.movId;

        $.ajax({
            url: '/MovieRecommendationSystem/deleteMovie/' + movieId,
            type: 'POST',
            success: function(response) {
                table.row($row).remove().draw(false);
                alert(response);
            },
            error: function(xhr, status, error) {
                alert('Error deleting data: ' + error);
            }
        });
    });

    // Edit functionality
    table.on('click', 'button.editRow', function() {
        var $row = $(this).closest('tr');
        var $button = $(this);
        var $icon = $button.find('i');

        if ($icon.hasClass('bi-pencil')) {
            makeEditable($row);
            $icon.removeClass('bi-pencil').addClass('bi-save');
            $button.removeClass('btn-primary').addClass('btn-success');
        } else if ($icon.hasClass('bi-save')) {
            saveEdits($row);
            $icon.removeClass('bi-save').addClass('bi-pencil');
            $button.removeClass('btn-success').addClass('btn-primary');
        }
    });

    function makeEditable(row) {
        $(row).find('td').not(':last-child').not(':nth-last-child(2)').each(function() {
            var cellContent = $(this).text();
            $(this).html('<input type="text" class="form-control" value="' + cellContent + '">');
        });
    }

    function saveEdits(row) {
        var rowData = {
            movId: $(row).find('td').eq(0).find('input').val(),
            movName: $(row).find('td').eq(1).find('input').val(),
            about: $(row).find('td').eq(2).find('input').val(),
            movYear: $(row).find('td').eq(3).find('input').val()
        };

        $.ajax({
            url: '/MovieRecommendationSystem/updateMovie',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(rowData),
            success: function(response) {
                alert(response);
                $(row).find('td').not(':last-child').each(function(index) {
                    var inputVal = $(this).find('input').val();
                    $(this).html(inputVal);
                });
            },
            error: function(xhr, status, error) {
                alert('Error updating data: ' + error);
            }
        });
    }
	
});

document.addEventListener('DOMContentLoaded', function() {
    document.forms['frm'].reset(); // This will reset the form fields
});
//==============================================================================================
