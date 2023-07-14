<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FINAL</title>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1>게시글 목록</h1>
			
			<hr>
			
			<c:forEach items="${voList}" var="vo">
				<h3>${vo.no} / ${vo.title} / ${vo.content}</h3>
			</c:forEach>
			
		</main>
		
	</div>

</body>
</html>










