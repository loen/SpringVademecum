<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
Register new user:</br>
<form method="post">
    First Name: <input type="text" name="firstName" /></br>
    Last Name: <input type="text" name="lastName" /></br>
    <input type="submit" value="Create">
</form>
Show all users: </br>
<table>
<c:forEach items="${users}" var="user">
<tr>
    <td><c:out value="${user.id}"/></td>
    <td><c:out value="${user.firstName}"/></td>
    <td><c:out value="${user.lastName}"/> </td>
</tr>
</c:forEach>
</table>
</body>
</html>
