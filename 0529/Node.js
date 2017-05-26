//웹 서버를만들기위한모듈
var http = require('http')
//html 파일을 읽어서 출력하기 위한모듈 
var fs= require('fs')
//소켓통신을 위한모듈
var socketio = require('socket.io')

//9003번 포트로 접속하면 HTML page./html 파일을 출력해주는 웹서버생성
var server =http.createServer(function(request,response){
	fs.readFile('htmlpage.html', function(error,data){
		response.writeHead(200,{'Content-Type':'text/html'});
		response.end(data)
	});
}).listen(9003,function(){
	console.log('서버동작중');
});
//소켓 서버생성
//채팅서버로 사용:클라이언트로부터 메세지가 오면
//접속한 모든 클라이언트에게 받은 내용을 전송
var io=socketio.listen(server);
io.sockets.on('connection', function(socket){
	socket.on('message',function(data){
		//console.log(data)콘솔 확인	
	io.sockets.emit('message',data);	
	});
});
