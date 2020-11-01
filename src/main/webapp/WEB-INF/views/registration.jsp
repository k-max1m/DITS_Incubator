<%--
  Created by IntelliJ IDEA.
  User: Korona
  Date: 29.10.2020
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<security:form method="post" action="/registration" modelAttribute="userForm">
    <h2>Registration</h2>
    <div>
        <security:input type="text" path="firstName" name ="firstName" placeholder="firstName"></security:input>
        <security:input type="text" path="lastName" name ="lastName" placeholder="lastName"></security:input>
        <security:input type="text" path="login" name="login" placeholder="login"></security:input>
        <security:input type="password" path="password" name="password" placeholder="password"></security:input>
        <security:input type="text" path="role" name="roleId" value="3" placeholder="roleId" hidden="true"></security:input>
    </div>
    <button type="submit">registration</button>
</security:form>
</body>
</html>
