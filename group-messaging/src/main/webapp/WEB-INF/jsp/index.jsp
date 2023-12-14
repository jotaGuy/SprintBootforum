<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="include/header.jsp" />

<link rel="stylesheet" type="text/css" href="../../pub/css/topics-list.css">

<script>
    function redirectToMessages(topic) {
        window.location.href = "topicMessages/displayMessages?topic=" + encodeURIComponent(topic);
    }
</script>

<section class="section">
    <h1 class="title">Topics List</h1>

    <div class="topics-list">
        <c:forEach var="topic" items="${topics}">
            <div class="card" onclick="redirectToMessages('${topic.topic}')">
                <div class="card-body">
                    <h5 class="card-title">${fn:toUpperCase(fn:substring(topic.topic, 0, 1))}${fn:substring(topic.topic, 1, topic.topic.length())}</h5>
                    <hr/>
                    <p class="card-text">${topic.description}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<jsp:include page="include/footer.jsp" />
