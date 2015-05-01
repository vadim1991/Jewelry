<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 04.04.2015
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<!-- content -->
<!-- error-page -->
<div class="error-page text-center">
    <div class="container">
        <h1>404</h1>

        <p>page not found</p>
        <a class="b-home" href="index.jsp">back to Home</a>
    </div>
</div>
<!-- /error-page -->
<!-- /content -->
<div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<!-- container -->
</body>
</html>
