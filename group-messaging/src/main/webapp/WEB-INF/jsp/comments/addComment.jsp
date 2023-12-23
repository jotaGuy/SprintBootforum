<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/card.css">

<section class="section">
    <form id="postForm" action="${pageContext.request.contextPath}/comments/submitComment" method="post">

        <c:if test="${pageContext.request.userPrincipal ne null}">
            <!-- Include the authenticated user's name as a hidden input field -->
            <input type="hidden" name="user" value="${pageContext.request.userPrincipal.name}" />
        </c:if>
        <!-- Ensure 'topic' is passed as a hidden parameter in the URL -->
        <input type="hidden" name="postId" value="${param.postId}" />
        <label for="comment">Enter  comment
            <textarea name="comment" id="comment"></textarea>
        </label>

        <div class="btn-container">
            <button class="btn create-button" type="submit">Add Comment</button>
        </div>
    </form>

    <script>
        function logFormData(event) {
            // Prevent the default form submissio

            // Retrieve form data
            const form = document.getElementById("postForm");
            const formData = new FormData(form);

            // Log form data
            formData.forEach(function(value, key){
                console.log(key, value);
            });

            // Additional actions you may want to perform after logging the data
        }
    </script>
</section>

<jsp:include page="../include/footer.jsp" />