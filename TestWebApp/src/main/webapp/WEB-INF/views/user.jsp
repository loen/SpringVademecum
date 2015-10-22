<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Your profile</h1>
username: <c:out value="${user.username}"/></br>
id: <c:out value="${user.id}" /></br>
first name: <c:out value="${user.firstName}" /></br>
last name: <c:out value="${user.lastName}" /></br>
