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
    <title>Choose Theme</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<form action="/goToTest">
    <select id="themes" name="themes">
        <c:forEach items="${topics}" var="topic">
            <option>${topic.name}</option>
        </c:forEach>
    </select>
    <br>
    <div>
        <select id="tests" name="test">
            <c:forEach items="${tests}" var="test">
                <option>${test.name}</option>
            </c:forEach>
<%--            <option>Выберите тест</option>--%>
        </select>
    </div>
    <br>
    <input type="submit" value="Пройти тестирование">
</form>
<script>
    $().ready(function () {
        $('#themes').change(function (event) {
            $.ajax({
                url: "/chooseTest",
                type: "GET",
                dataType: "json",
                data: {topic: $(event.target).val()}
            })
                .done(function (data) {
                    setTest(data)
                })
                .fail(function (xhr, status, error) {
                    alert(xhr.responseText + '|/n' + status + '|/n' + error);
                });
        });
    });
    var setTest = function (data) {
        $('#tests').find('option').remove();
        $.each(data, function (index, value) {
            $('#tests').append(new Option(value, value));
        });
    }
</script>
</body>
</html>
