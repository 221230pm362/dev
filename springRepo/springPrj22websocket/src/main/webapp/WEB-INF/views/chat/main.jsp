<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>채팅</h1>
	
	<input type="text" id="msg">
	
	<button onclick="f01();">전송</button>
	
	<hr>
	
	<div id="result"></div>
	
	
	
	<script>
		const resultDiv = document.querySelector("#result");
		
		//웹소켓 만들기
		let ws = new WebSocket("ws://129.154.56.66:8888/warPrj/test");
		
		ws.onopen = funcOpen;
		ws.onclose = funcClose;
		ws.onerror = funcError;
		ws.onmessage = funcMessage;
	
		function funcOpen() {
			console.log("소켓연결됨 ~ !");
		}
		function funcClose() {
			console.log("소켓닫힘 ~ !");
		}
		function funcError() {
			console.log("소켓 에러남 ~ !");
		}
		
		
		
		function funcMessage(event) {
			console.log("소켓 통해서 메세지 받음 ~ !");
			const obj = JSON.parse(event.data);
			resultDiv.innerHTML += '<div>' 
								+ "<strong>[" + obj.nick + "]</strong>" 
								+ "<span> " + obj.msg + " </span>" 
								+ "<sub>" + obj.time + "</sub>" 
								+ '</div>';
		}
		
		
		function f01(){
			const userMsg = document.querySelector("#msg").value;
			ws.send(userMsg);
		}
		
		
	</script>

</body>
</html>









