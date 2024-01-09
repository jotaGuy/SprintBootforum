<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp" />

<section>
    <h2>Update Profile</h2>
    <form id="updateProfileForm" method="post">
        <!-- Text input fields -->
        <label for="username">Username:</label>
        <input type="text" name="username" id="username">

        <label for="email">Email:</label>
        <input type="text" name="email" id="email">



        <!-- Radio button -->
        <label>Gender:</label>
        <input type="radio" name="gender" value="male" id="male"><label for="male">Male</label>
        <input type="radio" name="gender" value="female" id="female"><label for="female">Female</label>

        <!-- Checkbox -->
        <label>Hobbies:</label>
        <input type="checkbox" name="hobby" value="reading" id="reading"><label for="reading">Reading</label>
        <input type="checkbox" name="hobby" value="gaming" id="gaming"><label for="gaming">Gaming</label>

        <!-- Select element -->
        <label for="country">Country:</label>
        <select name="country" id="country">
            <option value="us">United States</option>
            <option value="ca">Canada</option>
            <option value="uk">United Kingdom</option>
        </select>

        <!-- Submit button -->
        <button type="button" onclick="updateProfile()">Update Profile</button>
    </form>

    <!-- Display update result -->
    <div id="updateResult"></div>
</section>

<script>
    function updateProfile() {
        // Use AJAX to send the form data to the server
        const formData = $("#updateProfileForm").serialize();
        $.ajax({
            type: "POST",
            url: "",  // Replace with your actual endpoint
            data: formData,
            success: function (response) {
                // Display the result
                $("#updateResult").html(response);
            },
            error: function () {
                // Handle error if needed
                alert("Error updating profile.");
            }
        });
    }
</script>

<jsp:include page="../include/footer.jsp" />
