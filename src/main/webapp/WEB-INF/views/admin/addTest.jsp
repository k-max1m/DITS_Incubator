<%@ page import="incubator.entity.Topic" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Test</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    </head>
    <body>
        <div class="myCount">
            <h1>Add new Test!</h1>
            <% if(request.getAttribute("result") != null) { %>
            <%= request.getAttribute("result")%>
            <%}%>
                <div class="loginForm">
                    <% List<Topic> topics = (List<Topic>) request.getAttribute("topics"); %>
            <form:form action="/admin/addTest/" method="POST" name="testForm">
                <input type="text" class="input-style" name="name" placeholder="name"/>
                <input type="text" class="input-style" name="description" placeholder="description"/>
                <select class="input-style" name="description" placeholder="description">
                    <% for(Topic topic: topics){ %>
                    <option value=<%=topic.getTopicId()%>> <%= topic.getName() %></option>
                    <% } %>
                </select>
                <input name="submit" type="submit" class="myButton" value="add test"/>
            </form:form>
                </div>
            <div class="toMain">
                <a class="link" href="/main">На главную</a>
            </div>
            <div class="exit">
                <a class="link" href="/logout">Выйти</a>
            </div>
        </div>

    </body>
</html>