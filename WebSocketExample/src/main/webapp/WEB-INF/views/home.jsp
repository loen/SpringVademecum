<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
    <title>Web Socket Example [Home page]</title>
    <script src="<c:url value="/resources/jquery-2.2.2.min.js"/>"></script>
</head>
<body>
    I'm home
</body>
<script>
    $(document).ready(function(){
        if (typeof jQuery != 'undefined') {

            alert("jQuery library is loaded!");

        }else{

            alert("jQuery library is not found!");

        }
    });
</script>
</html>
