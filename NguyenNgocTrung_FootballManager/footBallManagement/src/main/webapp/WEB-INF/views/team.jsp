<%--suppress ALL --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--suppress ALL --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Team List</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc; cellpadding:10;
            cellspacing:10;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333; cellpadding:10;
            cellspacing:10;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0; cellpadding:10;
            cellspacing:10;}
        .tg .tg-4eph{background-color:#f9f9f9}


        a.button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 10px 15px 10px 8px;
        }
        a.btn{
            background-color: #f44336;
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 10px 15px 10px 8px;
        }
        .table {
            border: 1px;

        }
        .th{ width:10%;
        }
        .value{
            margin: 10px 15px 10px 8px;
        }

    </style>
</head>
<body>
<h1>
    List team
</h1>

<h3>Persons List</h3>

<c:url var="addAction" value="/team/add"/>

<form:form action="${addAction}" commandName="team" method="post">
    <table>
        <c:if test="${!empty team.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="league">
                        <spring:message text="League"/>
                    </form:label>
                </td>
                <td width="150">
                    <form:input path="league.name" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="league.name" />
                </td>
            </tr>
        </c:if>
            <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
            <tr>
            <td>
                <form:label path="numberOfLost">
                    <spring:message text="Number of Lost"/>
                </form:label>
            </td>
            <td>
                <form:input path="numberOfLost" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="numberOfWin">
                    <spring:message text="Number Of Win"/>
                </form:label>
            </td>
            <td>
                <form:input path="numberOfWin" />
            </td>
        </tr>
         <tr>
            <td>
                <form:label path="numberOfDraw">
                    <spring:message text="Number Of Draw"/>
                </form:label>
            </td>
            <td>
                <form:input path="numberOfDraw" />
            </td>
        </tr>
            <tr>
            <td>
                <form:label path="score">
                    <spring:message text="Score"/>
                </form:label>
            </td>
            <td>
                <form:input path="score" />
            </td>
        </tr>
            <tr>
            <td>
                <form:label path="logo">
                    <spring:message text="Logo"/>
                </form:label>
            </td>
            <td>
                <form:input path="logo" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="league">
                    <spring:message text="League Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="league.name" />
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty team.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Team"/>" />
                </c:if>
            </td>
        </tr>
        <input type="submit"
               value="<spring:message text="Add Team"/>" />
    </table>
</form:form>



<c:if test="${!empty listTeams}">
    <table class="tg">
        <tr>
            <th width="50">ID</th>
            <th width="120">Name</th>
            <th width="100">Number of Win</th>
            <th width="100">Number of Lost</th>
            <th width="100">Number of Draw</th>
            <th width="100">Score</th>
            <th width="100">Logo</th>
            <th width="100">League Name</th>
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
                <td>${team.league.name}</td>
                <td><a href="<c:url value='/edit/team/${team.id}'/>" >Edit</a></td>
                <td><a href="<c:url value='/remove/team/${team.id}' />" >Delete</a></td>
                <td><a href="<c:url value='/viewPlayers/${team.id}' />" >View Team Players</a></td>
            </tr>

        </c:forEach>
    </table>
</c:if>

</body>
</html>
