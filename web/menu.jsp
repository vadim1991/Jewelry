<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Baku Website Template | Home :: w3layouts</title>
    <link href="css/cart/style.css" rel='stylesheet' type='text/css'/>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="css/widget/jqx.base.css"/>
    <link rel="stylesheet" href="css/widget/jqx.black.css"/>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Tangerine">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,800,400,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lobster&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
    <link href="css/design.css" rel="stylesheet">
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/widgets/demos.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcore.js"></script>
    <script type="text/javascript" src="js/widgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcheckbox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxslider.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcombobox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxscrollbar.js"></script>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
</head>
<body>
<!-- container -->
<!-- header -->
<div class="header">
    <div class="container">
        <!-- logo -->
        <div class="logo">
            <a href="index.jsp"><img height="100 %" src="images/logo.png" title="jewelry"/></a>
        </div>
        <!-- logo -->
        <!-- cart-info -->
        <div class="cart-info">
            <ul>
                <li><a id="login">${sessionScope.login}</a></li>
                <li><a id="loginLink" href="login">Войти</a></li>
                <li><a href="#">Язык</a></li>
                <li class="cartinfo"><a name="cartInfo" href="cart"><span> </span>Корзина <b
                        id="amount">${sessionScope.amount}</b></a></li>
                <div class="clearfix"></div>
            </ul>
        </div>
        <!-- /cart-info -->
    </div>
    <!-- header -->
</div>
<!-- sub-header -->
<div class="sub-header">
    <div class="container">
        <!-- top-nav -->
        <div class="top-nav">
            <span class="menu"> </span>
            <ul>
                <li><a id="main" href="index.jsp">Главная</a></li>
                <li><a id="earrings" href="earrings">Серьги</a></li>
                <li><a id="bracelets" href="404.jsp">Браслеты</a></li>
                <li><a id="rings" href="rings">Кольца</a></li>
                <li><a id="chain" href="404.jsp">Цепочки</a></li>
                <li><a id="suspension" href="404.jsp">Подвески</a></li>
                <li><a id="contacts" href="">Контакты</a></li>
                <div class="clearfix"></div>
            </ul>
        </div>
        <!-- top-nav -->
        <!-- script-for-nav -->
        <script>
            $(document).ready(function () {
                $("span.menu").click(function () {
                    $(".top-nav ul").slideToggle(300);
                });
            });
        </script>
        <!-- script-for-nav -->
        <!-- search-form -->
        <div class="search-form">
            <form>
                <input type="text" class="text" value="Введите код изделия" onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'Keyword or product code';}">
                <input type="submit" value=""/>
            </form>
        </div>
        <div class="clearfix"></div>
        <!-- /search-form -->
    </div>
</div>
<!-- /sub-header -->

</body>
<script>
    var login = $("#login");
    var loginLink = $("#loginLink");
    if (login.text().length > 2) {
        loginLink.attr("href", "logout");
        loginLink.text("Выйти");
    }
</script>
</html>

