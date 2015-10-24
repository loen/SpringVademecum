<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
  <title>Registration JSTL</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>Register</h1>
<sf:form method="post" commandName="userRegistration">

  First Name: <sf:input  path="firstName" />
              <sf:errors path="firstName" cssClass="error"/> </br>
  Last Name: <sf:input path="lastName" />
              <sf:errors path="lastName" cssClass="error"/> </br>
  Username: <sf:input path="username" />
              <sf:errors path="username" cssClass="error"/> </br>
  Password: <sf:password path="password" />
              <sf:errors path="password" cssClass="error"/> </br>

  <sf:errors path="*" element="div" cssClass="errors" />
  <input type="submit" value="Register">
</sf:form>
</body>
</html>
