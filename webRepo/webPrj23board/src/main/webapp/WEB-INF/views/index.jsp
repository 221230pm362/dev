<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>인덱스ㅋㅋ</h1>
	
	<a href="/app23/board/write">게시글 작성</a>
	<br>
	<a href="/app23/board/list">게시글 목록</a>
	

</body>
</html>

<%
	String alertMsg = (String)session.getAttribute("alertMsg");
	
	session.removeAttribute("alertMsg");
%>

<%if( alertMsg != null ){%>
	
	<script>
		alert('<%= alertMsg %>');
	</script>
	
<%}%>










