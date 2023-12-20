<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="../../../pub/css/login.css" rel="stylesheet">
    <style>
        .header-tex {

        }
        .username-input {
            margin-top: -40px;
        }
    </style>
</head>
<body>
<div id="app">
    <form class="container" id="registrationForm" action="${pageContext.request.contextPath}/auth/registerSubmit" method="post">
        <div class="header">
            <h3 class="header-text">Sign Up</h3>
        </div>
        <input
                class="form username-input"
                id="username"
                type="text"
                name="username"
                placeholder="User Name"
        />
        <input
                class="form email-input"
                id="email"
                type="email"
                name="email"
                placeholder="Email"
        />
        <input
                class="form pwd-input"
                id="password"
                type="password"
                name="password"
                placeholder="Password"
        />
        <input
                class="form pwd-input"
                id="password-confirm"
                type="password"
                name="confirmPassword"
                placeholder="Password"
        />
        <button
                id="button"
                class="form button"
                type="submit"
        >
            Create Account
        </button>
        <a href="/auth/login">
            <div id="signup" class="signup">
                <div class="signup-fields">Sign In</div>
            </div>
        </a>
    </form>
    <div class="footer">Messaging-app</div>

    <script>
        document.getElementById('registrationForm').addEventListener('submit', function (event) {
            // Prevent the form from submitting normally

            // Log out form inputs
            const username = document.getElementById('username').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('password-confirm').value;

            console.log('Username: ' + username);
            console.log('Email: ' + email);
            console.log('Password: ' + password);
            console.log('Confirm Password: ' + confirmPassword);

            // Continue with form submission logic if needed
            // this.submit();
        });
    </script>
</div>
</body>
</html>
