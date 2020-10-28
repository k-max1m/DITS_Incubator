<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 27.10.2020
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test Page</title>
</head>
<body>
<form action="/nextPage" method="get">
    <div>${question.description}</div>
    <br>
    <c:forEach items="${answers}" var="answer">
        <input type="radio" name="chooseAnswer" value="${answer.answerId}">${answer.description}<br>
    </c:forEach>
    <input type="hidden" name = "page" value="${page}">
    <input type="submit" placeholder="Next question">
</form>
<a href="/logout">Выйти</a>
</body>
</html>
