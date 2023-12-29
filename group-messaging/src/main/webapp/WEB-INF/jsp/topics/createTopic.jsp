<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/card.css">

<section class="section">
    <div class="container" style="height: 600px;">
        <h1 class="title">Create a Topic</h1>
        <div class="row">
            <!-- Display validation errors -->
            <c:if test="${not empty validationErrors}">
                <div class="alert alert-danger">
                    <strong>Error(s):</strong>
                    <ul>
                        <c:forEach items="${validationErrors}" var="error">
                            <li>${error.defaultMessage}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
        </div>
        <!-- Update your HTML as follows -->
        <div class="form-container">
            <form class="form" action="${pageContext.request.contextPath}/topics/submitTopic" method="post"
                  onsubmit="return validateForm(this)">
                <c:if test="${pageContext.request.userPrincipal ne null}">
                    <!-- Include the authenticated user's name as a hidden input field -->
                    <input type="hidden" name="user" value="${pageContext.request.userPrincipal.name}" />
                </c:if>
                <div class="form-group">
                    <label for="topic">Topic:</label>
                    <input type="text" class="form-control" id="topic" name="topic" required/>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" cols="30" rows="5"  required
                              oninput="updateCharacterCount(this)"></textarea>
                    <small id="characterCount" class="form-text text-muted"></small>
                    <p id="descriptionError" style="color: red; display: none;">Description must be at least 100 characters.</p>
                </div>
                <div class="btn-container">
                    <button class="btn create-button" type="submit">Create Topic</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        function updateCharacterCount(textarea) {
            const characterCountElement = document.getElementById('characterCount');
            const descriptionErrorElement = document.getElementById('descriptionError');
            const maxLength = 500;
            const currentLength = textarea.value.length;

            characterCountElement.innerText = currentLength + ' characters';

            if (currentLength > maxLength) {
                characterCountElement.style.color = 'red';
                descriptionErrorElement.style.display = 'none';
            } else if (currentLength < 50) {
                characterCountElement.style.color = 'green';
                descriptionErrorElement.style.display = 'block';
            } else {
                characterCountElement.style.color = 'lightgrey';
                descriptionErrorElement.style.display = 'none';
            }
        }

        function validateForm(form) {
            const descriptionLength = form.description.value.length;
            if (descriptionLength < 50) {
                // Display error message and apply bounce effect
                const descriptionErrorElement = document.getElementById('descriptionError');
                descriptionErrorElement.style.animation = 'bounce 2s';
                setTimeout(() => {
                    descriptionErrorElement.style.animation = '';
                }, 2000);
                return false; // Prevent form submission
            }
            return true; // Allow form submission
        }
    </script>
</section>

<jsp:include page="../include/footer.jsp" />
