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
    List player
</h1>

<h3>Players List</h3>

<c:url var="addAction" value="/player/add"/>

<form:form action="${addAction}" commandName="player" method="post">
    <table>
        <c:if test="${!empty player.name}">
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
                    <form:label path="player">
                        <spring:message text="League"/>
                    </form:label>
                </td>
                <td width="150">
                    <form:input path="team.name" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="team.name" />
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
                <form:label path="Position">
                    <spring:message text="Position"/>
                </form:label>
            </td>
            <td>
                <form:input path="position" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="Photo">
                    <spring:message text="Photo"/>
                </form:label>
            </td>
            <td>
                <form:input path="photo" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="age">
                    <spring:message text="Age"/>
                </form:label>
            </td>
            <td>
                <form:input path="age" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="team">
                    <spring:message text="Team"/>
                </form:label>
            </td>
            <td width="150">
                <form:input path="team.name"  />
            </td>
        </tr>
       
        <tr>
            <td colspan="2">
                <c:if test="${!empty player.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Player"/>" />
                </c:if>
            </td>
        </tr>
        <input type="submit"
               value="<spring:message text="Add Player"/>" />
    </table>
</form:form>



<c:if test="${!empty listPlayers}">
    <table class="tg">
        <tr>
            <th width="50">ID</th>
            <th width="120">Name</th>
            <th width="100">Position</th>
            <th width="100">Goal</th>
            <th width="100">Age</th>
            <th width="100">Team Name</th>
        </tr>
        <c:forEach items="${listPlayers}" var="player">
            <tr>
                <td>${player.id}</td>
                <td>${player.name}</td>
                <td>${player.position}</td>
                <td>${player.photo}</td>
                <td>${player.age}</td>
                <td>${player.team.name}</td>
                <td><a href="<c:url value='/edit/player/${player.id}'/>" >Edit</a></td>
                <td><a href="<c:url value='/remove/player/${player.id}' />" >Delete</a></td>
            </tr>


        </c:forEach>
    </table>
</c:if>

</body>
</html>
