<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/messages.css">

<section class="section">
    <form id="postForm" action="${pageContext.request.contextPath}/post/submitPost" method="post">

        <c:if test="${pageContext.request.userPrincipal ne null}">
            <!-- Include the authenticated user's name as a hidden input field -->
            <input type="hidden" name="authenticatedUserName" value="${pageContext.request.userPrincipal.name}" />
        </c:if>
        <!-- Ensure 'topic' is passed as a hidden parameter in the URL -->
        <input type="hidden" name="topic" value="${param.topic}" />
        <label for="title">Post Title
            <input type="text" name="title" id="title" />
        </label>
        <label for="message">Message
            <textarea type="text" name="message" id="message"></textarea>
        </label>

        <button type="submit">Create Post</button>
    </form>

    <script>
        function logFormData() {
            // Retrieve form data
            const form = document.getElementById("postForm");
            const formData = new FormData(form);

            // Log form data
            formData.forEach(function(value, key){
                console.log(key, value);
            });

            // Prevent the default form submission
            form.onsubmit();
        }
    </script>
</section>

<jsp:include page="../include/footer.jsp" />
