<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #333;
    }
    #userTable tbody tr {
        background-color: #333;
        border: 1px solid whitesmoke;
        box-shadow: 0 0 10px whitesmoke;
        margin-top: 5px;
        transition: background-color 0.3s, transform 0.5s cubic-bezier(0.68, -0.55, 0.27, 0.5);
    }

    #userTable tbody tr:hover {
        background-color: #333333; /* Change the color when hovered */
        transform: scale(1.01); /* Slightly scale up for the hover effect */
    }

</style>

<div class="container-fluid bg-#333 p-2">
    <!-- Bootstrap navigation bar with back arrow -->
    <nav class="navbar navbar-dark">
        <a class="navbar-brand" href="javascript:void(0);" onclick="goBackToHomePage()">
            <!-- Bootstrap back arrow icon -->
            <i class="bi bi-arrow-left-circle-fill bg-orange" style="font-size: 4em;"></i>
        </a>
    </nav>
</div>

<section class="custom-bootstrap-section" style="margin-top: 5px">
    <!-- Your Bootstrap styles will only affect elements within this section -->

    <div class="bg-light2 pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <h1 class="m-0" style="color: whitesmoke">Admin Index</h1>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-bordered table-striped table-hover" id="userTable">
                            <thead class="thead-dark">
                            <tr>
                                <th scope="col" onclick="sortTable(0, 'username')">Username</th>
                                <th scope="col" onclick="sortTable(1, 'email')">Email</th>
                                <th scope="col" onclick="sortTable(2, 'numTopics')">Number of Topics</th>
                                <th scope="col" onclick="sortTable(3, 'numPosts')">Number of Posts</th>
                                <th scope="col" onclick="sortTable(4, 'numComments')">Number of Comments</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="userInfo" items="${userInfos}">
                                <tr>
                                    <td>${userInfo.username}</td>
                                    <td>${userInfo.email}</td>
                                    <td>${userInfo.numTopics}</td>
                                    <td>${userInfo.numPosts}</td>
                                    <td>${userInfo.numComments}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    let sortDirection = {};

    function sortTable(columnIndex, columnName) {
        console.log('Sorting table for column:', columnName);

        let table, rows, switching, i, x, y, shouldSwitch;
        table = document.getElementById("userTable");
        console.log('Column index:', columnIndex);

        switching = true;

        while (switching) {
            switching = false;
            rows = table.rows;

            for (i = 1; i < (rows.length - 1); i++) {
                shouldSwitch = false;

                x = rows[i].getElementsByTagName("TD")[columnIndex];
                y = rows[i + 1].getElementsByTagName("TD")[columnIndex];

                var xValue = getValue(x.innerHTML); // Get appropriate value for comparison
                var yValue = getValue(y.innerHTML);

                if (sortDirection[columnName] === 'asc') {
                    if (xValue > yValue) {
                        shouldSwitch = true;
                        break;
                    }
                } else {
                    if (xValue < yValue) {
                        shouldSwitch = true;
                        break;
                    }
                }
            }

            if (shouldSwitch) {
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
            }
        }

        // Toggle sorting direction for the clicked column
        sortDirection[columnName] = (sortDirection[columnName] === 'asc') ? 'desc' : 'asc';
    }

    function getValue(cellContent) {
        // Add logic to parse and return the appropriate value for comparison
        return isNaN(cellContent) ? cellContent.toLowerCase() : parseInt(cellContent);
    }

    function goBackToHomePage() {
        // Replace 'your_home_page_url' with the actual URL of your home page
        window.location.href = '/';
    }
</script>
