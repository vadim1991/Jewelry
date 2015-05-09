<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 10.04.2015
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Кольца</title>
    <script src="js/product.js"></script>
</head>
<body>
<!-- container -->
<jsp:include page="menu.jsp"></jsp:include>
<script>
    $(document).ready(function () {
        $("#rings").parent().addClass("active")
    });
</script>
<!-- content -->
<div class="content">
    <div class="collections">
        <div class="collections-head">
            <div class="container">
                <div class="collections-head-right">
                    <img height="300px" src="images/iteam.png" alt="slide"/>
                </div>
                <div class="collections-head-left">
                    <h2><span><fmt:message key="french"/></span></br><span><fmt:message key="design"/> </span></h2>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- categories -->
        <!-- categories -->
        <div class="categories">
            <div class="container">
                <div class="categories-left">
                    <ul>
                        <li><a name="insert" class="diamonds" href="#insert"><fmt:message key="diamonds"/></a></li>
                        <li><a class="emerald" href="#insert"><fmt:message key="emerald"/></a></li>
                        <li><a class="ruby" href="#insert"><fmt:message key="ruby"/></a></li>
                        <li><a class="fianit" href="#insert"><fmt:message key="fianit"/></a></li>
                        <li><a class="none" href="#insert"><fmt:message key="none"/></a></li>
                    </ul>
                </div>
                <div class="categories-right">
                    <ul>
                        <li>
                            <button class="previous"><fmt:message key="previous"/></button>
                        </li>
                        <li>
                            <label id="pageNumber">1</label>
                        </li>
                        <li>
                            <button class="next"><fmt:message key="next"/></button>
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
            <div class="container-left">
                <div class="filter-form">

                    <div class="filter-div">
                        <h3>
                            <fmt:message key="filter"/>
                        </h3>
                    </div>
                    <span style="font-style: italic;"><fmt:message key="price"/></span>

                    <div id='redLevel'>
                    </div>
                    <div>
                        <input class="search-field" type="text" name="minPrice" id="startPrice" value="0">
                        <input class="search-field" type="text" name="maxPrice" id="endPrice" value="20000">
                    </div>
                    <span style="font-style: italic;"><fmt:message key="weight"/></span>

                    <div id='greenLevel'>
                    </div>
                    <div>
                        <input class="search-field" type="text" name="minWeight" id="startWeigh" value="0">
                        <input class="search-field" type="text" name="maxWeight" id="endWeight"
                               value="10.0">
                    </div>
                    <span style="font-style: italic;"><fmt:message key="material"/></span>

                    <div class="filter-div" id='selectMaterial'>
                    </div>
                    <input type="hidden" name="material" id="material">
                    <input type="hidden" name="insert" id="insert">
                    <input type="hidden" name="sortType" id="sortType" value="1">
                    <span style="font-style: italic;"><fmt:message key="insert"/></span>

                    <div class="filter-div" id='selectInsert'>
                    </div>
                    <span style="font-style: italic;"><fmt:message key="sort"/> </span>

                    <div class="filter-div" id='selectSortType'>
                    </div>

                    <div>
                        <button id="search" class="b-home"><fmt:message key="search"/></button>
                    </div>
                </div>
            </div>
            <div class="container-right">
                <h1 id="incorrectFilter" class="error-page text-center stub">По данному запросу ничего не найдено</h1>

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
                        <li><a class="diamonds" href="#insert"><fmt:message key="diamonds"/> </a></li>
                        <li><a class="emerald" href="#insert"><fmt:message key="emerald"/></a></li>
                        <li><a class="ruby" href="#insert"><fmt:message key="ruby"/></a></li>
                        <li><a class="fianit" href="#insert"><fmt:message key="fianit"/></a></li>
                        <li><a class="none" href="#insert"><fmt:message key="none"/></a></li>
                    </ul>
                </div>
                <div class="categories-right">
                    <ul>
                        <li>
                            <button class="previous"><fmt:message key="previous"/></button>
                        </li>
                        <li>
                            <button class="next"><fmt:message key="next"/></button>
                        </li>
                        <div class="clearfix"></div>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</div>
<div id="product-stub" class="col-md-4 stub">

    <div class="iteam-grid text-center">
        <img height="150 px" class="image" src="" title="">
        <span class="title"></span>
        <label class="price"></label>
        <ul>
            <input type="hidden" class="id" name="id"/>
            <li><a class="cart" href="#cartInfo"><fmt:message key="to_cart"/></a></li>
            <li><a class="more" href=""><fmt:message key="detailed"/></a></li>
            <div class="clearfix"></div>
        </ul>
    </div>
</div>
</body>
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
            "<fmt:message key="red_gold"/>",
            "<fmt:message key="white_gold"/>",
            "<fmt:message key="platinum"/>",
            "<fmt:message key="silver"/>"
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
            "<fmt:message key="diamonds"/>",
            "<fmt:message key="emerald"/>",
            "<fmt:message key="ruby"/>",
            "<fmt:message key="fianit"/>",
            "<fmt:message key="circon"/>",
            "<fmt:message key="sapphire"/>",
            "<fmt:message key="none"/>"

        ];
        // Create a jqxComboBox
        selectInsert.jqxComboBox({
            selectedIndex: 0,
            source: source,
            displayMember: "insert",
            valueMember: "insert",
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
            "<fmt:message key="asc"/>",
            "<fmt:message key="desc"/>"
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
            $("#sortType").val(args.index + 1);
        });
    });
</script>
<script>
    var currentPage = 1;
    var pages;
    var next = $(".next");
    var previous = $(".previous");
    var container = $(".container-right");
    var incorrectFilterMessage = $("#incorrectFilter");
    $.ajax({
        url: "rings",
        method: "post",
        dataType: "json",
        success: function (data) {
            parseData(data, container)
        }
    });
    $("#search").click(function () {
        rewriteProduct(currentPage);
    });
    function parseData(data, container) {
        currentPage = data.currentPage;
        pages = data.noOfPages;
        $("#pageNumber").text(currentPage);
        for (var i = 0; i < data.products.length; i++) {
            var d = data.products[i];
            var product = new ProductObject(d.id, d.image.url, d.title, d.price).build();
            container.append(product);
            container.show("slow");
        }
        if (currentPage == 1) {
            previous.attr("disabled", true)
        }
        else {
            previous.removeAttr("disabled")
        }
        if (currentPage == pages) {
            next.attr("disabled", true)
        } else {
            next.removeAttr("disabled")
        }
    }
    function rewriteProduct(currentPage) {
        var container = $(".container-right");
        container.empty();
        container.hide();
        var startPrice = $("#startPrice").val();
        var endPrice = $("#endPrice").val();
        var startWeight = $("#startWeigh").val();
        var endWeight = $("#endWeight").val();
        var material = $("#material").val();
        var insert = $("#insert").val();
        var sortType = $("#sortType").val();
        $.ajax({
            url: "rings",
            method: "post",
            dataType: "json",
            data: {
                "minPrice": startPrice,
                "maxPrice": endPrice,
                "minWeight": startWeight,
                "maxWeight": endWeight,
                "insert": insert,
                "material": material,
                "sortType": sortType,
                "page": currentPage
            },
            success: function (data) {
                if (data.products.length == 0) {
                    container.append(incorrectFilterMessage);
                    container.show("slow");
                    incorrectFilterMessage.show("slow");
                }
                parseData(data, container)
            }
        })
    }
    next.click(function () {
        rewriteProduct(currentPage + 1)
    });
    previous.click(function () {
        rewriteProduct(currentPage - 1)
    });
    function chooseInsert(insertId) {
        var container = $(".container-right");
        $("#insert").val(insertId);
        container.empty();
        container.hide();
        var sortType = $("#sortType").val();
        $.ajax({
            url: "rings",
            method: "post",
            dataType: "json",
            data: {
                "sortType": sortType,
                "insert": insertId
            },
            success: function (data) {
                if (data.noOfPages < 1) {
                    container.append(incorrectFilterMessage);
                    container.show("slow");
                    incorrectFilterMessage.show("slow");
                }
                parseData(data, container)
            }
        })
    }
    function removeActiveClass(object) {
        var active = "active";
        $(".diamonds").removeClass(active);
        $(".emerald").removeClass(active);
        $(".fianit").removeClass(active);
        $(".ruby").removeClass(active);
        $(".none").removeClass(active);
        object.addClass("active");
    }
    $(".diamonds").click(function () {
        removeActiveClass($(this));
        chooseInsert(1);
    });
    $(".emerald").click(function () {
        removeActiveClass($(this));
        chooseInsert(2);
    });
    $(".fianit").click(function () {
        removeActiveClass($(this));
        chooseInsert(4);
    });
    $(".ruby").click(function () {
        removeActiveClass($(this));
        chooseInsert(3);
    });
    $(".none").click(function () {
        removeActiveClass($(this));
        chooseInsert(7);
    });
</script>

</html>
