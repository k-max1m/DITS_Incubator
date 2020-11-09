<%@ page import="incubator.entity.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SetUser</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
<% if(request.getAttribute("users") != null) { %>
<h1>Choose User</h1>
<% List<User> users =(List<User>) request.getAttribute("users");%>
<%for(User user: users){%>
<a href=<%="./"+user.getUserId() + "/"%> class="link"><%= user.getLogin() %></a><br><br>
<% } %>
<% }
else {%>
    <%User user = (User) request.getAttribute("user");%>
<h1>Set User: <%= user.getLogin() %></h1>
<% if(request.getAttribute("result") != null) { %>
<%= request.getAttribute("result")%>
<%}%>
    <div class="loginForm">
<form:form action="/admin/setUser/${uId}/setFirstName/" method="POST" name="userForm">
    <input type="text" class="input-style" name="firstName" placeholder="firstName" value=<%=user.getFirstName()%>/><br>
    <input name="submit" type="submit" class="myButton" value="change first name"/>
</form:form>
<form:form action="/admin/setUser/${uId}/setLastName/" method="POST" name="userForm">
    <input type="text" class="input-style" name="lastName" placeholder="lastName" value=<%=user.getLastName()%> /><br>
    <input name="submit" type="submit" class="myButton" value="change last name"/>
</form:form>
<form:form action="/admin/setUser/${uId}/setLogin/" method="POST">
    <input type="text" class="input-style" name="login" placeholder="login" value=<%=user.getLogin()%>/><br>
    <input name="submit" type="submit" class="myButton" value="change login"/>
</form:form>
<form:form action="/admin/setUser/${uId}/setPassword/" method="POST">
    <input type="password" class="input-style" name="password" placeholder="password"/><br>
    <input name="submit" type="submit" class="myButton" value="change password"/>
</form:form>
<form:form action="/admin/setUser/${uId}/setRole/" method="POST">
    <select name="roleId" class="input-style">
        <option value="2">Admin</option>
        <option value="1">Tutor</option>
        <option value="3">User</option>
    </select><br>
    <input name="submit" type="submit" class="myButton" value="change role"/>
</form:form>
        <form:form action="/admin/setUser/${uId}/deleteUser/" method="POST">
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