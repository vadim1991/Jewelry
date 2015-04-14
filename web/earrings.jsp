<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 10.04.2015
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Серьги</title>
</head>
<body>
<!-- container -->
<jsp:include page="menu.jsp"></jsp:include>
<script>
    $(document).ready(function () {
        $("#earrings").parent().addClass("active")
    });
</script>
<!-- content -->
<div class="content">
    <div class="collections">
        <div class="collections-head">
            <div class="container">
                <div class="collections-head-right">
                    <img height="300px" src="images/slideEarrings.png" alt="slide"/>
                </div>
                <div class="collections-head-left">
                    <h2><span>Французский</span></br><span>дизайн</span></h2>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- categories -->
        <div class="categories">
            <div class="container">
                <div class="categories-left">
                    <ul>
                        <li><a href="earrings?insert=1">С бриллиантом</a></li>
                        <li><a href="earrings?insert=2">С изумрудом</a></li>
                        <li><a href="earrings?insert=3">С рубином</a></li>
                        <li><a href="earrings?insert=4">С фианитом</a></li>
                        <li><a href="earrings?insert=7">Без вставки</a></li>
                    </ul>
                </div>
                <div class="categories-right">
                    <ul>
                        <c:if test="${currentPage!=1}">
                            <li><a href="earrings?page=${currentPage-1}">Предыдущая</a></li>
                        </c:if>
                        <c:if test="${currentPage lt noOfPages}">
                            <li><a href="earrings?page=${currentPage+1}">Следущая</a></li>
                        </c:if>
                        <div class="clearfix"></div>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- categories -->
        <!-- iteam-grids -->
        <div class="iteam-grids">
            <div class="container-left">
                <form action="earrings">
                    <div class="filter-form">

                        <div class="filter-div">
                            <h3>
                                Фильтр
                            </h3>
                        </div>
                        <span style="font-style: italic;">Цена изделия</span>

                        <div id='redLevel'>
                        </div>
                        <div>
                            <input class="search-field" type="text" name="minPrice" id="startPrice" value="0">
                            <input class="search-field" type="text" name="maxPrice" id="endPrice" value="20000">
                        </div>
                        <span style="font-style: italic;">Вес изделия</span>

                        <div id='greenLevel'>
                        </div>
                        <div>
                            <input class="search-field" type="text" name="minWeight" id="startWeigh" value="0">
                            <input class="search-field" type="text" name="maxWeight" id="endWeight"
                                   value="10.0">
                        </div>
                        <span style="font-style: italic;">Материал</span>

                        <div class="filter-div" id='selectMaterial'>
                        </div>
                        <input type="hidden" name="material" id="material" value="1">
                        <input type="hidden" name="insert" id="insert" value="1">
                        <input type="hidden" name="sortType" id="sortType" value="1">
                        <span style="font-style: italic;">Вставка</span>

                        <div class="filter-div" id='selectInsert'>
                        </div>
                        <span style="font-style: italic;">Сортировать </span>

                        <div class="filter-div" id='selectSortType'>
                        </div>

                        <div>
                            <input type="submit" class="b-home" value="Поиск">
                        </div>
                    </div>


                </form>
            </div>
            <div class="container-right">
                <c:forEach items="${products}" var="p">
                    <div class="col-md-4">
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
    <div class="footer" style="padding-top: 0px">
        <div class="categories">
            <div class="container">
                <div class="categories-left">
                    <ul>
                        <li><a href="earrings?insert=1">С бриллиантом</a></li>
                        <li><a href="earrings?insert=2">С изумрудом</a></li>
                        <li><a href="earrings?insert=3">С рубином</a></li>
                        <li><a href="earrings?insert=4">С фианитом</a></li>
                        <li><a href="earrings?insert=7">Без вставки</a></li>
                    </ul>
                </div>
                <div class="categories-right">
                    <ul>
                        <c:if test="${currentPage!=1}">
                            <li><a href="earrings?page=${currentPage-1}">Предыдущая</a></li>
                        </c:if>
                        <c:if test="${currentPage lt noOfPages}">
                            <li><a href="earrings?page=${currentPage+1}">Следущая</a></li>
                        </c:if>
                        <div class="clearfix"></div>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
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
<script type="text/javascript">
    $(document).ready(function () {
        var start = $("#startPrice");
        var end = $("#endPrice");
        var startWeight = $("#startWeigh");
        var endWeight = $("#endWeight");
        $('#redLevel').jqxSlider({
            theme: "black",
            min: 0,
            max: 20000,
            step: 200,
            ticksFrequency: 1000,
            mode: 'fixed',
            values: [0, 20000],
            rangeSlider: true,
            width: "90%"
        });
        $('#greenLevel').jqxSlider({
            theme: "black",
            min: 0,
            max: 10.0,
            step: 0.4,
            ticksFrequency: 0.6,
            mode: 'fixed',
            values: [0, 10.0],
            rangeSlider: true,
            width: "90%"
        });
        $('#redLevel').on('change', function (event) {
            start.val($('#redLevel').jqxSlider('value').rangeStart);
            end.val($('#redLevel').jqxSlider('value').rangeEnd);
        });
        $('#greenLevel').on('change', function (event) {
            startWeight.val($('#greenLevel').jqxSlider('value').rangeStart);
            endWeight.val($('#greenLevel').jqxSlider('value').rangeEnd);
        });
        $('#blueLevel').on('change', function (event) {
            setColor();
        });

    })
    ;
</script>
<script>
    $(document).ready(function () {
        var selectMaterial = $("#selectMaterial");
        var source = [
            "Красное золото",
            "Белое золото",
            "Платина",
            "Серебро"
        ];
        // Create a jqxComboBox
        selectMaterial.jqxComboBox({
            source: source,
            selectedIndex: 0,
            width: '50%',
            height: '25px',
            theme: 'black'
        });
        selectMaterial.bind('select', function (event) {
            var args = event.args;
            var item = selectMaterial.jqxComboBox('getItem', args.index);
            $("#material").val(args.index + 1);
        });
    });
</script>
<script>
    $(document).ready(function () {
        var selectInsert = $("#selectInsert");
        var source = [
            "Бриллиант",
            "Изумруд",
            "Рубин",
            "Фианит",
            "Цирконий",
            "Сапфир",
            "Без вставки"

        ];
        // Create a jqxComboBox
        selectInsert.jqxComboBox({
            source: source,
            selectedIndex: 0,
            width: '50%',
            height: '25px',
            theme: 'black'
        });
        selectInsert.bind('select', function (event) {
            var args = event.args;
            var item = selectInsert.jqxComboBox('getItem', args.index);
            $("#insert").val(args.index + 1);
        });
    });
</script>
<script>
    $(document).ready(function () {
        var selectSortType = $("#selectSortType");
        var source = [
            "по возрастанию цены",
            "по убыванию цены",
        ];
        // Create a jqxComboBox
        selectSortType.jqxComboBox({
            source: source,
            selectedIndex: 0,
            width: '50%',
            height: '25px',
            theme: 'black'
        });
        selectSortType.bind('select', function (event) {
            var args = event.args;
            var item = selectInsert.jqxComboBox('getItem', args.index);
            $("#sortType").val(args.index + 1);
        });
    });
</script>
</html>