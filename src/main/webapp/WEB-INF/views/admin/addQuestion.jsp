<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Question</title>
    </head>
    <body>
        <h1>Add new Question!</h1>
        <% if(request.getAttribute("result") != null) { %>
            <%= request.getAttribute("result")%>
        <%}%>
        <form:form action="/" method="POST" name="questionForm">
            <input type="text" name="description" placeholder="description"/>
            <input type="text" name="testId" placeholder="testId"/>
            <input name="submit" type="submit" value="submit"/>
        </form:form>
    </body>
</html>