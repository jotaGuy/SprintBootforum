<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" type="text/css" href="../../pub/css/topics-list.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<section class="section">
    <div class="container" style="height: 600px;">
        <h1 class="title">Create a Topic</h1>
        <div class="row">
            <div class="col-md-6 offset-md-3">
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

                <form action="${pageContext.request.contextPath}/topics/submitTopic" method="post">
                    <c:if test="${pageContext.request.userPrincipal ne null}">
                        <!-- Include the authenticated user's name as a hidden input field -->
                        <input type="hidden" name="authenticatedUserName" value="${pageContext.request.userPrincipal.name}" />
                    </c:if>
                    <div class="form-group">
                        <label for="topic">Topic:</label>
                        <input type="text" class="form-control" id="topic" name="topic" required/>
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea class="form-control" id="description" name="description" required oninput="updateCharacterCount(this)"></textarea>
                        <small id="characterCount" class="form-text text-muted"></small>
                    </div>
                    <button type="submit" class="btn btn-primary">Create Topic</button>
                </form>
            </div>
        </div>
    </div>

    <script>
        function updateCharacterCount(textarea) {
            const characterCountElement = document.getElementById('characterCount');
            const maxLength = 500;
            const currentLength = textarea.value.length;

            characterCountElement.innerText = currentLength + ' characters';

            if (currentLength > maxLength) {
                characterCountElement.style.color = 'red';
            } else if (currentLength < 100) {
                characterCountElement.style.color = 'green';
            } else {
                characterCountElement.style.color = 'lightgrey';
            }
        }
    </script>
</section>

<jsp:include page="../include/footer.jsp" />
