<%@ page import="incubator.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="incubator.entity.Statistic" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User Statistic</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    </head>
    <body>
    <div class="myCount">
        <%if(request.getAttribute("users") != null) {%>
            <h1>User List</h1>
            <%List<User> users = (List<User>) request.getAttribute("users");
            for(User user: users){%>
                <a href=<%="./" + user.getUserId() %> class="link"><%=user.getLogin()%></a><br><br>
            <%}%>
        <%}
        else{%>
            <h1>Get User Statistic</h1>
            <% List<Statistic> statistics = (List<Statistic>) request.getAttribute("statistic");%>
            <table>
            <%for(Statistic statistic: statistics){%>
                <tr>
                    <td><%=statistic.getDate().toString().replace(" 00:00:00.0","")%></td>
                    <td><%=statistic.getQuestion().getDescription()%></td>
                    <td><%=statistic.isCorrect()%></td>
                </tr>
            <%}%>
            </table>
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