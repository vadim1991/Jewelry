<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="info" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/widgets/demos.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcore.js"></script>
    <script type="text/javascript" src="js/widgets/jqxlistmenu.js"></script>
    <script type="text/javascript" src="js/widgets/jqxdatatable.js"></script>
    <script type="text/javascript" src="js/widgets/jqxtabs.js"></script>
    <script type="text/javascript" src="js/widgets/jqxmenu.js"></script>
    <script type="text/javascript" src="js/widgets/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="js/widgets/jqxdata.js"></script>
    <script type="text/javascript" src="js/widgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcheckbox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxslider.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcombobox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxscrollbar.js"></script>
    <script src="js/widgets/jqxtabs.js"></script>
    <script src="js/widgets/jqxdatatable.js"></script>
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
        <div class="cart-info dropdown">
            <ul>
                <li><img width="80px" id="avatar" class="img-circle stub" src=${sessionScope.user.image.url}></li>
                <li><a id="login">${sessionScope.login}</a></li>
                <li><a id="loginLink" href="login"><fmt:message key="login"/> </a></li>
                <li class="cartinfo"><a name="cartInfo" href="cart"><span> </span><fmt:message key="cart"/> <b
                        id="amount">${sessionScope.amount}</b></a></li>
                <li>
                    <button class="b-home-lang dropdown-toggle" type="button" id="dLabel" data-toggle="dropdown">
                        <fmt:message key="lang"/> <span
                            class="caret"></span></button>
                    <img id="currentLang" width="30px" src="" class="stub">
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                        <li><a class="lang" href="?lang=ru"><img width="30px" src="images/flags/russia-flag.png"></a>
                        </li>
                        <li><a class="lang" href="?lang=en"><img width="30px"
                                                                 src="images/flags/united-kingdom-flag.png"></a></li>
                        <li><a class="lang" href="?lang=ua"><img width="30px" src="images/flags/ukraine-flag.png"></a>
                        </li>
                    </ul>
                </li>
                <div class="clearfix"></div>
            </ul>
        </div>

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
                <li><a id="main" href="index.jsp"><fmt:message key="main"/></a></li>
                <li><a id="earrings" href="earrings"><fmt:message key="earrings"/></a></li>
                <li><a id="bracelets" href="404.jsp"><fmt:message key="bracelets"/> </a></li>
                <li><a id="rings" href="rings"><fmt:message key="rings"/> </a></li>
                <li><a id="chain" href="404.jsp"><fmt:message key="chain"/> </a></li>
                <c:if test="${not empty sessionScope.login}">
                    <li><a id="history" href="ordersHistory"><fmt:message key="history"/> </a></li>
                </c:if>
                <li><a id="contacts" href="404.jsp"><fmt:message key="contacts"/> </a></li>
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
            <form action="details">
                <input type="text" class="text" name="id" value="Введите код изделия" onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'Введите код изделия';}">
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
    var avatar = $("#avatar");
    avatar.hide();
    var login = $("#login");
    var loginLink = $("#loginLink");
    if (login.text().length > 2) {
        avatar.show();
        loginLink.attr("href", "logout");
        loginLink.text("<fmt:message key="logout"/>");
    }
</script>
<script>
    var flag = $("#currentLang");
    $(".lang").click(function () {
        var img = $(this).find("img");
        var link = img.attr("src");
        $.cookie('flag', link);
    });
    flag.attr("src", $.cookie('flag'));
    flag.show("slow");
</script>
</html>

