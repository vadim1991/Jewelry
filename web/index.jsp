<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 22.03.2015
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ювелирный интернет магазин | Главная</title>
    <!----webfonts--->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,800,400,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
    <!---//webfonts--->
    <script src="js/productIndex.js"></script>
</head>
<body>
<!-- container -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- /sub-header -->
<!-- banner -->
<div class="banner">
    <!--- img-slider --->
    <div class="img-slider">
        <!----start-slider-script---->
        <script src="js/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function () {
                // Slideshow 4
                $("#slider4").responsiveSlides({
                    auto: true,
                    pager: true,
                    nav: true,
                    speed: 500,
                    namespace: "callbacks",
                    before: function () {
                        $('.events').append("<li>before event fired.</li>");
                    },
                    after: function () {
                        $('.events').append("<li>after event fired.</li>");
                    }
                });

            });
        </script>
        <!----//End-slider-script---->
        <!-- Slideshow 4 -->
        <div id="top" class="callbacks_container">
            <ul class="rslides" id="slider4">
                <li>
                    <img class="img-responsive" src="images/slide.jpg" alt="">
                </li>
                <li>
                    <img src="images/slide2.jpg" alt="">
                </li>
                <li>
                    <img src="images/slide.jpg" alt="">
                </li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
    <!-- slider -->
</div>
<!-- banner -->
<!-- Welcome-note -->
<div class="Welcome-note">
    <div class="Welcome-note-left">
        <div class="Welcome-note-left-pic">
            <img src="images/pic1.png" title="name"/>
        </div>
        <div class="Welcome-note-left-pic-info">
            <p>Explore our New Arrivals in <span>Sterling Silver</span> and Exciting new colours in semi precious stone
                jewellery..</p>
        </div>
    </div>
    <div class="Welcome-note-right">
        <p>What is <span>new</span></p>
    </div>
    <div class="clearfix"></div>
</div>
<!-- Welcome-note -->
<!-- content -->
<div class="content">
    <!-- top-grids -->
    <div class="top-grids">
        <div class="container">
            <div class="product-grids">
                <!---
                    <!----sreen-gallery-cursual---->
                <!-- requried-jsfiles-for owl -->
                <link href="css/owl.carousel.css" rel="stylesheet">
                <script src="js/owl.carousel.js"></script>
                <!-- //requried-jsfiles-for owl -->
                <!-- start content_slider -->
                <div id="owl-demo" class="owl-carousel text-center">
                </div>
            </div>
        </div>
    </div>
    <!-- top-grids -->
    <!-- content -->
    <!-- footer -->
    <div class="footer">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <div id="item" class="item stub">
        <div class="product-grid">
            <div class="product-pic">
                <input type="hidden" class="id">
                <a class="link" href="#"><img class="img" src=""/></a>
            </div>
            <div class="product-pic-info">
                <p class="title"></p>
            </div>
        </div>
    </div>
</body>
<script>
    $("#main").parent().addClass("active");
</script>
<script>
    var item = $("#owl-demo");
    $.ajax({
        url: "products",
        method: "post",
        dataType: "json",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var d = data[i];
                var product = new Product(d.id, d.title, d.image.url);
                item.append(product.build());
            }
            item.owlCarousel({
                items: 5,
                lazyLoad: true,
                autoPlay: true,
                navigation: true,
                navigationText: false,
                pagination: false
            });
        }
    })
</script>
</html>
