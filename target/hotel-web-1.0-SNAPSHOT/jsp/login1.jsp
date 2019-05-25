<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: viktoria
  Date: 5/24/19
  Time: 7:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>
    <!-- Bootstrap core CSS     -->
    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/bootstrap-select.css" rel="stylesheet"/>
    <script src="../bootstrap-select-1.12.4/js/bootstrap-select.js"></script>
    <!--  Material Dashboard CSS    -->
    <link href="../css/material-dashboard.css?v=1.2.0" rel="stylesheet"/>
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet'
          type='text/css'>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/css/bootstrap-select.min.css'
          rel='stylesheet' type='text/css'>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/0.8.2/css/flag-icon.min.css' rel='stylesheet'
          type='text/css'>
</head>
<body>
<div class="wrapper">
    <form class="form-signin" method="post" action="/login">

       <%-- <input type="hidden" name="command" value="login">--%>
        <input type="text" class="form-control" name="login"
               placeholder="<fmt:message bundle="${common}" />"
               required="" autofocus=""/>
        <input type="password" class="form-control" name="password"
               placeholder="<fmt:message bundle="${common}" />
      <%--  <font color="red"><c:out value="${error}"/></font>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <fmt:message bundle="${common}" key="log.in"/>
        </button>--%>
        <%--<a href="http://localhost:8888/jsp/register.jsp" class="btn btn-lg btn-primary btn-block btn-sign-in">
            <fmt:message bundle="${common}" key="sign.up"/>--%>
        <%--</a>--%>
    </form>
</div>
</body>
</html>
