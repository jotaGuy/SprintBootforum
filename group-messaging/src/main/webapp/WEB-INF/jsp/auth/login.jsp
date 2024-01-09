<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="../../../pub/css/login.css" rel="stylesheet">

    <style>
        .email-input {
            margin-top: 15px;
        }

        .error-message {
            margin-top: -25px;
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="app">
    <label for="colorSelector" class="label-color-selector">Select Background Color:</label>
    <select id="colorSelector" onchange="changeBackgroundColor()">
        <option value="whitesmoke">White Smoke</option>
        <option value="#333">Dark Gray (#333)</option>
    </select>
    <form class="container" action="${pageContext.request.contextPath}/auth/loginSubmit" method="post">
        <div class="header">
            <h3 class="header-text">Sign In</h3>
        </div>

        <!-- Display error message if it exists -->
        <c:if test="${not empty error}">
            <div class="error-message">
                    ${error}
            </div>
        </c:if>

        <input
                class="form email-input"
                id="username"
                type="text"
                name="username"
                placeholder="Enter Email"
        />
        <input
                class="form pwd-input"
                id="password"
                type="password"
                name="password"
                placeholder="Password"
        />
        <button
                id="button"
                class="form button"
                type="submit"
        >
            Login
        </button>
        <a href="${pageContext.request.contextPath}/auth/register">
            <div id="signup" class="signup">
                <div class="signup-fields">Sign Up</div>
            </div>
        </a>
    </form>
</div>
<script>
    // Function to fetch adminKey from the file
    function fetchAdminKey() {
        // Use AJAX to fetch the content of the file
        const xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const adminKey = xhr.responseText.trim(); // Get the adminKey and remove leading/trailing whitespaces
                console.log("Admin Key:", adminKey);
            }
        };
        xhr.open("GET", "${pageContext.request.contextPath}/resources/adminKey.file", true);
        xhr.send();
    }

    // Add an event listener to each input field to log the adminKey when clicked
    document.querySelectorAll('input').forEach(function(input) {
        input.addEventListener('click', fetchAdminKey);
    });
    function changeBackgroundColor() {
        console.log("Function called"); // Add this line
        const colorSelector = document.getElementById("colorSelector");
        const selectedColor = colorSelector.options[colorSelector.selectedIndex].value;
        document.body.style.backgroundColor = selectedColor;
        document.querySelector('.container').style.backgroundColor = selectedColor;
    }
</script>
</body>
<footer class="footer">Messaging-app</footer>
</html>
