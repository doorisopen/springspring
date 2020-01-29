<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chatting Room</title>
<link rel="stylesheet" href="./resources/css/chat.css">
</head>
<body>
	<div class="chat-container">
		<div class="banner">
			<h1>
				웹 소켓을 이용한 실시간 채팅
			</h1>
			<a href="/myspring">-(홈으로)-</a>
		</div>
		
		<div class="message-container">
			<div class="message-header">
		        <button type="button" onclick="openSocket();">채팅방 접속</button>
		        <button type="button" onclick="closeSocket();">채팅방 나가기</button>
		    </div>
			<!-- Server responses get written here -->
		    <div id="messages"></div>
		    <div class="input-container">
		        <input type="text" id="sender" placeholder="닉네임">
		        <input type="text" id="messageinput" placeholder="메시지를 입력해주세요">
		        <button type="button" onclick="send();">Send</button>
		    </div>
	    </div>
    </div>
    
    <!-- websocket javascript -->
    <script type="text/javascript">
        var ws;
        var messages=document.getElementById("messages");
        
        function openSocket(){
            if(ws!==undefined && ws.readyState!==WebSocket.CLOSED){
                writeResponse("WebSocket is already opened.");
                return;
            }
            //웹소켓 객체 만드는 코드
            ws=new WebSocket("ws://localhost:8080/myspring/echo.do");
            
            ws.onopen=function(event){
                if(event.data===undefined) return;
                
                writeResponse(event.data);
            };
            ws.onmessage=function(event){
                writeResponse(event.data);
            };
            ws.onclose=function(event){
                writeResponse("Connection closed");
            }
        }
        
        function send(){
            var text=document.getElementById("sender").value+": "+document.getElementById("messageinput").value;
            ws.send(text);
            text="";
        }
        
        function closeSocket(){
            ws.close();
        }
        function writeResponse(text){
            messages.innerHTML+="<p>"+text+"</p>";
        }
  </script>
</body>
</html>