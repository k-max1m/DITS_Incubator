<%@ page import="incubator.entity.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="incubator.entity.Link" %>
<%@ page import="incubator.entity.Literature" %>
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
    <% if(request.getAttribute("links") != null) { %>
    <h1>Choose Link</h1>
    <% List<Link> links =(List<Link>) request.getAttribute("links");%>
    <%for(Link link: links){%>
    <a href=<%="./" + link.getLinkId() + "/"%> class="link"><%= link.getLink() %></a><br><br>
    <% } %>
    <% }
    else {%>
    <%Link link = (Link) request.getAttribute("link");%>
    <h1>Set Link: <%= link.getLink() %></h1>
    <% if(request.getAttribute("result") != null) { %>
    <%= request.getAttribute("result")%>
    <%}%>
    <div class="loginForm">
        <form:form action="/admin/setLink/${lId}/setLink/" method="POST">
            <input type="text" class="input-style" name="link" placeholder="link" value=<%= link.getLink()%> />
            <input name="submit" type="submit" class="myButton" value="submit"/>
        </form:form>
        <% List<Literature> literatures = (List<Literature>) request.getAttribute("literatures"); %>
        <form:form action="/admin/setLink/${lId}/setLiterarture/" method="POST">
            <select class="input-style" name="literatureId" placeholder="literatureId">
                <% for(Literature literature: literatures) { %>
                <option value=<%= literature.getLiteratureId() %> <% if(literature.getLiteratureId() == link.getLiterature().getLiteratureId()) { %> selected <% }%>> <%= literature.getDescription() %></option>
                <% } %>
            </select><br>
            <input name="submit" type="submit" class="myButton" value="submit"/>
        </form:form>
        <form:form action="/admin/setLink/${lId}/deleteLink/" method="POST">
            <input name="submit" type="submit" class="myButton" value="submit"/>
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