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
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Tangerine">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,800,400,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lobster&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/design.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <!-- Custom Theme files -->
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
            <a href="index.jsp"><img height="120 px" src="images/logo.png" title="jewelry"/></a>
            <a href="index.jsp"><img height="120 px" src="images/logoGif.gif" title="jewelry"/></a>
        </div>
        <!-- logo -->
        <!-- cart-info -->
        <div class="cart-info">
            <ul>
                <li><a href="login.jsp">Войти</a></li>
                <li><a href="#">Помощь</a></li>
                <li><a href="#">Магазин</a></li>
                <li class="cartinfo"><a href="#"><span> </span>Корзина (0)</a></li>
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
                <li class="active"><a href="index.jsp">Главная</a></li>
                <li><a href="404.jsp">Серьги</a></li>
                <li><a href="404.jsp">Браслеты</a></li>
                <li><a href="rings">Кольца</a></li>
                <li><a href="404.jsp">Цепочки</a></li>
                <li><a href="404.jsp">Подвески</a></li>
                <li><a href="">Контакты</a></li>
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
</html>

