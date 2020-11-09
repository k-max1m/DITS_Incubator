<%@ page import="incubator.entity.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="incubator.entity.Question" %>
<%@ page import="incubator.entity.Statistic" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Test statistic</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    </head>
    <body>
        <div class="myCount">
            <% List<Test> tests = (List<Test>) request.getAttribute("tests"); %>
            <% if(tests != null) { %>
                <h1>Test Statistic</h1>
                <% for (Test test: tests){ %>
                    <a href=<%= "./" + test.getTestId()%> class="link"><%=test.getName()%></a><br><br>
                <%}
            }
            else {
                    HashMap<Question, List<Statistic>> statistics = (HashMap<Question, List<Statistic>>) request.getAttribute("statistic");
                    Set<Question> questions = statistics.keySet();%>

                    <% for(Question question: questions){ %>
                    <table>
                        <tr>
                            <td>
                                <%= question.getDescription()%>
                            </td>
                            <td>
                        </tr>
                        <tr>
                            <td>Date</td>
                            <td>User</td>
                            <td>Result</td>
                        </tr>
                                <% List<Statistic> qStatistics = statistics.get(question);
                                    for(Statistic statistic: qStatistics) {%>
                                            <tr>
                                                <td>
                                                    <%= statistic.getDate()%>
                                                </td>
                                                <td>
                                                    <%= statistic.getUser().getLogin()%>
                                                </td>
                                                <td>
                                                    <%= statistic.isCorrect()%>
                                                </td>
                                            </tr>

                                    <% } %>

                            </td>
                    </table>
                    <% } %>

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