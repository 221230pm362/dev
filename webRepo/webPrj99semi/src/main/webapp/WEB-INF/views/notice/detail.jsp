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
		
			<h1 align="center">공지사항 상세조회</h1>

				<div id="form-area">
					<div>제목</div>
					<div>${ vo.title }</div>
					<div>작성일</div>
					<div>${ vo.enrollDate }</div>
					<div>조회수</div>
					<div>${ vo.hit }</div>
					<div>${ vo.content }</div>
				</div>
		
		</main>
	
	</div>

</body>
</html>














