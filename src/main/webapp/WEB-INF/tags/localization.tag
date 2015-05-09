<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="info" %>

<select class="btn btn-default btn-xs" name="lang" id="lang">
    <c:forEach var="loc" items="${locales}">
        <option value="${loc}" ${loc eq locale ? 'selected' : ''}>${loc}</option>
    </c:forEach>
</select>