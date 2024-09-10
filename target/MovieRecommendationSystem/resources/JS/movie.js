document.addEventListener('DOMContentLoaded', function() {
    const stars = document.querySelectorAll('.star');
    const ratingValueInput = document.getElementById('ratingValue');

    // Click event to set the rating value
    stars.forEach(star => {
        star.addEventListener('click', function() {
            const value = this.getAttribute('data-value');
            ratingValueInput.value = value;

            // Remove the 'selected' class from all stars
            stars.forEach(s => s.classList.remove('selected'));

            // Add the 'selected' class to the clicked star and the stars before it
            stars.forEach(s => {
                if (parseInt(s.getAttribute('data-value')) >= parseInt(value)) {
                    s.classList.add('selected');
                }
            });
        });
    });
});



$(document).ready(function() {
    var table = $('#user').DataTable({
        ajax: {
            url: '/MovieRecommendationSystem/users',
            dataSrc: '',
            error: function(xhr, status, error) {
                console.error("AJAX error:", status, error);
            }
        },
        columns: [
            { title: "ID", data: "userId" },
            { title: "Username", data: "username" },
            { title: "Password", data: "password" },
            { title: "Email", data: "email" },
            { title: "Contact", data: "contact" },
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

    // Delete user functionality
    table.on('click', 'button.deleteRow', function() {
        var $row = $(this).closest('tr');
        var rowData = table.row($row).data();
        var userId = rowData.userId;

        $.ajax({
            url: '/MovieRecommendationSystem/deleteUser/' + userId,
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

    // Edit user functionality
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
            userId: $(row).find('td').eq(0).find('input').val(),
            username: $(row).find('td').eq(1).find('input').val(),
            password: $(row).find('td').eq(2).find('input').val(),
            email: $(row).find('td').eq(3).find('input').val(),
            contact: $(row).find('td').eq(4).find('input').val()
        };

        $.ajax({
            url: '/MovieRecommendationSystem/updateUser',
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
