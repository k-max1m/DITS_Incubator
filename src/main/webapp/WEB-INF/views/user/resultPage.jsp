<%--
  Created by IntelliJ IDEA.
  User: студент11
  Date: 27.10.2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result page</title>
</head>
<body>
<table>
    <tr>
        <th>Question</th>
        <th>Right</th>
        <th>Recommend literature</th>
        <th>Link to literature</th>
    </tr>
    <c:forEach items="${resultList}" var="result">
        <tr>
            <td>${result.get(0)}</td>
            <td>${result.get(1)}</td>
            <td>
                <c:forEach items="${result.get(2)}" var="res">
                    <p>${res}</p>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${result.get(3)}" var="res">
                    <p><a href="${res}">${res}</a></p>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>


</table>
<form action="/userHome">
    <input type="submit" placeholder="Home page">
</form>

</body>
</html>
