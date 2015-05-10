<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 04.04.2015
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="footer">
    <div class="footer-grids">
        <div class="container">
            <div class="col-md-3 footer-grid">
                <h4>Services</h4>
                <ul>
                    <li><a href="#">Contact Customer Service</a></li>
                    <li><a href="#">Free Delivery over $150</a></li>
                    <li><a href="#">View your Wishlist</a></li>
                    <li><a href="#">Ring Size Guide</a></li>
                    <li><a href="#">Returns</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-grid">
                <h4>Information (FAQ)</h4>
                <ul>
                    <li><a href="#">Gift certificates</a></li>
                    <li><a href="#">Jewellery care guide</a></li>
                    <li><a href="#">International customers</a></li>
                    <li><a href="#">Wholesale enquires</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-grid">
                <h4>More details</h4>
                <ul>
                    <li><a href="#">About us</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms & COndition</a></li>
                    <li><a href="#">Secure payment</a></li>
                    <li><a href="#">Site map</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-grid contact-grid">
                <h4>Contact us</h4>
                <ul>
                    <li><span class="c-icon"> </span>Baku international Pty LTD</li>
                    <li><span class="c-icon1"> </span><a href="#">info@baku.com.au</a></li>
                    <li><span class="c-icon2"> </span>AUSTRALIA (02) 9283 2280</li>
                </ul>
                <ul class="social-icons">
                    <li><a href="#"><span class="facebook"> </span></a></li>
                    <li><a href="#"><span class="twitter"> </span></a></li>
                    <li><a href="#"><span class="thumb"> </span></a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- news-letter -->
    <div class="container">
        <div class="news-letter">
            <div class="news-letter-left">
                <a href="#"><span> </span> News letter</a>
            </div>
            <div class="news-letter-right">
                <p>Subscribe to notification about disconunts anf Offers from our store enter your Email id :</p>

                <form>
                    <input type="text" class="text" value="Enter your mail id" onfocus="this.value = '';"
                           onblur="if (this.value == '') {this.value = 'Enter your mail id';}">
                    <input type="submit" value=""/>
                </form>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- news-letter -->
</div>
<!-- copy-right -->
<div class="copy-right">
    <p>&copy; Jewelery Store by Vadym Vlasenko</p>
</div>
<!-- copy-right -->
</body>
</html>
