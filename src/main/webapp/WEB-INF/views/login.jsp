<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>It's a login page!</h1>
<%=request.getAttribute("usernameError")%>
<security:form action="/login" method="POST">
    <input type="text" name="userName" placeholder="username"/>
    <input type="password" name="password" placeholder="password"/>
    <input name="submit" type="submit" value="submit"/>
</security:form>
</body>
</html>
