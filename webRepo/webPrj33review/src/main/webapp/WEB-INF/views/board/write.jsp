<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 작성하기</h1>
	
	<form action="/app/board/write" method="POST">
		<input type="text" name="title" placeholder="제목">
		<br>
		<textarea name="content"></textarea>
		<br>
		<input type="text" name="writer" placeholder="작성자">
		<br>
		<input type="submit" value="작성하기">
	</form>

</body>
</html>























