<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
		
			<h1>갤러리 상세조회</h1>
			
			<span>${vo.title}</span>
			
			<hr />
			
			<img 
				src="${root}/static/img/gallery/${vo.changeName}"
				alt="${vo.originName}" 
				width="500" 
				height="500"
			>
			
			<p>${vo.content}</p>
			
			<hr>
			
			<c:if test="${vo.writerNo eq loginMember.no }">
				<a class="btn btn-warning" href="${root}/gallery/edit?no=${vo.no}">수정</a>
				<a class="btn btn-danger" href="${root}/gallery/del?no=${vo.no}">삭제</a>
			</c:if>
		
		</main>
		
	</div>

</body>
</html>
















