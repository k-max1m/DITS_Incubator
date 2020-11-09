<%@ page import="incubator.entity.Literature" %>
<%@ page import="java.util.List" %>
<%@ page import="incubator.entity.Question" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Question</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <h1>Add new Literature!</h1>
    <% if(request.getAttribute("result") != null) { %>
    <%= request.getAttribute("result")%>
    <%}%>
    <% List<Question> questions = (List<Question>) request.getAttribute("questions"); %>
    <div class="loginForm">
        <form:form action="/admin/addLiterature/" method="POST" name="litForm">
            <input type="text" class="input-style" name="description" placeholder="description"/>
            <select class="input-style" name="questionId" placeholder="questionId">
                <% for(Question question: questions) { %>
                <option value=<%= question.getQuestionId() %>> <%= question.getDescription()%></option>
                <% } %>
            </select><br>
            <input name="submit" type="submit" class="myButton" value="submit"/>
        </form:form>
    </div>
    <div class="toMain">
        <a class="link" href="/main">На главную</a>
    </div>
    <div class="exit">
        <a class="link" href="/logout">Выйти</a>
    </div>
</div>
</body>
</html>