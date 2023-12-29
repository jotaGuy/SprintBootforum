<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/card.css">

<section class="section">
    <div class="container" style="height: 600px;">
        <h1 class="title">Create a Post</h1>
        <div class="form-container">
            <form id="postForm" action="${pageContext.request.contextPath}/post/submitPost" method="post">
                <c:if test="${pageContext.request.userPrincipal ne null}">
                    <!-- Include the authenticated user's name as a hidden input field -->
                    <input type="hidden" name="user" value="${pageContext.request.userPrincipal.name}" />
                </c:if>
                <!-- Ensure 'topic' is passed as a hidden parameter in the URL -->
                <input type="hidden" name="topic" value="${param.topic}" />
                <div class="form-group">
                    <label for="title">Post Title:</label>
                    <input type="text" class="form-control" id="title" name="title" required />
                </div>
                <div class="form-group">
                    <label for="message">Description:</label>
                    <textarea class="form-control" id="message" name="message" cols="30" rows="5" required></textarea>
                </div>
                <div class="btn-container">
                    <button class="btn create-button" type="submit">Create Post</button>
                </div>
            </form>
        </div>
    </div>
</section>


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

<jsp:include page="../include/footer.jsp" />
