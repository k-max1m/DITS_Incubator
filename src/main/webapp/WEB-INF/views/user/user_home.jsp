<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 27.10.2020
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <div class="picture">
        <img src="<c:url value="/resources/human1.png"/>" alt="human1.png">
    </div>
    <div class="chooseTest">
        <div class="marginBottom">
            <a class="link" href="/chooseTopic">Выбор темы теста</a>
        </div>
        <br>
        <div class="marginBottom">
            <a class="link" href="/personalStatistic">Вывод статистики</a>
        </div>
    </div>
    <div class="exit">
        <a class="link" href="/logout">Выйти</a>
    </div>
</div>
</body>
</html>
