<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 02.04.2015
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
    <link href="css/cart.css" rel="stylesheet">
    <script src="js/orderList.js"></script>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<!-- content -->
<!-- error-page -->
<div class="collections">
    <div id="mainContainer" class="container">
        <div id="cart">
            <h1>Корзина изделий</h1>

            <div class="shopping-cart">

                <div class="column-labels">
                    <label class="product-image">Фото</label>
                    <label class="product-details">Изделие</label>
                    <label class="product-price">Цена</label>
                    <label class="product-quantity">Количество</label>
                    <label class="product-removal">Удалить</label>
                    <label class="product-line-price">Общая</label>
                </div>
                <c:set var="index" value="0"></c:set>
                <c:forEach var="product" items="${cart}">
                    <div class="product">
                        <input type="hidden" id="id" value="${product.key.id}">

                        <div class="product-image">
                            <img src=${product.key.image.url}>
                        </div>
                        <div class="product-details">
                            <div class="product-title">${product.key.title}</div>
                            <p class="product-description">${product.key.description}</p>
                        </div>
                        <div class="product-price">${product.key.price}</div>
                        <div class="product-quantity">
                            <input class="count" type="number" value=${product.value} min="1">
                        </div>
                        <div class="product-removal">
                            <button class="remove-product">
                                Удалить
                            </button>
                        </div>
                        <div class="product-line-price">${prices.get(index)}</div>
                    </div>
                    <c:set value="${index+1}" var="index"></c:set>
                </c:forEach>

                <div class="totals">

                    <div class="totals-item totals-item-total">
                        <label>Общая стоимость: </label>

                        <div class="totals-value" id="cart-total">${total}</div>
                    </div>
                </div>
                <button id="toOrder" class="checkout">Заказать</button>
            </div>
        </div>
    </div>
    <!-- /error-page -->
    <!-- /content -->
</div>
<div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<!-- container -->
<div id="success" class="text-center stub" style="margin-bottom: 3em;margin-top: 3em">
    <h1>Вы успешно оформили заказ. Спасибо</h1>
    <a class="b-home" href="index.jsp">На главную</a>
</div>
<div id="makeOrder" class="text-center stub">
    <h1>Подтверждение заказа</h1>

    <div>
        <label class="error-label">${success}</label>
        <label class="error-label">${error}</label>
        <input type="hidden" name="previous" value="${previous}">
    </div>

    <div class="cartDiv">

        <ul id="containerOrders">
        </ul>

        <div class="cart-bottom">
            <span class="total"></span>
            <a id="confirmOrder" href="#" class="cart-button">Оформить</a>
        </div>
    </div>
    <button id="toCart" class="checkout-left">Назад</button>
</div>
<li id="cartItem" class="cart-item stub">
        <span class="cart-item-pic">
          <img class="image" src="">
        </span>
    <span class="title"></span>
    <span class="cart-item-desc"></span>
    <span class="cart-item-price"></span>
</li>
</body>

<script src="js/cart.js"></script>
<script>
    var total = $("#cart-total").html();
    if (total == 0) {
        $(".checkout").hide();
    }
</script>
<script>
    var container = $("#mainContainer");
    var cart = $("#cart");
    var order = $("#makeOrder");
    $("#toOrder").click(function () {
        if ($("#login").text().length > 2) {
            cart.hide("slow");
            $.ajax({
                url: "cart",
                method: "get",
                dataType: "json",
                data: {
                    "getAll": "get"
                },
                success: function (data) {
                    var orderContainer = $("#containerOrders");
                    orderContainer.empty();
                    for (var i = 0; i < data.cart.length; i++) {
                        var prod = data.cart[i];
                        var item = new Product(prod.image.url, prod.title, prod.description, data.prices[i]);
                        orderContainer.append(item.build());
                        orderContainer.show("slow");
                    }
                    orderContainer.parent().find(".total").text("К оплате: " + data.total);
                }
            });
            setTimeout(function () {
                container.append(order);
                order.show("slow");
            }, 500);
        } else {
            window.location = "login"
        }
    });
    $("#toCart").click(function () {
        order.hide("slow");
        setTimeout(function () {
            cart.show("slow");
        }, 500);
    });
    $("#confirmOrder").click(function () {
        $.ajax({
            url: "order",
            method: "post",
            dataType: "text",
            data: {
                "makeOrder": true
            },
            success: function (data) {
                if (data == "success") {
                    $("#mainContainer").append($("#success"));
                    $("#makeOrder").hide("slow");
                    $("#success").show("slow");
                    $("#amount").html(0);
                }
            }
        })
    })
</script>
</html>
