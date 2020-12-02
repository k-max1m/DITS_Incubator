<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Admin Home</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    </head>
    <body >
        <div class="myCount" >
            <div class="picture" >
                <img src="<c:url value="/resources/human1.png"/>" alt="human1.png">
            </div>
            <div class="chooseOption">
                <details class="link">
                    <summary>Materials panel <br></summary>
                    <div class="marginBottom"><a class="link" href="/admin/addQuestion/">Add Question</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/setQuestion/">Set Question</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/addTest/">Add Test</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/setTest/">Set Test</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/addLink/">Add Link</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/setLink/">Set Link</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/addTopic/">Add Topic</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/setTopic/">Set Topic</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/addLiterature/">Add Literature</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/setLiterature/">Set Literature</a></div><br>
                </details>
                <br>
                <details class="link">
                    <summary>User panel <br></summary>
                    <div class="marginBottom"><a class="link" href="/admin/addUser/">Add User</a></div><br>
                    <div class="marginBottom"><a class="link" href="/admin/setUser/">Set User</a></div><br>
                </details>
                <br>
               <details class="link">
                   <summary>Statistic panel <br></summary>
                   <div class="marginBottom"><a class="link" href="/admin/testStatistic/">Get Test statistic</a></div><br>
                   <div class="marginBottom"><a class="link" href="/admin/userStatistic/">Get User statistic</a></div><br>
               </details>



            </div>
            <div class="exit">
                <a class="link" href="/logout">Выйти</a>
            </div>
        </div>
    </body>
</html>
