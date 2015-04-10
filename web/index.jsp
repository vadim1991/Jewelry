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
</head>
<!----webfonts--->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,800,400,600' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
<!---//webfonts--->
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
                <script>
                    $(document).ready(function () {
                        $("#owl-demo").owlCarousel({
                            items: 5,
                            lazyLoad: true,
                            autoPlay: true,
                            navigation: true,
                            navigationText: false,
                            pagination: false
                        });
                    });
                </script>
                <!-- //requried-jsfiles-for owl -->
                <!-- start content_slider -->
                <div id="owl-demo" class="owl-carousel text-center">
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic2.jpg" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic3.png" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic4.png" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic5.png" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic6.png" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic3.png" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic4.png" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic5.png" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
                    <div onclick="location.href='404.jsp';" class="item">
                        <div class="product-grid">
                            <div class="product-pic">
                                <a href="#"><img src="images/pic3.png" title="name"/></a>
                            </div>
                            <div class="product-pic-info">
                                <p>Astley Aquamarine</p>
                            </div>
                        </div>
                    </div>
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
</body>
<script>
    $("#main").parent().addClass("active");
</script>
</html>
