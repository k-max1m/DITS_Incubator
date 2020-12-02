<%@ page import="incubator.entity.Test" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Question</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    </head>
    <body>
        <div class="myCount">
            <h1>Add new Question!</h1>
            <% if(request.getAttribute("result") != null) { %>
            <%= request.getAttribute("result")%>
            <%}%>
            <% List<Test> tests = (List<Test>) request.getAttribute("tests");%>
            <div class="loginForm">
                    <form:form action="/admin/addQuestion/" method="POST" name="questionForm">
                        <input type="text" class="input-style" name="description" placeholder="description"/>
                        <select class="input-style" name="testId" placeholder="testId">
                            <% for(Test test: tests){ %>
                            <option value=<%= test.getTestId() %>><%= test.getName() %></option>
                            <% } %>
                        </select><br>
                        <input type="checkbox" class="input-style" name="retry"> <span class="link">Add more questions</span><br>
                        <input name="submit" type="submit" class="myButton" value="add question"/>
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