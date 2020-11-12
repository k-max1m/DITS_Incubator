<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 27.10.2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result page</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <div>
        <h1 class="link marginTop">Процент правильных ответов: ${correct}</h1>
        <c:if test="${resultList.size() > 0}">

            <table class="marginTopTwo">
                <tr>
                    <th colspan="3">Вопросы с неправильным ответом:</th>
                </tr>
                <tr>
                    <th>Вопрос</th>
                    <th>Рекомендуемая литература</th>
                    <th>Ссылка на литературу</th>
                </tr>
                <c:forEach items="${resultList}" var="result">
                    <tr>
                        <td>${result.get(0)}</td>
                        <td>
                            <c:forEach items="${result.get(2)}" var="res">
                                <p>${res}</p>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${result.get(3)}" var="res">
                                <p><a href="${res}">${res}</a></p>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <form action="/user/home">
        <input class="myButton" type="submit" value="Главная страница">
    </form>
    <div class="exit">
        <a class="link" href="/logout">Выйти</a>
    </div>
</div>
</body>
</html>
