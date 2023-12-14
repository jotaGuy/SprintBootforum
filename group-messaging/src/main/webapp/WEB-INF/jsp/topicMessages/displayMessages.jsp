<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section class="section">
    <h1 class="title">Messages for ${param.topic}</h1>

    <c:forEach var="message" items="${messages}">
        <div class="message">
            <p>${message.message}</p>
            <p>By: ${message.email}</p>
        </div>
    </c:forEach>
</section>

<jsp:include page="../include/footer.jsp" />
