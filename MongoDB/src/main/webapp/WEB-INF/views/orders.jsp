<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Orders</title>
</head>
<body>
All orders:</br>

<table>
  <c:forEach items="${orders}" var="order">
    <tr>
      <td><c:out value="${order.owner}"/></td>
      <br>
        <c:forEach items="${order.skus}" var="sku">
          <c:out value="${sku}"/></br>
        </c:forEach>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
