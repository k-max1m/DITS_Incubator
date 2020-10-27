<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Korona
  Date: 25.10.2020
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>It's a login page!</h1>
<security:form action="/login" method="POST">
    <input type="text" name="userName" placeholder="username"/>
    <input type="password" name="password" placeholder="password"/>
    <input name="submit" type="submit" value="submit"/>
</security:form>
</body>
</html>
