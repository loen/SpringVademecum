<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
    <title>Entries</title>
</head>
<h1>Entries: </h1>
<c:forEach items="${entries}" var="entry">
  <li>
    <div>
      <c:out value="${entry}"/>
    </div>
  </li>
</c:forEach>
</br>
<h1>Took <c:out value="${duration}"/> milliseconds</h1>
<a href="<s:url value="/cacheTest/reset"/>">Reset!</a>
</body>
</html>
