<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>New Order</title>
</head>
<body>

<form method="post">
  Order Owner: <input type="text" name="owner" /></br>
  Sku name: <input type="text" name="sku" /></br>
  Quantity: <input type="number" name="quantity" /></br>
  <input type="submit" value="Create">
</form>
</body>
</html>