<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" type="text/css" href="../../../pub/css/profile.css">


<section>
    <h2>User Profile</h2>

    <c:if test="${currentUser ne null}">
        <p>Username: ${currentUser.username}</p>
        <p>Email: ${currentUser.email}</p>
    </c:if>

    <c:if test="${currentUser eq null}">
        <p>No user information available. Make sure you are logged in.</p>
    </c:if>
</section>

<jsp:include page="../include/footer.jsp" />