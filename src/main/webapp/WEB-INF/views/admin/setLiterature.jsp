<%@ page import="incubator.entity.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="incubator.entity.Literature" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Question</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="myCount">
    <% if(request.getAttribute("literatures") != null) { %>
    <h1>Choose Literature</h1>
    <% List<Literature> literatures = (List<Literature>) request.getAttribute("literatures");%>
    <%for(Literature literature: literatures){%>
    <a href=<%="./" + literature.getLiteratureId() + "/"%> class="link"><%= literature.getDescription() %></a><br><br>
    <% } %>
    <% }
    else {%>
    <%Literature literature = (Literature) request.getAttribute("literature");%>
    <h1>Set Literature: <%= literature.getDescription() %></h1>
    <% if(request.getAttribute("result") != null) { %>
    <%= request.getAttribute("result")%>
    <%}%>
    <div class="loginForm">
        <form:form action="/admin/setLiterature/${lId}/setDescription/" method="POST">
            <input type="text" class="input-style" name="description" placeholder="description" value=<%=literature.getDescription()%>/>
            <input name="submit" type="submit" class="myButton" value="change description"/>
        </form:form>
        <% List<Question> questions = (List<Question>) request.getAttribute("questions"); %>
        <form:form action="/admin/setLiterature/${lId}/setQuestion/" method="POST">
            <select class="input-style" name="questionId" placeholder="questionId" >
                <% for(Question question: questions) { %>
                <option value=<%= question.getQuestionId() %>> <% if(question.getQuestionId() == literature.getQuestion().getQuestionId()) { %> selected <% }%> <%= question.getDescription() %></option>
                <% } %>
            </select><br>
            <input name="submit" type="submit" class="myButton" value="change question"/>
        </form:form>
        <form:form action="/admin/setLiterature/${lId}/deleteLiterature/" method="POST">
            <input name="submit" type="submit" class="myButton" value="delete"/>
        </form:form>
    </div>
    <% } %>
    <div class="toMain">
        <a class="link" href="/main">На главную</a>
    </div>
    <div class="exit">
        <a class="link" href="/logout">Выйти</a>
    </div>
</div>
</body>
</html>