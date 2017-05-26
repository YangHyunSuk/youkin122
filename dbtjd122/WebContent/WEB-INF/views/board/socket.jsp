<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>소켓 통신</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- jquery mobile의 stylesheet -->
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<!--    -->
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<!-- jquery mobile 링크  -->
<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
</head>
<body>
<input type="button" value="웹 소켓 시작" onclick="start()">

	 <input type="button" onclick="location.href='mail.do'" value="메일보내기" />
	<input type="button" value="proxy 가져오기" onclick="proxy()">
	<input type="button" value="웹 푸시 시작" onclick="pushStart()">
	<br /> 
	닉네임:
	<input type="text" id="nick" size="20"/><br/>
	보내는 메시지:
	<input type="text" id="message" size="60"/>
	<input type="button" onclick="start()" value="전송" /><br />
	받은 메시지:<textarea id="disp" cols="80" rows="20"></textarea>
</body>
<script>
var webSocket = 
	      new WebSocket('ws://localhost:8080/board/websocket');
webSocket.onerror = function(event) {
	onError(event)
};
webSocket.onopen = function(event) {
	onOpen(event)
};
webSocket.onmessage = function(event) {
	onMessage(event)
};

function onMessage(event) {
	$('#disp').val($('#disp').val() + '\n' + event.data);
}
function onOpen(event) {
	document.getElementById('disp').value = 'Connection established';
}

function onError(event) {
	alert(event.data);
}

function start() {
	webSocket.send($('#nick').val() + ":" + $('#message').val());
	$('#message').val('');
	return false;
}

	    </script>
</html>