<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 03.11.2020
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Choose Role</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <div class="picture">
        <img src="<c:url value="/resources/human1.png"/>" alt="human1.png">
    </div>
    <div class="chooseRole">
        <div class="marginBottom">
            <label class="link">Выберите роль под которой хотите войти: </label>
        </div>
        <c:forEach items="${roles}" var="role">
            <div class="marginBottom">
                <a href="${role.value}" class="link">${role.key} роль</a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
