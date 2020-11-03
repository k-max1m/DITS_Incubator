<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add User</title>
    </head>
    <body>
        <h1>Add new User</h1>
        <% if(request.getAttribute("result") != null) { %>
        <%= request.getAttribute("result")%>
        <%}%>
        <form:form action="/" method="POST" name="userForm">
            <input type="text" name="firstName" placeholder="firstName"/><br>
            <input type="text" name="lastName" placeholder="lastName"/><br>
            <input type="text" name="login" placeholder="login"/><br>
            <input type="password" name="password" placeholder="password"/><br>
            <input type="radio" name="roleId" value="2">Admin<br>
            <input type="radio" name="roleId" value="1">Tutor<br>
            <input type="radio" name="roleId" value="3">User<br>
            <input name="submit" type="submit" value="submit"/>
        </form:form>
        </body>
</html>