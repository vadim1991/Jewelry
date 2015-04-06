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
    <title>404</title>
    <link href="css/cart.css" t rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<!-- content -->
<!-- error-page -->
<div class="container">
    <h1>Shopping Cart</h1>

    <div class="shopping-cart">

        <div class="column-labels">
            <label class="product-image">Image</label>
            <label class="product-details">Product</label>
            <label class="product-price">Price</label>
            <label class="product-quantity">Quantity</label>
            <label class="product-removal">Remove</label>
            <label class="product-line-price">Total</label>
        </div>
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
                        Remove
                    </button>
                </div>
                <div class="product-line-price"></div>
            </div>
        </c:forEach>

        <div class="totals">
            <div class="totals-item">
                <label>Subtotal</label>

                <div class="totals-value" id="cart-subtotal">${total}</div>
            </div>
            <div class="totals-item">
                <label>Tax (5%)</label>

                <div class="totals-value" id="cart-tax">3.60</div>
            </div>
            <div class="totals-item">
                <label>Shipping</label>

                <div class="totals-value" id="cart-shipping">0</div>
            </div>
            <div class="totals-item totals-item-total">
                <label>Grand Total</label>

                <div class="totals-value" id="cart-total">${total}</div>
            </div>
        </div>

        <button class="checkout">Checkout</button>

    </div>
</div>
<!-- /error-page -->
<!-- /content -->
<div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<!-- container -->
</body>

<script src="js/cart.js"></script>
</html>
