<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Korona
  Date: 25.10.2020
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <c:if test="${param.error != null}">
        <label class="link">Неправильно введён логин или пароль, либо аккаунт не зарегестрирован</label>
    </c:if>
    <div class="loginForm">
        <security:form action="/login" method="POST">
            <input class="input-style" type="text" name="userName" placeholder="Логин"/>
            <br>
            <input class="input-style" type="password" name="password" placeholder="Пароль"/>
            <br>
            <input name="submit" class="myButton" type="submit" value="Войти"/>
        </security:form>
        <security:form action="/registration" method="GET">
            <input name="submit" class="myButton" type="submit" value="Зарегестрироваться"/>
        </security:form>
    </div>
</div>
</body>
</html>
