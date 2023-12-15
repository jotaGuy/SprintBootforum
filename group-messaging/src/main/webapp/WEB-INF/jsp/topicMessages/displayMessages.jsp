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

<jsp:include page="../include/footer.jsp" />
