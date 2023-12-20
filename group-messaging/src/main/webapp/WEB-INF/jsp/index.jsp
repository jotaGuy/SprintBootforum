<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="include/header.jsp" />

<link rel="stylesheet" type="text/css" href="../../pub/css/topics-list.css">

<script>
    function redirectToMessages(topic) {
        window.location.href = "/post/post?topic=" + encodeURIComponent(topic);
    }

    // Function to refresh the page every 3 seconds
    // function refreshPage() {
    //     location.reload(); // Pass true to force a full page reload
    // }
    //
    // // Set up the interval to call the refreshPage function every 3000 milliseconds (3 seconds)
    // setInterval(refreshPage, 3000);
</script>

<section class="section">
    <h1 class="title">Topics List</h1>
    <div class="topics-list">
        <c:forEach var="topic" items="${topics}">
            <div class="card" onclick="redirectToMessages('${topic.topic}')">
                <div class="card-body">
                    <h5 class="card-title topic">${fn:toUpperCase(fn:substring(topic.topic, 0, 1))}${fn:substring(topic.topic, 1, topic.topic.length())}</h5>
                    <hr/>
                    <p class="card-text description">${topic.description}</p>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="create-button">
        <a href="${pageContext.request.contextPath}/topics/createTopic" class="btn">Add Topic</a>
    </div>
</section>

<jsp:include page="include/footer.jsp" />
