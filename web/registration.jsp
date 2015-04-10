<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 05.04.2015
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<!-- content -->
<div class="container">

    <div class="text-left">
        <h1>Регистрация</h1>

        <form action="registration" method="post">
            <div>
                <label class="error-label">${loginError}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="name" name="name" placeholder="Имя" onblur="validName()">
                <label class="error-label" id="nameError">${errors.get("nameError")}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="surname" name="surname" placeholder="Фамилия"
                       onblur="validSurname()">
                <label class="error-label" id="surnameError">${errors.get("surnameError")}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="age" name="age" placeholder="Возраст"
                       onblur="validAge()">
                <label class="error-label" id="ageError">${errors.get("ageError")}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="email" name="email" placeholder="Email" onblur="validEmail()">
                <label class="error-label" id="emailError">${errors.get("emailError")}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="login" name="login" placeholder="Логин" onblur="validLogin()">
                <label class="error-label" id="loginError">${errors.get("loginError")}</label>
            </div>
            <div>
                <input type="password" class="form-field" id="password" name="password" placeholder="пароль"
                       onblur="validPassword()">
                <label class="error-label" id="passwordError">${errors.get("passwordError")}</label>
            </div>
            <div>
                <input type="password" class="form-field" name="confirm" id="passwordConfirm"
                       placeholder="подтвердите пароль"
                       onblur="confirmPassword()">
                <label class="error-label" id="passwordConfError">${errors.get("confirmError")}</label>
            </div>
            <div>
                <img src="/captcha" alt="captcha">

                <p>${simpleCaptcha}</p>
            </div>
            <div>
                <input type="text" class="form-field" id="captcha" placeholder="введите текст с картинки">
                <label class="error-label" id="captchaError"></label>
            </div>
            <div>
                <input id="button" type="submit" name="button" onclick="return isValid()" value="Регистрация">
                <a class="b-home" href="index.jsp">На главную</a>
            </div>
        </form>
    </div>
</div>
<div class="banner">
    <!--- img-slider --->
    <div class="img-slider">
        <!----start-slider-script---->
        <script src="js/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function () {
                // Slideshow 4
                $("#slider4").responsiveSlides({
                    auto: true,
                    pager: true,
                    nav: true,
                    speed: 500,
                    namespace: "callbacks",
                    before: function () {
                        $('.events').append("<li>before event fired.</li>");
                    },
                    after: function () {
                        $('.events').append("<li>after event fired.</li>");
                    }
                });

            });
        </script>
        <!----//End-slider-script---->
        <!-- Slideshow 4 -->
        <div id="top" class="callbacks_container">
            <ul class="rslides" id="slider4">
                <li>
                    <img class="img-responsive" src="images/slide4.jpg" alt="">
                </li>
                <li>
                    <img src="images/slide3.png" alt="">
                </li>
                <li>
                    <img src="images/slide4.jpg" alt="">
                </li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
    <!-- slider -->
</div>
<!-- banner -->
<!-- /content -->
<div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<!-- container -->
</body>
<script>
    var classForm = "form-field";
    function validName() {
        var name = document.getElementById("name");
        var label = document.getElementById("nameError");
        var pattern = /^[\p{L} .'-]+$/;
        if (!pattern.test(name.value)) {
            label.innerHTML = "Введите, пожалуйста корректное имя";
            name.className = "error";
            return false;
        } else {
            label.innerHTML = null;
            name.className = classForm;
            return true;
        }
    }
    function validSurname() {
        var surname = document.getElementById("surname");
        var label = document.getElementById("surnameError");
        var pattern = /^[\p{L} .'-]+$/;
        if (!pattern.test(surname.value)) {
            label.innerHTML = "Введите, пожалуйста корректную фамилию";
            surname.className = "error";
            return false;
        } else {
            label.innerHTML = null;
            surname.className = classForm;
            return true;
        }
    }
    function validAge() {
        var age = document.getElementById("age");
        var label = document.getElementById("ageError");
        var pattern = /^\d{1,3}$/
        if (!pattern.test(age.value) || age.value < 14 || age.value > 80) {
            label.innerHTML = "Введите, пожалуйста корректный возраст";
            age.className = "error";
            return false;
        } else {
            label.innerHTML = null;
            age.className = classForm;
            return true;
        }
    }
    function validEmail() {
        var email = document.getElementById("email");
        var label = document.getElementById("emailError");
        var pattern = /^.+@.+[.].{2,}$/i;
        if (!(pattern.test(email.value))) {
            label.innerHTML = "Пожалуйста, введите корректный email";
            email.className = "error";
            return false;
        } else {
            label.innerHTML = null;
            email.className = classForm;
            return true;
        }
    }
    function validLogin() {
        var login = document.getElementById("login");
        var label = document.getElementById("loginError");
        var pattern = /^[\p{L} .'-]+$/;
        if (!pattern.test(login.value)) {
            label.innerHTML = "Пожалуйста, введите другой логин";
            login.className = "error";
            return false;
        } else {
            label.innerHTML = null;
            login.className = classForm;
            return true;
        }
    }
    function validPassword() {
        var password = document.getElementById("password");
        var label = document.getElementById("passwordError");
        var pattern = /((?=.*\d)(?=.*[a-z]).{4,20})/
        if (!pattern.test(password.value)) {
            label.innerHTML = "Пожалуйста, введите другой пароль"
            password.className = "error";
            return false;
        } else {
            label.innerHTML = null;
            password.className = classForm;
            return true;
        }
    }
    function confirmPassword() {
        var password = document.getElementById("password");
        var passwordConfirm = document.getElementById("passwordConfirm");
        var label = document.getElementById("passwordConfError");
        if ((!(password.value == passwordConfirm.value) || passwordConfirm.value.length < 4)) {
            label.innerHTML = "Подтвердите пароль!!!";
            passwordConfirm.className = "error";
            return false;
        } else {
            label.innerHTML = null;
            passwordConfirm.className = classForm;
            return true;
        }
    }
    function isValid() {
        return validName() && validEmail() && validLogin() && validPassword() && validSurname() && confirmPassword() && validAge();
    }

</script>
</html>
