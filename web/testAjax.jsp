<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 14.04.2015
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if (IE 7)&!(IEMobile)]>
<html class="no-js lt-ie9 lt-ie8" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]>
<html class="no-js lt-ie9" lang="en"><![endif]-->
<!--[if (IE 9)]>
<html class="no-js ie9" lang="en"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en-US"> <!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>INDEX_TITLE</title>

    <!-- Mobile Specifics -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="HandheldFriendly" content="true"/>
    <meta name="MobileOptimized" content="320"/>

    <!--[if IEMobile]>
    <meta http-equiv="cleartype" content="on">
    <![endif]-->

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Main Style -->
    <link href="css/main.css" rel="stylesheet">

    <!-- Supersized -->
    <link href="css/supersized.css" rel="stylesheet">
    <link href="css/supersized.shutter.css" rel="stylesheet">

    <!-- FancyBox -->
    <link href="css/fancybox/jquery.fancybox.css" rel="stylesheet">

    <!-- Font Icons -->
    <link href="css/fonts.css" rel="stylesheet">

    <!-- Shortcodes -->
    <link href="css/shortcodes.css" rel="stylesheet">

    <!-- Responsive -->
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">

    <!-- Supersized -->
    <link href="css/supersized.css" rel="stylesheet">
    <link href="css/supersized.shutter.css" rel="stylesheet">

    <!-- Google Font -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,200italic,300,300italic,400italic,600,600italic,700,700italic,900'
          rel='stylesheet' type='text/css'>

    <!-- Fav Icon -->
    <link rel="shortcut icon" href="favicon.png">

    <link rel="apple-touch-icon" href="favicon.png">
    <link rel="apple-touch-icon" sizes="114x114" href="favicon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="favicon.png">
    <link rel="apple-touch-icon" sizes="144x144" href="favicon.png">

    <!-- Modernizr -->
    <script src="js/lib/modernizr.js"></script>
</head>

<body>

<!-- This section is for Splash Screen -->
<div class="ole">
    <section id="jSplash">
        <div id="circle"></div>
    </section>
</div>
<!-- End of Splash Screen -->

<!-- Homepage Slider -->
<div id="home-slider">
    <div class="overlay"></div>

    <div class="slider-text">
        <div id="slidecaption"></div>
    </div>

    <div class="control-nav">
        <a id="prevslide" class="load-item"><i class="font-icon-arrow-simple-left"></i></a>
        <a id="nextslide" class="load-item"><i class="font-icon-arrow-simple-right"></i></a>
        <ul id="slide-list"></ul>

        <a id="nextsection" href="#work"><i class="font-icon-arrow-simple-down"></i></a>
    </div>
</div>
<!-- End Homepage Slider -->

<!-- Header -->
<header>
    <div class="sticky-nav">
        <a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>

        <div id="logo">
            <a id="goUp" href="#home-slider">COMPANY_NAME</a>
        </div>

        <nav id="menu">
            <ul id="menu-nav">
                <li class="current"><a href="#home-slider">NAV_HOME</a></li>
                <li><a href="#work">NAV_OUR_WORK</a></li>
                <li><a href="#about">NAV_ABOUT_US</a></li>

            </ul>
        </nav>

    </div>
</header>
<!-- End Header -->

<!-- Our Work Section -->
<div id="work" class="page">
    <div class="container">
        <!-- Title Page -->
        <div class="row">
            <div class="span12">
                <div class="title-page">
                    <h2 class="title">NAV_OUR_WORK</h2>
                </div>
            </div>
        </div>
        <!-- End Title Page -->

        <!-- Portfolio Projects -->
        <div class="row">
            <div class="span3">
                <!-- Filter -->
                <nav id="options" class="work-nav">
                    <ul id="filters" class="option-set" data-option-key="filter">
                        <li class="type-work">TYPE_OF_WORK</li>
                        <li><a href="#filter" data-option-value="*" class="selected">ALL_PRODUCT</a></li>
                        <li><a href="#filter" data-option-value=".wedding">WEDDING_DRESSES</a></li>
                        <li><a href="#filter" data-option-value=".evening">EVENING_DRESSES</a></li>
                        <li><a href="#filter" data-option-value=".children">CHILDREN_DRESS</a></li>
                    </ul>
                </nav>
                <!-- End Filter -->
            </div>

            <div class="span9">
                <div class="row">
                    <section id="projects">
                        <ul id="thumbs">

                            <!--products-->

                        </ul>
                    </section>

                </div>
            </div>
        </div>
        <!-- End Portfolio Projects -->
    </div>
</div>
<!-- End Our Work Section -->

<!-- About Section -->
<div id="about" class="page-alternate">
    <div class="container">
        <!-- Title Page -->
        <div class="row">
            <div class="span12">
                <div class="title-page">
                    <h2 class="title">NAV_ABOUT_US</h2>

                    <h3 class="title-description">TITLE_ABOUT_US</h3>
                </div>
            </div>
        </div>
        <!-- End Title Page -->

        <!-- People -->
        <div class="row">

            <!-- Start Profile -->
            <div class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Фотограф</span>
                    </div>
                    <img src="http://cs620231.vk.me/v620231865/1a690/oHzDTD9-8xE.jpg" alt="Оксана Колесникова">
                </div>
                <h3 class="profile-name">Оксана Колесникова</h3>

                <p class="profile-description">
                    Свадебная и семейная фотография. Готова снимать в любых городах Украины и уголках мира.
                    Участник Клуба профессиональных свадебных фотографов MyWed
                </p>

                <div class="social">
                    <ul class="social-icons">
                        <li><a href="#"><i class="font-icon-phone-boxed"> +380677050630</i></a></li>
                        <li><a href="#"><i class="font-icon-email_2"> dassader@live.ru</i></a></li>
                        <li><a href="#"><i class="font-icon-globe_line"> http://vk.com/dassader</i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->

        </div>
        <!-- End People -->
    </div>
</div>
<!-- End About Section -->

<!-- Footer -->
<footer>
    <p class="credits">&copy;2015 Orchid</p>
</footer>
<!-- End Footer -->

<!-- Back To Top -->
<a id="back-to-top" href="#">
    <i class="font-icon-arrow-simple-up"></i>
</a>
<!-- End Back to Top -->

<!--STUBS-->

<!-- Item Project and Filter Name -->
<li id="product-stub" class="item-thumbs span3 stub">
    <!-- Fancybox - Gallery Enabled - Title - Full Image -->
    <span class="type-work product-price"></span>

    <!--Блок отвечает за увеличение изображения и отрисовку значка лупы-->
    <a style="width: 50px; height: 50px; left: 0;" class="hover-wrap fancybox product-big-img"
       data-fancybox-group="gallery" href="" title=" " link="">
        <span class="overlay-img"></span>
        <span class="overlay-img-thumb font-icon-zoom-in"></span>
    </a>

    <!--Блок отвечает за добавление в корзину и отображение значка корзины-->
    <a style="width: 50px; height: 50px; bottom: 0; right: 0"
       class="hover-wrap">
        <span class="overlay-img"></span>
        <span class="overlay-img-thumb font-icon-shopping-cart"></span>
    </a>

    <!--Блок отвечает за отображение основного элемента и переход по клику не на иконуах-->
    <img class="product-small-img" src="" alt=" ">
</li>
<!-- End Item Project -->

<!--END STUBS-->
<!-- Js -->
<script src="js/lib/jquery-1.11.2.js"></script>
<!-- jQuery Core -->
<script src="js/lib/bootstrap.min.js"></script>
<!-- Bootstrap -->
<script src="js/lib/supersized.3.2.7.min.js"></script>
<!-- Slider -->
<script src="js/lib/waypoints.js"></script>
<!-- WayPoints -->
<script src="js/lib/waypoints-sticky.js"></script>
<!-- Waypoints for Header -->
<script src="js/lib/jquery.isotope.js"></script>
<!-- Isotope Filter -->
<script src="js/lib/jquery.fancybox.pack.js"></script>
<!-- Fancybox -->
<script src="js/lib/jquery.fancybox-media.js"></script>
<!-- Fancybox for Media -->
<script src="js/lib/jquery.tweet.js"></script>
<!-- Tweet -->
<script src="js/lib/plugins.js"></script>
<!-- Contains: jPreloader, jQuery Easing, jQuery ScrollTo, jQuery One Page Navi -->
<script src="js/main.js"></script>
<!-- Default JS -->
<!-- End Js -->

<!--OBJECT-->
<script src="js/object/ProductObject.js"></script>

<script>
    for (var i = 0; i < 2; i++) {
        $("#thumbs").append(new Product(1, "100 $", "100 $", "http://img1.wildberries.ru/big/new/640000/646567-1.jpg", "http://img1.wildberries.ru/big/new/640000/646567-1.jpg", "http://vk.com", "wedding").build());
        $("#thumbs").append(new Product(0, "100 $", "100 $", "http://salon-defile.com/upload/iblock/264/26434d552ffcccae327c77d3e9ce9590.jpg", "http://salon-defile.com/upload/iblock/264/26434d552ffcccae327c77d3e9ce9590.jpg", "http://vk.com", "evening").build());
        $("#thumbs").append(new Product(3, "100 $", "100 $", "http://www.lorange.ua/images/children-dresses-collection/2013/big/w-36-37.jpg", "http://www.lorange.ua/images/children-dresses-collection/2013/big/w-36-37.jpg", "http://vk.com", "children").build());
    }
</script>

</body>
</html>
