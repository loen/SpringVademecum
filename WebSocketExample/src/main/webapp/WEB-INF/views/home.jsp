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
    <br>
    <div id="live">Socket msgs</div>
</body>
<script>
    $(document).ready(function(){
        var url = 'ws://' + window.location.host + '/simple';
        var sock = new WebSocket(url);
        sock.onopen = function(){
            $('#live').empty();
            $('#live').append('SOCKET OPENED <br>');
            sock.send("Who Are YOU?");
        }

        sock.onmessage = function(e){
            $('#live').append('Recieved: ' + e.data + ' <br>');
            sock.send("Who Are YOU?");
        }
        sock.onclose = function(){
            $('#live').empty();
        }
    });
</script>
</html>
