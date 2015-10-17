<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<html>
    <head>
        <title>TestWebApp</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
    </head>
    <body>
    <h2>Welcome in TestWebApp</h2>
    <a href="<c:url value="/spittles"/>">Spittles</a> |
    <a href="<c:url value="/spittles/register"/>">Register</a>
    </body>
</html>
