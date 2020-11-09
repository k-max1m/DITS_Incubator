<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 27.10.2020
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Personal Statistic</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <div>
        <table>
            <tr>
                <th>Ф.И.О</th>
                <th>Название теста</th>
                <th>Вопрос</th>
                <th>Пройдено всего</th>
                <th>Процент правильно пройденных</th>
            </tr>
            <c:forEach items="${statistic}" var="userStatistic">
                <tr>
                    <td>${userStatistic.firstAndLastName}</td>
                    <td>${userStatistic.testName}</td>
                    <td>${userStatistic.questionDescription}</td>
                    <td>${userStatistic.allAnswers}</td>
                    <td>${userStatistic.percent}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form action="/user/home">
        <input class="myButton" type="submit" value="Home page">
    </form>
    <div class="exit">
        <a class="link" href="/logout">Выйти</a>
    </div>
</div>
</body>
</html>
