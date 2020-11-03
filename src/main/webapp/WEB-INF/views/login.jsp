<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
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
