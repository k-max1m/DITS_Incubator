<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Topic</title>
</head>
<body>
<h1>Add new Topic</h1>
<% if(request.getAttribute("result") != null) { %>
<%= request.getAttribute("result")%>
<%}%>
<form:form action="/" method="POST" name="topicForm">
    <input type="text" name="name" placeholder="name"/>
    <input type="text" name="description" placeholder="description"/>
    <input name="submit" type="submit" value="submit"/>
</form:form>
</body>
</html>