function validateUsername() {
            const username = document.forms['frm']['username'].value;
            const errorElement = document.getElementById('usernameError');
            if (username === '') {
                errorElement.innerText = 'Username is required.';
            } else {
                errorElement.innerText = '';
            }
        }

        function validateContact() {
            const contact = document.forms['frm']['contact'].value;
            const contactRegex = /^[0-9]{10}$/;
            const errorElement = document.getElementById('contactError');
            if (!contactRegex.test(contact)) {
                errorElement.innerText = 'Contact must be a 10-digit number.';
            } else {
                errorElement.innerText = '';
            }
        }

        function validateEmail() {
            const email = document.forms['frm']['email'].value;
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            const errorElement = document.getElementById('emailError');
            if (!emailRegex.test(email)) {
                errorElement.innerText = 'Invalid email address.';
            } else {
                errorElement.innerText = '';
            }
        }

        function validatePassword() {
            const password = document.forms['frm']['password'].value;
            const errorElement = document.getElementById('passwordError');
            if (password.length < 6) {
                errorElement.innerText = 'Password must be at least 6 characters long.';
            } else {
                errorElement.innerText = '';
            }
        }

        function validateTerms() {
            const terms = document.getElementById('terms').checked;
            const errorElement = document.getElementById('termsError');
            if (!terms) {
                errorElement.innerText = 'You must agree to the terms and conditions.';
            } else {
                errorElement.innerText = '';
            }
        }

        function validateForm() {
            // Validate all fields before submitting
            validateUsername();
            validateContact();
            validateEmail();
            validatePassword();
            validateTerms();

            // Check if there are any error messages present
            const errorMessages = document.querySelectorAll('.error');
            for (const error of errorMessages) {
                if (error.innerText !== '') {
                    return false; // Prevent form submission if any error
                }
            }
            return true; // Allow form submission if no errors
        }