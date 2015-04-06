<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 29.03.2015
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="css/justified-nav.css" rel="stylesheet">
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/jquery-ui.js"></script>
</head>
<body>
<div class="container">
    <h1>Список продуктов</h1>

    <div id="productList">
        <c:forEach items="${products}" var="p">
            <div class="product">
                <input type="hidden" name="id" value="${p.id}"/>
                <img align="center" height="150px" class="img-rounded" src=${p.image.url}>

                <p class="title">${p.title}</p>

                <p class="title">${p.price}</p>

                <p class="title">
                    <button id="button" class="btn btn-primary">Add to cart</button>
                </p>
            </div>
        </c:forEach>
    </div>
</div>

</body>
<script>
    var status = 0;
    $("#productList").sortable();
    $(".product").draggable({
        revert: true
    });
    $("button").click(function () {
        status++;
        var button = $(this);
        button.addClass("btn btn-info");
        if ((status % 2) == 0) {
            button.removeClass();
        }
        var div = button.parent().parent();
        alert("status" + status);
        //alert(div.find("input:hidden").val());
    })
</script>
</html>
