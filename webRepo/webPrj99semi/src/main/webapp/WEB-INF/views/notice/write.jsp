<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#form-area{
		font-size: 32px;
		margin-top: 30px;
		display: grid;
		row-gap: 20px;
	}

	#form-area > input {
		width: 100%;
		height: 40px;
		border: 3px solid black;
	}

	#form-area > textarea {
		width: 100%;
		height: 350px;
		border: 2px solid black;
		resize: none;
	}

</style>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
		
			<h1 align="center">공지사항 작성</h1>

			<form action="${pageContext.request.contextPath}/notice/write" method="POST">
				<div id="form-area">
					<input type="text" name="title" placeholder="제목을 입력하세요">
					<textarea name="content" placeholder="내용을 입력하세요"></textarea>
					<input type="submit" value="작성하기">
				</div>
			</form>
		
		</main>
	
	</div>

</body>
</html>














