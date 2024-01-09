<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #333;
        color: white; /* Added text color */
    }

    /* Updated the background color and icon color for the navigation bar */
    .navbar {
        background-color: #333;
    }

    .navbar-brand i {
        color: orange;
    }

    /* Added styling for the container */
    .container {
        margin-top: 40px;
        margin-bottom: 50px;
    }

    /* Added styling for the card */
    .card {
        background-color: whitesmoke; /* Card background color */
        color: #333; /* Card text color */
        border: 1px solid whitesmoke;
        box-shadow: 2px 3px 25px white;
    }

    .card img {
        max-width: 100%;
        height: auto;
        border-radius: 50%; /* Make the image circular */
        margin-bottom: 20px;
    }

    .card-title {
        text-align: center;
        margin-bottom: 20px;
    }

    .card-text {
        white-space: pre-line; /* Preserve line breaks in the text */
    }
</style>

<div class="container-fluid bg-#333 p-2">
    <!-- Bootstrap navigation bar with back arrow -->
    <nav class="navbar navbar-dark">
        <a class="navbar-brand" href="javascript:void(0);" onclick="goBackToHomePage()">
            <!-- Bootstrap back arrow icon -->
            <i class="bi bi-arrow-left-circle-fill" style="font-size: 4em;"></i>
        </a>
    </nav>
</div>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 d-flex align-items-center justify-content-center">
            <div class="card">
                <div class="card-body">
                    <div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input language-radio" type="radio" name="language"
                                   id="englishRadio" checked>
                            <label class="form-check-label" for="englishRadio">English</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input language-radio" type="radio" name="language"
                                   id="spanishRadio">
                            <label class="form-check-label" for="spanishRadio">Spanish</label>
                        </div>
                    </div>
                    <!-- Update the image source to the correct path -->
                    <img src="../../pub/images/profile_image.jpg" alt="picture of me">
                    <h5 class="card-title">Jancy Baez</h5>
                    <p class="card-text" id="profileText">
                        I am a Front-End Engineer with about a year of experience in developing web and mobile applications. Recently, I successfully completed the Java Full Stack Bootcamp at Per Scholas and received a certificate for my achievement.

                        During the bootcamp, I gained valuable skills in Java programming, Spring Boot, and front-end technologies. I am passionate about using my technical expertise to contribute to a collaborative team environment, where I can leverage my skills and knowledge to make a positive impact.

                        My goal is to apply the skills I have acquired from both my past professional experience and the Java Full Stack Bootcamp to work on challenging projects and continue to grow as a developer.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    function goBackToHomePage() {
        // Replace 'your_home_page_url' with the actual URL of your home page
        window.location.href = '/';
    }
    const englishRadio = document.getElementById('englishRadio');
    const spanishRadio = document.getElementById('spanishRadio');
    const profileText = document.getElementById('profileText');

    englishRadio.addEventListener('change', () => {
        // Change content to English
        profileText.innerHTML = `
            I am a Front-End Engineer with about a year of experience in developing web and mobile applications. Recently, I successfully completed the Java Full Stack Bootcamp at Per Scholas and received a certificate for my achievement.

            During the bootcamp, I gained valuable skills in Java programming, Spring Boot, and front-end technologies. I am passionate about using my technical expertise to contribute to a collaborative team environment, where I can leverage my skills and knowledge to make a positive impact.

            My goal is to apply the skills I have acquired from both my past professional experience and the Java Full Stack Bootcamp to work on challenging projects and continue to grow as a developer.
        `;
    });

    spanishRadio.addEventListener('change', () => {
        // Change content to Spanish
        profileText.innerHTML = `
            Soy un ingeniero de Front-End con aproximadamente un año de experiencia en el desarrollo de aplicaciones web y móviles. Recientemente, completé con éxito el Bootcamp de Java Full Stack en Per Scholas y recibí un certificado por mi logro.

            Durante el bootcamp, adquirí habilidades valiosas en programación Java, Spring Boot y tecnologías front-end. Me apasiona utilizar mi experiencia técnica para contribuir a un entorno de trabajo colaborativo, donde pueda aprovechar mis habilidades y conocimientos para tener un impacto positivo.

            Mi objetivo es aplicar las habilidades que he adquirido tanto de mi experiencia profesional pasada como del Bootcamp de Java Full Stack para trabajar en proyectos desafiantes y seguir creciendo como desarrollador.
        `;
    });
</script>
