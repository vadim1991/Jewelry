<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="info" %>

<%@ attribute name="captchaID" required="true" %>
<%@ attribute name="errorCaptcha" required="true" %>

<div>
    <c:choose>
        <c:when test="${!empty captchaID}">
            <input type="hidden" name="captchaID" value="${captchaID}">
            <label class="error-label" id="errorCaptcha">${errors.get("captchaError")}</label><br>
            <img src="/captcha?captchaID=${captchaID}" border="0">
        </c:when>
        <c:otherwise>
            <label class="error-label" id="errorCaptcha">${errors.get("captchaError")}</label><br>
            <img src="captcha" border="0">
        </c:otherwise>
    </c:choose>
</div>
<div style="margin-top: 20px">
    <input name="captcha" type="text" class="form-field" id="captcha" placeholder="введите текст с картинки">
</div>