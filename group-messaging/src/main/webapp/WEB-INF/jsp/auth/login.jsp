<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="../../../pub/css/login.css" rel="stylesheet">

    <style>
        .email-input {
            margin-top: -35px;
        }
    </style>
</head>
<body>
<div id="app">
    <form class="container" action="${pageContext.request.contextPath}/auth/loginSubmit" method="post">
        <div class="header">
            <h3 class="header-text">Sign In</h3>
        </div>
        <input
                class="form email-input"
                id="username"
                type="text"
                name="username"
                placeholder="User Name"
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
</body>
<footer class="footer">Messaging-app</footer>
</html>