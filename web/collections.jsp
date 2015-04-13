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
<script>
    $(document).ready(function () {
        $("#rings").parent().addClass("active")
    });
</script>
<div class="content">
    <div class="collections">
        <div class="collections-head">
            <div class="container">
                <div class="collections-head-left">
                    <img src="images/iteam.png" alt="slide"/>
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
                        <input type="hidden" class="id" name="id" value="${p.id}"/>

                        <div class="iteam-grid text-center">
                            <img height="150 px" src=${p.image.url} title=${p.title}>
                            <span>${p.title}</span>
                            <label>Цена $ ${p.price}</label>
                            <ul>
                                <li><a class="cart" href="#cartInfo">В корзину</a></li>
                                <li><a class="more" href="details?id=${p.id}">Инфо</a></li>
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
</div>
</body>
<script>
    $(".cart").click(function () {
        var id = $(this).parent().parent().parent().parent().find(".id").val();
        $.ajax({
            url: "cart",
            method: "get",
            dataType: "text",
            data: {
                "id": id
            },
            success: function (data) {
                $("#amount").html(data);
            }
        })
    })
</script>
</html>
