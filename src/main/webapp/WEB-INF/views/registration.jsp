<%--
  Created by IntelliJ IDEA.
  User: Korona
  Date: 29.10.2020
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<security:form method="post" action="/registration" modelAttribute="userForm">
    <div class = "myCount">
        <header><h1>Registration</h1></header>
        <% if (request.getAttribute("usernameError") != null){ %>
            <%= request.getAttribute("usernameError") %>
        <% } %>
        <div class="picture">
            <img src="<c:url value="/resources/human1.png"/>" alt="human1.png">
        </div>
        <div class="loginForm">
            <security:input type="text" class="input-style" path="firstName" name ="firstName" placeholder="firstName"></security:input>
            <security:input type="text" class="input-style" path="lastName" name ="lastName" placeholder="lastName"></security:input>
            <security:input type="text" class="input-style" path="login" name="login" placeholder="login"></security:input>
            <security:input type="password" class="input-style" path="password" name="password" placeholder="password"></security:input>
            <button type="submit" class="myButton">registration</button>
        </div>
    </div>
</security:form>
</body>
</html>
