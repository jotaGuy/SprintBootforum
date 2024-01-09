<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../../../pub/css/comments-page.css">

<section class="section">
        <c:choose>
                <c:when test="${not empty comments}">
                        <c:forEach var="comment" items="${comments}">
                                <div class="message">
                                        <p class="message-text">${comment.comment}
                                                <br>
                                                <br>
                                                By: Jotab
                                        </p>
                                </div>
                        </c:forEach>
                </c:when>
                <c:otherwise>
                        <p style="font-size: 25px;">Start the conversation by adding the first comment!</p>
                </c:otherwise>
        </c:choose>
</section>

<!-- Display validation errors if there are any -->
<c:if test="${not empty validationErrors}">
        <div class="validation-errors">
                <p>Error(s) occurred:</p>
                <ul>
                        <c:forEach var="error" items="${validationErrors}">
                                <li>${error.defaultMessage}</li>
                        </c:forEach>
                </ul>
        </div>
</c:if>

<section class="bottom-section">
        <div class="comment-container">
                <form action="${pageContext.request.contextPath}/comments/submitComment" method="post">
                        <c:if test="${pageContext.request.userPrincipal ne null}">
                                <!-- Include the authenticated user's name as a hidden input field -->
                                <input type="hidden" name="user" value="${pageContext.request.userPrincipal.name}" />
                        </c:if>
                        <!-- Hidden input field for postId -->
                        <input type="hidden" name="postId" value="${param.postId}" />
                        <label for="comment-input">
                                <input style="color: whitesmoke" name="comment" type="text" id="comment-input" placeholder="Enter your opinion..." oninput="filterList()">
                        </label>
                        <button type="submit" class="btn">Send</button>
                </form>
        </div>
</section>

<!-- Include the SockJS and Stomp.js libraries -->
<script src="${pageContext.request.contextPath}/webjars/sockjs-client/1.5.1/sockjs.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>

<script>
        // Declare a variable to store the interval ID
        let reloadInterval;

        // Function to start the interval
        // function startReloadInterval() {
        //         reloadInterval = setInterval(function () {
        //                 location.reload();
        //         }, 3000);
        // }

        // Function to stop the interval
        function stopReloadInterval() {
                clearInterval(reloadInterval);
        }

        // Add event listeners to start and stop the interval based on input focus
        document.getElementById('comment-input').addEventListener('focus', function () {
                // Input is in focus, stop the interval
                stopReloadInterval();
        });

        // document.getElementById('comment-input').addEventListener('blur', function () {
        //         // Input is not in focus, start the interval
        //         startReloadInterval();
        // });

        // Start the interval initially
        startReloadInterval();

</script>

<jsp:include page="../include/footer.jsp" />
