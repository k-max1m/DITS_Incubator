<%--
  Created by IntelliJ IDEA.
  User: Korona
  Date: 29.10.2020
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/registration" modelAttribute="registration">
    <p>First Name<input type="text" name ="firstName"></p>
    <p>Last Name<input type="text" name ="lastName"></p>
    <p>Login<input type="text" name="login"></p>
    <p>Password<input type="password" name="password"></p>
    <input type="text" name="roleId" value="3" hidden>
    <button type="submit">registration</button>
</form>
</body>
</html>
