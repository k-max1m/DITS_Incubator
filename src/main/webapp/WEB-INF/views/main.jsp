<%@ page import="incubator.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Korona
  Date: 25.10.2020
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
 <h1>It's a main page, <%=request.getAttribute("userName")%></h1>
 <%for(User user:(List<User>) request.getAttribute("users")) {%>
 <p><%=user.toString()%></p>
 <%}%>
<a href="/login">Login</a>
 <a href="/registration">Registration</a>
</body>
</html>
