<%@ page import="incubator.entity.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="incubator.entity.Topic" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Test</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
<% if(request.getAttribute("tests") != null) { %>
<h2>Choose Test</h2>
<% List<Test> tests =(List<Test>) request.getAttribute("tests");%>
<%for(Test test: tests){%>
<a href=<%="./"+test.getTestId()%> class="link"><%= test.getName() %></a><br><br>
<% } %>
<% }
else {%>
    <%Test test = (Test) request.getAttribute("test");%>
<h1>Set Test: <%= test.getName() %></h1>
<% if(request.getAttribute("result") != null) { %>
<%= request.getAttribute("result")%>
<%}%>
    <div class="loginForm">
    <form:form action="/admin/setTest/${tId}/setName/" method="POST">
    <input type="text" class="input-style" name="name" placeholder="name"/>
    <input name="submit"  type="submit" class="myButton" value="submit"/>
</form:form>
<form:form action="/admin/setTest/${tId}/setDescription/" method="POST">
    <input type="text" class="input-style" name="description" placeholder="description"/>
    <input name="submit" type="submit" class="myButton" value="submit"/>
</form:form>
        <% List<Topic> topics = (List<Topic>) request.getAttribute("topics"); %>
<form:form action="/admin/setTest/${tId}/setTopic/" method="POST">
    <select class="input-style" name="description" placeholder="description">
        <% for(Topic topic: topics){ %>
        <option value=<%=topic.getTopicId()%> <% if(topic.getTopicId() == test.getTopic().getTopicId()) { %> selected <% }%> >> <%= topic.getName() %></option>
        <% } %>
    </select>
    <input name="submit" type="submit" class="myButton" value="submit"/>
</form:form>
        <form:form action="/admin/setTest/${tId}/deleteTest/" method="POST">
            <input name="submit" type="submit" class="myButton" value="submit"/>
        </form:form>
    </div>
<%}%>
    <div class="toMain">
        <a class="link" href="/main">На главную</a>
    </div>
    <div class="exit">
        <a class="link" href="/logout">Выйти</a>
    </div>
</div>
</body>
</html>