    xmlns:c="http://www.w3.org/1999/XSL/Transform" xmlns:c="http://www.w3.org/1999/XSL/Transform" xmlns:c="http://www.w3.org/1999/XSL/Transform" xmlns:c="http://www.w3.org/1999/XSL/Transform" xmlns:c="http://www.w3.org/1999/XSL/Transform"<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/06/2017
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Team List</title>
</head>
<body>
<h1>
    List team
</h1>

<h3>Persons List</h3>
<c:if test="${!empty listTeams}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Number of Win</th>
            <th width="120">Number of Lost</th>
            <th width="120">Number of Draw</th>
            <th width="60">Score</th>
            <th width="60">Logo</th>
            <th width="60">League ID</th>
        </tr>
        <c:forEach items="${listTeams}" var="team">
            <tr>
                <td>${team.id}</td>
                <td>${team.name}</td>
                <td>${team.numberOfWin}</td>
                <td>${team.numberOfLost}</td>
                <td>${team.numberOfDraw}</td>
                <td>${team.score}</td>
                <td>${team.logo}</td>
                <td>${team.league_id}</td>
                <%--<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>--%>
                <%--<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
