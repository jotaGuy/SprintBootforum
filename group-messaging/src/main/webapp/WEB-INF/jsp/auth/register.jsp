<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="../../../pub/css/login.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <label for="colorSelector" class="label-color-selector">Select Background Color:</label>
    <select id="colorSelector" onchange="changeBackgroundColor()">
        <option value="whitesmoke">White Smoke</option>
        <option value="#333">Dark Gray (#333)</option>
    </select>
    </select>
    <form class="container" id="registrationForm" action="${pageContext.request.contextPath}/auth/registerSubmit"
          method="post">
        <div class="header">
            <h3 class="header-text">Sign Up</h3>
        </div>

        <!-- Display error message if it exists -->
        <c:if test="${fn:length(errors.allErrors) > 0 or fn:length(userExistsError) > 0}">
            <div class="error-message" style="color: red; margin: 10px 0 0 10px;">
                Error(s) occurred:
                <ul>
                    <c:forEach var="error" items="${errors.allErrors}">
                        <c:if test="${fn:length(error.defaultMessage.trim()) > 0}">
                            <li class="error-item" style="color: black;">${error.defaultMessage}</li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${fn:length(userExistsError.trim()) > 0}">
                        <li style="color: black;">${userExistsError}</li>
                    </c:if>
                </ul>
            </div>
        </c:if>

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

        function changeBackgroundColor() {
            console.log("Function called");

            const colorSelector = document.getElementById("colorSelector");
            const selectedColor = colorSelector.options[colorSelector.selectedIndex].value;

            // Change background color
            document.body.style.backgroundColor = selectedColor;
            document.querySelector('.container').style.backgroundColor = selectedColor;

            // Adjust error message color based on background color
            const errorMessage = document.querySelector('.error-message');
            const errorItems = document.querySelectorAll('.error-item');
            if (selectedColor === '#333') {
                errorMessage.style.color = 'whitesmoke';

// Now you can work with the selected elements, for example:
                errorItems.forEach(item => {
                    // Do something with each error item
                    // For instance, you can change the background color
                    item.style.color = 'whitesmoke';
                });
            } else {
                errorMessage.style.color = '#000';
                errorItems.forEach(item => {
                    // Do something with each error item
                    // For instance, you can change the background color
                    item.style.color = '#000';
                });

            }
        }
    </script>
</div>
</body>
</html>
