<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/post-page.css">

<section class="section">
    <div class="top-container">
        <h1 class="topic-title">Post for ${param.topic}</h1>
        <span style="margin-top: -10px; margin-bottom: 20px" class="description-text">${topics.description}</span>
        <c:url var="createMessageUrl" value="/post/createPost">
            <c:param name="topic" value="${param.topic}" />
        </c:url>
        <div class="btn-container">
            <a href="${createMessageUrl}" class="btn create-button">Add a Post</a>
        </div>
    </div>
    <c:forEach var="post" items="${posts}" varStatus="loopStatus">
        <div class="card" id="topicList" onclick="redirectToMessages('${post.id}', ${loopStatus.index})">
            <div class="message">
                <h4>${post.title}</h4>
                <p class="message-text">${post.message}</p>
                <div class="card-bottom">
                    <h4>By:
                        <span>
                                ${usernames[loopStatus.index]}
                        </span>
                    </h4>
                </div>
            </div>
        </div>
    </c:forEach>

</section>

<script>
    function redirectToMessages(postId) {
        window.location.href = "/comments/comments?postId=" + encodeURIComponent(postId);
    }

</script>

<jsp:include page="../include/footer.jsp" />
