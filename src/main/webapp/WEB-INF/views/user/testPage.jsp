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
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <div class="picture">
        <img src="<c:url value="/resources/human1.png"/>" alt="human1.png">
    </div>
    <div class="chooseTest">
        <form class="form" action="/nextPage" method="get">
            <div>
                <label>
                    <input class="input-style" type="text" value="${question.description}">
                </label>
            </div>
            <div>
                <c:forEach items="${answers}" var="answer">
                    <div>
                        <label class="answer">
                            <input type="radio" name="correct" value="${answer.correct}">
                            <span>${answer.description}</span>
                        </label>
                    </div>
                    <br>
                </c:forEach>
            </div>
            <div>
                <input type="hidden" name="page" value="${page}">
                <input class="myButton" type="submit" value="Next Page">
            </div>
        </form>
    </div>
    <div class="exit">
        <a class="link" href="/logout">Выйти</a>
    </div>
</div>

</body>
</html>
