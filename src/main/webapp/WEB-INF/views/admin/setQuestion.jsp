<%@ page import="incubator.entity.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="incubator.entity.Test" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Question</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <% if(request.getAttribute("questions") != null) { %>
        <h1>Choose question</h1>
        <% List<Question> questions =(List<Question>) request.getAttribute("questions");%>
        <%for(Question question: questions){%>
            <a href=<%="./"+question.getQuestionId()%> class="link"><%= question.getDescription() %></a><br><br>
        <% } %>
    <% }
    else {%>
    <%Question question = (Question) request.getAttribute("question");%>
        <h1>Set Question: <%= question.getDescription() %></h1>
        <% if(request.getAttribute("result") != null) { %>
            <%= request.getAttribute("result")%>
        <%}%>
        <div class="loginForm">
        <form:form action="/admin/setQuestion/${qId}/setDescription/" method="POST">
            <input type="text" class="input-style" name="description" placeholder="description" value=<%=question.getDescription()%> />
            <input name="submit" type="submit" class="myButton" value="change description"/>
        </form:form>
            <% List<Test> tests = (List<Test>) request.getAttribute("tests");%>
        <form:form action="/admin/setQuestion/${qId}/setTest/" method="POST">
            <select class="input-style" name="testId" placeholder="testId">
                <% for(Test test: tests){ %>
                <option value=<%= test.getTestId() %> <% if(test.getTestId() == question.getTest().getTestId()) { %> selected <% }%> ><%= test.getName() %></option>
                <% } %>
            </select><br>
            <input name="submit" type="submit" class="myButton" value="change test"/>
        </form:form>
            <form:form action="/admin/setQuestion/${qId}/deleteQuestion/" method="POST">
                <input name="submit" type="submit" class="myButton" value="delete"/>
            </form:form>
        </div>
    <% } %>
    <div class="toMain">
        <a class="link" href="/main">На главную</a>
    </div>
    <div class="exit">
        <a class="link" href="/logout">Выйти</a>
    </div>
</div>
</body>
</html>