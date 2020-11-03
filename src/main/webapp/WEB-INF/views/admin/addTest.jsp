<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Test</title>
    </head>
    <body>
        <h1>It's page for test adding!</h1>
        <% if(request.getAttribute("result") != null) { %>
        <%= request.getAttribute("result")%>
        <%}%>
        <form:form action="/" method="POST" name="testForm">
            <input type="text" name="name" placeholder="name"/>
            <input type="text" name="description" placeholder="description"/>
            <input type="text" name="topicId" placeholder="topicId"/>
            <input name="submit" type="submit" value="submit"/>
        </form:form>
    </body>
</html>