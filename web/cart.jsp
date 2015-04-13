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
    <link href="css/cart.css" t rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<!-- content -->
<!-- error-page -->
<div class="collections">
    <div class="container">
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
            <button class="checkout">Заказать</button>
        </div>
    </div>
    <!-- /error-page -->
    <!-- /content -->
    <div class="footer">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</div>
<!-- container -->
</body>

<script src="js/cart.js"></script>
<script>
    var total = $("#cart-total").html();
    if (total == 0) {
        $(".checkout").hide();
    }
</script>
</html>
