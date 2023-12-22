<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/messages.css">

<section class="section">
    <h1 class="title">Post for ${param.topic}</h1>

    <c:forEach var="post" items="${posts}">
    <div class="card" id="topicList" onclick="redirectToMessages('${post.id}')">
        <div class="message">
            <p class="message-text">${post.message}</p>
            <p class="message-text">${user.username}</p>
        </div>
    </div>
    </c:forEach>
</section>

<section class="section">
    <!-- Create a link to the createMessage page with the current topic -->
    <c:url var="createMessageUrl" value="/post/createPost">
        <c:param name="topic" value="${param.topic}" />
    </c:url>

    <a href="${createMessageUrl}">
        <button>Hello</button>
    </a>
</section>

<script>
    function redirectToMessages(postId) {
        window.location.href = "/comments/comments?postId=" + encodeURIComponent(postId);
    }

</script>

<jsp:include page="../include/footer.jsp" />
