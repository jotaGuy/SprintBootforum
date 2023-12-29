<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>

    <link href="../../../pub/css/global-style.css" rel="stylesheet">
    <link href="../../../pub/css/navbar.css" rel="stylesheet">
    <link href="../../../pub/css/footer.css" rel="stylesheet">

</head>
<body>

<nav class="navbar">
    <div class="container">
        <ul class="nav-list">
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/auth/login">Sign In</a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasAnyAuthority('ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="">Admin</a>
                </li>
            </sec:authorize>
            <li class="nav-item">
                <a class="nav-link" href="/topics/topics">Search Topics</a>
            </li>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/profile/profile">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/auth/logout">Logout</a>
                </li>
            </sec:authorize>
        </ul>
    </div>
</nav>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const navItems = document.querySelectorAll('.nav-item');
        navItems.forEach(function (navItem) {
            navItem.addEventListener('click', function (event) {
                // Find the first <a> tag with a href within the clicked .nav-item
                const link = event.currentTarget.querySelector('a[href]');

                if (link) {
                    // Prevent the default behavior of the link
                    event.preventDefault();

                    // Navigate to the href of the found link
                    window.location.href = link.getAttribute('href');
                }
            });
        });
    });
</script>