<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 05.04.2015
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="info" %>
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
                <input type="text" class="form-field" id="name" name="name" value="${form.name}" placeholder="Имя"
                       onblur="validName()">
                <label class="error-label" id="nameError">${errors.get("nameError")}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="surname" name="surname" value="${form.surname}"
                       placeholder="Фамилия"
                       onblur="validSurname()">
                <label class="error-label" id="surnameError">${errors.get("surnameError")}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="age" name="age" value="${form.age}" placeholder="Возраст"
                       onblur="validAge()">
                <label class="error-label" id="ageError">${errors.get("ageError")}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="email" name="email" value="${form.email}" placeholder="Email"
                       onblur="validEmail()">
                <label class="error-label" id="emailError">${errors.get("emailError")}</label>
            </div>
            <div>
                <input type="text" class="form-field" id="login" name="login" value="${form.login}" placeholder="Логин"
                       onblur="validLogin()">
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
                <info:captcha captchaID="" errorCaptcha=""></info:captcha>
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
<script src="js/validate.js">
</script>
</html>
