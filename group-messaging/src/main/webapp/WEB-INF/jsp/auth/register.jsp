<!doctype html>
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
    <form class="container">
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
                id="passwrd"
                type="password"
                name="password"
                placeholder="Password"
        />
        <button
                id="button"
                class="form button"
                id="submit"
                type="submit"
                target="_index.html"
        >
            <a id="button-link" href="/" target=""> Create Account </a>
        </button>
        <a href="/about">
            <div id="signup" class="signup">
                <div class="signup-fields">Sign In</div>
            </div>
        </a>
    </form>
    <div class="footer">Messaging-app</div>
</div>
</body>
</html>
