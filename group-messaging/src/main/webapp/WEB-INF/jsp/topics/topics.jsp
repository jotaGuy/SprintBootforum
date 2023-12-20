<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/messages.css">

<section class="section">
    <h1 class="title">Search Topics</h1>
</section>

<section class="section">
    <!-- Search bar -->
    <input type="text" id="searchBar" placeholder="Search..." oninput="filterList()">

    <!-- List of topics to be filtered -->
        <div id="topicList" >
        <c:forEach var="topic" items="${topics}">
            <div class="card" id="topicList" onclick="redirectToMessages('${topic.topic}')">
            <div class="listItem">${topic.topic}</div>
            <div class="listItem">${topic.description}</div>
            </div>
        </c:forEach>
    </div>

    <div class="create-button">
        <a href="${pageContext.request.contextPath}/topics/createTopic" class="btn">Add Topic</a>
    </div>
</section>

<script>
    function redirectToMessages(topic) {
        window.location.href = "/post/post?topic=" + encodeURIComponent(topic);
    }
    function filterList() {
        // Get user input from the search bar
        var input = document.getElementById('searchBar').value.toLowerCase();

        // Get the list of topics
        var topicList = document.getElementById('topicList');
        var topics = topicList.getElementsByClassName('listItem');

        // Loop through the topics and hide those that don't match the search input
        for (var i = 0; i < topics.length; i++) {
            var topicText = topics[i].innerText.toLowerCase();
            if (topicText.includes(input)) {
                topics[i].style.display = 'block';
            } else {
                topics[i].style.display = 'none';
            }
        }
    }
</script>

<jsp:include page="../include/footer.jsp" />
