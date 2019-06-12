<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.hotel.utils.Internationalization" %>
<fmt:setLocale value="${sessionScope.lang}" scope="session"/>
<fmt:setBundle basename="message" scope="session"/>

<select id="dynamic_select">
    <c:forEach items="${Internationalization.supportedLocales}" var="locale">
        <option value="http://localhost:8081/login?lang=${locale.toLanguageTag()}">
                ${locale.toLanguageTag()}
        </option>
    </c:forEach>
</select>



