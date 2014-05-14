<%--
  Created by IntelliJ IDEA.
  User: Nazar_Sheremeta
  Date: 5/14/14
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Masturbate TV">

    <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <title>Room Stub</title>
    <script src="js/adapter.js"></script>
    <script src="js/jquery.js"></script>
    <script src='js/socket.io/socket.io.js'></script>
</head>

<body>
<h3>Michael's room stub</h3>
<h2>Your room is: ${room.name}. It has the capacity of ${room.capacity} users</h2>


<div id="chat">
</div>
<input type="text" id="text-field" />
<input type="button" name="send" value="!send"/>
<script>

    var socket =  io.connect('http://epuakyiw0447:9092');
    var room = '${room.name}'
    socket.emit('join', room);

    socket.on('message', function (message){
        $('#chat').append('<p>'+message+'</p>');
        $("html, body").animate({scrollTop: $(document).height()}, 500);
    });

    $('input[name="send"]').click(function(){
        var message = $('#text-field').val();
        $('#text-field').val('');
        socket.emit('message', message);
    });
</script>

</body>
</html>
