<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 29.03.2015
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>reCAPTCHA demo: Explicit render after an onload callback</title>
    <script type="text/javascript">
        var onloadCallback = function() {
            grecaptcha.render('html_element', {
                'sitekey' : '6LfHBQUTAAAAAEmeIl4fatUhJoqsXbmm678VbaIs'
            });
        };
    </script>
</head>
<body>
<form action="?" method="POST">
    <div id="html_element"></div>
    <br>
    <input type="submit" value="Submit">
</form>
<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer></script>
</body>
</html>
