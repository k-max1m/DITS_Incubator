<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add User</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/><br>
    </head>
    <body>
        <div class="myCount">
        <h1>Add new User</h1>
        <% if(request.getAttribute("result") != null) { %>
        <%= request.getAttribute("result")%>
        <%}%>
            <div class="loginForm">
        <form:form action="/admin/addUser/" method="POST" name="userForm">
            <input type="text" class="input-style" name="firstName" placeholder="firstName"/><br>
            <input type="text" class="input-style" name="lastName" placeholder="lastName"/><br>
            <input type="text" class="input-style" name="login" placeholder="login"/><br>
            <input type="password" class="input-style" name="password" placeholder="password"/><br>
            <select name="roleId" class="input-style">
                <option value="2">Admin</option>
                <option value="1">Tutor</option>
                <option value="3">User</option>
            </select>
            <input name="submit" type="submit" class="myButton" value="add user"/>
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