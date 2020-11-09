<%@ page import="incubator.entity.Literature" %>
<%@ page import="java.util.List" %>
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
    <h1>Add new Link!</h1>
    <% if(request.getAttribute("result") != null) { %>
    <%= request.getAttribute("result")%>
    <%}%>
    <% List<Literature> literatures = (List<Literature>) request.getAttribute("literatures"); %>
    <div class="loginForm">
        <form:form action="/admin/addLink/" method="POST" name="linkForm">
            <input type="text" class="input-style" name="link" placeholder="link"/>
            <select class="input-style" name="literatureId" placeholder="literatureId">
                <% for(Literature literature: literatures) { %>
                <option value=<%= literature.getLiteratureId() %>> <%= literature.getDescription() %></option>
                <% } %>
            </select><br>
            <input name="submit" type="submit" class="myButton" value="add link"/>
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