<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/messages.css">

<section class="section">
    <h1 class="title">Messages for ${param.topic}</h1>

    <c:forEach var="message" items="${messages}">
        <div class="message">
            <p class="message-text">${message.message}</p>
            <p class="user-email">By: ${message.email}</p>
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

<jsp:include page="../include/footer.jsp" />
