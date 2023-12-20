<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />


<section>
        Hello
</section>

<section class="section">
        <!-- Create a link to the createMessage page with the current topic -->
        <c:url var="createMessageUrl" value="/comments/addComment">
                <c:param name="postId" value="${param.postId}" />
        </c:url>

        <a href="${createMessageUrl}">
                <button>Add Comment</button>
        </a>
</section>

<jsp:include page="../include/footer.jsp" />
