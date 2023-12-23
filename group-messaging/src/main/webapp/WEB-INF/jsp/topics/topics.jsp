<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" type="text/css" href="../../../pub/css/topics-page.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">




<script>
    function redirectToMessages(topic) {
        window.location.href = "/post/post?topic=" + encodeURIComponent(topic);
    }
</script>


<section class="section">
    <div class="top-container">
        <h1 class="title" style="font-size: 50px; font-weight: lighter;">Topics List</h1>
        <h3 style="font-size: 25px; font-weight: lighter;">Search through all our topics and join the conversations!</h3>
    </div>
    <div class="search-container">
        <input type="text" id="searchBar" placeholder="Search..." oninput="filterList()">
        <div class="btn-container">
            <a href="${pageContext.request.contextPath}/topics/createTopic" class="btn create-button">Add Topic</a>
        </div>
    </div>
    <div class="topics-list" id="topicList">
        <c:forEach var="topic" items="${topics}">
            <div class="card listItem" onclick="redirectToMessages('${topic.topic}')">
                <div class="card-body">
                    <h2 class="topic-title">${fn:toUpperCase(fn:substring(topic.topic, 0, 1))}${fn:substring(topic.topic, 1, topic.topic.length())}</h2>
                    <p class="description-text">${topic.description}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<script>
    function filterList() {
        const input = document.getElementById('searchBar').value.toLowerCase();
        const topicList = document.getElementById('topicList');
        const topics = topicList.getElementsByClassName('listItem');
        for (let i = 0; i < topics.length; i++) {
            const topicText = topics[i].innerText.toLowerCase();
            topics[i].style.display = topicText.includes(input) ? 'block' : 'none';
        }
    }
</script>

<jsp:include page="../include/footer.jsp" />
