<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

	.view-area ,
	.form-area 
	{
		display: none;
	}

	.active{
		display: block;
	}

</style>

</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
		
			<h1>갤러리 상세조회</h1>
			
			<div class="view-area active">
				<span>${vo.title}</span>
				
				<hr />
				
				<img 
					src="${root}/static/img/gallery/${vo.changeName}"
					alt="${vo.originName}" 
					width="500" 
					height="500"
				>
				
				<p>${vo.content}</p>

				<c:if test="${vo.writerNo eq loginMember.no }">
					<a class="btn btn-warning" href="javascript:toggleArea();">수정</a>
					<a class="btn btn-danger" href="${root}/gallery/del?no=${vo.no}">삭제</a>
				</c:if>

			</div>

			<div class="form-area">
				<form action="${root}/gallery/edit" method="POST" enctype="multipart/form-data">
					<input type="hidden" value="${vo.no}" name="no">
					<input type="text" name="title" value="${vo.title}">
					
					<hr>
					
					<div>기존파일 : ${vo.originName}</div>

					<label>수정할 파일 (수정안할거면 안넣어도 됨) : </label>
					<input type="file" name="f">
					
					<hr>
					
					<textarea name="content">${vo.content}</textarea>
					<br>
					<input type="submit" value="수정하기">
				</form>
			</div>



			
			<hr>
			
			
		
		</main>
		
	</div>

	<script>

		function toggleArea(){
			const viewArea = document.querySelector('.view-area');
			const formArea = document.querySelector('.form-area');

			viewArea.classList.remove('active');
			formArea.classList.add('active');
		}

	</script>

</body>
</html>
















