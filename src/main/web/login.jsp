<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 05.04.2015
  Time: 11:30
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
        <h1>Добро пожаловать</h1>

        <form action="login" method="post">
            <div>
                <label class="error-label">${success}</label>
                <label class="error-label">${error}</label>
                <input type="hidden" name="previous" value="${previous}">
            </div>
            <div>
                <input type="text" class="form-field-login" id="login" name="login" placeholder="логин" onblur="validLogin()">
                <label class="error-label" id="loginError"></label>
            </div>
            <div>
                <input type="password" class="form-field-login" id="password" name="password" placeholder="пароль"
                       onblur="validPassword()">
                <label class="error-label" id="passwordError"></label>
            </div>
            <div>
                <input id="button" type="submit" onclick="return isValid()" name="button" value="Вход">
                <a class="b-home" href="registration">Регистрация</a>
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
    function validLogin() {
        var login = document.getElementById("login");
        var label = document.getElementById("loginError");
        if (login.value.length < '2' || login.value.length > '15') {
            label.innerHTML = "Пожалуйста, введите корректный логин"
            return false;
        } else {
            label.innerHTML = "";
            return true;
        }
    }
    function validPassword() {
        var login = document.getElementById("password");
        var label = document.getElementById("passwordError");
        if (login.value.length < '2' || login.value.length > '20') {
            label.innerHTML = "Пожалуйста, введите корректный пароль"
            return false;
        } else {
            label.innerHTML = "";
            return true;
        }
    }
    function isValid() {
        return validLogin() && validPassword();
    }
</script>
</html>
