<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page session="false" %>
<html>
    <head>
        <title><s:message code="home.title" /></title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
    </head>
    <h2>Welcome in TestWebApp</h2>
    <a href="<s:url value="/spittles"/>">Spittles</a> |
    <a href="<s:url value="/spittles/register"/>">Register</a>
    </br>
    <s:escapeBody htmlEscape="true">
        <h1>escapeExample</h1>
    </s:escapeBody>
    </body>
</html>
