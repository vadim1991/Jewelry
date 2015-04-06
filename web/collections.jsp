<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 04.04.2015
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Кольца</title>
</head>
<body>
<!-- container -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- content -->
<div class="collections">
    <div class="collections-head">
        <div class="container">
            <div class="collections-head-left">
                <img src="images/iteam.png" title="name"/>
            </div>
            <div class="collections-head-right">
                <h2><span>Итальянское</span></br><span>серебро</span></h2>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- categories -->
    <div class="categories">
        <div class="container">
            <div class="categories-left">
                <ul>
                    <li><a href="#">С бриллиантом</a></li>
                    <li><a href="#">С изумрудом</a></li>
                    <li><a href="#">Без вставки</a></li>
                </ul>
            </div>
            <div class="categories-right">
                <ul>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li class="view"><a href="#">View All</a></li>
                    <li class="options">
                        <select>
                            <option>Sorted by</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                        </select>
                    </li>
                    <div class="clearfix"></div>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- categories -->
    <!-- iteam-grids -->
    <div class="iteam-grids">
        <div class="container">
            <c:forEach items="${products}" var="p">
                <div class="col-md-3">
                    <input type="hidden" name="id" value="${p.id}"/>
                    <div onclick="location.href='details?id=${p.id}';" class="iteam-grid text-center">
                        <img height="150 px" src=${p.image.url} title=${p.title}>
                        <span>${p.title}</span>
                        <label>Цена $ ${p.price}</label>
                        <ul>
                            <li><a class="cart" href="#">В корзину</a></li>
                            <li><a class="more" href="#">Инфо</a></li>
                            <div class="clearfix"></div>
                        </ul>
                    </div>
                </div>
            </c:forEach>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- iteam-grids -->
</div>
<!-- content -->
<!-- footer -->
<div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
