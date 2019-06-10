<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.hotel.utils.Internationalization" %>

<div align="right">
    <c:forEach items="${Internationalization.supportedLocales}" var="locale">
        <c:choose>
            <c:when test="${locale == sessionScope[javax.servlet.jsp.jstl.fmt.locale.session]}">
                <b>${locale}</b>
            </c:when>
            <c:otherwise>
                <a href="?lang=${locale.language}">${locale}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>