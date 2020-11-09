<%@ page import="incubator.entity.Topic" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Topic</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
        <% if(request.getAttribute("topics") != null) { %>
<h1>Choose Topic</h1>
<% List<Topic> topics =(List<Topic>) request.getAttribute("topics");%>
<%for(Topic topic: topics){%>
<a href=<%="./"+topic.getTopicId()%> class="link"><%= topic.getName() %></a><br><br>
<% } %>
<% }
else {%>
    <%Topic topic = (Topic) request.getAttribute("topic");%>
<h1>Set Topic: <%= topic.getName() %></h1>
<% if(request.getAttribute("result") != null) { %>
<%= request.getAttribute("result")%>
<%}%>
            <div class="loginForm">
            <form:form action="/admin/setTopic/${tId}/setName" method="POST">
    <input type="text" class="input-style" name="name" placeholder="name" value=<%=topic.getName()%>/>
    <input name="submit"  type="submit" class="myButton" value="change name"/>
</form:form>
<form:form action="/admin/setTopic/${tId}/setDescription/" method="POST">
    <input type="text" class="input-style" name="description" placeholder="description" value=<%=topic.getDescription()%>/>
    <input name="submit" type="submit" class="myButton" value="change description"/>
</form:form>
                <form:form action="/admin/setTopic/${tId}/deleteTopic/" method="POST">
                    <input name="submit" type="submit" class="myButton" value="delete"/>
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