<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 04.04.2015
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jewelery Shop | Rings</title>
</head>
<!----webfonts--->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,800,400,600' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
<!---//webfonts--->
</head>
<body>
<!-- container -->
<!-- header -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- content -->
<!-- details -->
<div class="details">
    <div class="details-head">

    </div>
    <div class="details-cate">
        <div class="container">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Arizume</a></li>
                <li><a href="#">Fern Clamper Bracelet</a></li>
            </ul>
        </div>
    </div>
    <!-- product-single-details -->
    <div class="product-single-details">
        <div class="container">
            <div class="product-single-details-left">
                <!----details-product-slider--->
                <!-- Include the Etalage files -->
                <link rel="stylesheet" href="css/etalage.css">
                <script src="js/jquery.etalage.min.js"></script>
                <!-- Include the Etalage files -->
                <script>
                    jQuery(document).ready(function ($) {

                        $('#etalage').etalage({
                            thumb_image_width: 300,
                            thumb_image_height: 400,
                            source_image_width: 900,
                            source_image_height: 1000,
                            show_hint: true,
                            click_callback: function (image_anchor, instance_id) {
                                alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                            }
                        });
                        // This is for the dropdown list example:
                        $('.dropdownlist').change(function () {
                            etalage_show($(this).find('option:selected').attr('class'));
                        });

                    });
                </script>
                <!----//details-product-slider--->
                <div class="details-left">
                    <div class="details-left-slider">
                        <ul id="etalage" class="etalage" style="display: block; width: 314px; height: 552px;">
                            <li class="etalage_thumb thumb_1"
                                style="display: none; opacity: 0; background-image: none;">
                                <img class="etalage_thumb_image" src="${product.image.url}"
                                     style="display: inline; width: 300px; height: 400px; opacity: 1;">
                                <img class="etalage_source_image" src="${product.image.url}">
                            </li>
                            <li class="etalage_thumb thumb_2"
                                style="display: none; opacity: 0; background-image: none;">
                                <img class="etalage_thumb_image" src="${product.image.url}"
                                     style="display: inline; width: 300px; height: 400px; opacity: 1;">
                                <img class="etalage_source_image" src="${product.image.url}">
                            </li>
                            <li class="etalage_thumb thumb_3 etalage_thumb_active"
                                style="display: list-item; opacity: 1; background-image: none;">
                                <img class="etalage_thumb_image" src="${product.image.url}"
                                     style="display: inline; width: 300px; height: 400px; opacity: 1;">
                                <img class="etalage_source_image" src="${product.image.url}">
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
            <div class="product-single-details-right">
                <h2>${product.title}</h2>

                <p>Описание: <span> ${product.description}</span></p>
                <!-- price-details -->
                <div class="price-details">
                    <div class="price-details-left">
                        <p>Код изделия : ${product.id}</p>

                        <p>Цена изделия: $ ${product.price}</p>
                    </div>
                    <div class="price-details-right">
                        <input type="button" value="Добавить в корзину"/>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <!-- price-details -->
                <!-- product-description -->
                <div class="product-description">
                    <h3>Детальная информация: </h3>
                    <!-- des-tabs -->
                    <div class="des-tabs">
                        <div class="tab1 tab">
                            <h4>Стиль</h4>

                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem
                                Ipsum
                                has
                                been the industry's standard dummy text ever since the 1500s, when an unknown
                                printer
                                took a
                                galley of type and scrambled it to make a type specimen book. It has survived not
                                only
                                five
                                centuries, but also the leap into electronic typesetting, remaining essentially
                                unchanged.
                                I</p>
                        </div>
                        <div class="tab2 tab">
                            <h4>Детали</h4>

                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem
                                Ipsum
                                has
                                been the industry's standard dummy text ever since the 1500s, when an unknown
                                printer
                                took a
                                galley of type and scrambled it to make a type specimen book. It has survived not
                                only
                                five
                                centuries, but also the leap into electronic typesetting, remaining essentially
                                unchanged.
                                I</p>
                        </div>
                        <div class="tab3 tab">
                            <h4>Материал и уход</h4>

                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem
                                Ipsum
                                has
                                been the industry's standard dummy text ever since the 1500s, when an unknown
                                printer
                                took a
                                galley of type and scrambled it to make a type specimen book. It has survived not
                                only
                                five
                                centuries, but also the leap into electronic typesetting, remaining essentially
                                unchanged.
                                I</p>
                        </div>
                    </div>
                    <!-- des-tabs -->
                    <!-- script-for-tabs -->
                    <script>
                        $(document).ready(function () {
                            $(".tab2 p").hide();
                            $(".tab3 p").hide();
                            $(".tab2 h4").click(function () {
                                $(".tab2 p").slideToggle(300);
                                $(".tab1 p").hide();
                                $(".tab3 p").hide();
                            });
                            $(".tab1 h4").click(function () {
                                $(".tab1 p").slideToggle(300);
                                $(".tab2 p").hide();
                                $(".tab3 p").hide();
                            });
                            $(".tab3 h4").click(function () {
                                $(".tab3 p").slideToggle(300);
                                $(".tab2 p").hide();
                                $(".tab1 p").hide();
                            });
                        });
                    </script>
                    <!-- script-for-tabs -->
                </div>
                <!-- product-description -->
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- product-single-details -->
</div>
<!-- details -->
<!-- content -->
<!-- footer -->
<div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<!-- copy-right -->
<!-- container -->
</body>
</html>
