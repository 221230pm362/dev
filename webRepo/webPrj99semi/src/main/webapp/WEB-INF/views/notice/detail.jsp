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

	#notice-area{
		width: 600px;
		height: 400px;
		border: 1px solid black;
		margin: auto;
		display: grid;
		grid-template-columns: 1fr 1fr 1fr 1fr;
		grid-template-rows: 1fr 1fr 8fr;
	}

	#notice-area > div {
		border: 1px solid black;
		box-sizing: border-box;
		width: 100%;
		height: 100%;
	}

	#notice-area > div:not(:last-child) {
		display: flex;
		justify-content: center;
		align-items: center;
	}

	#notice-area > div:nth-child(2) {
		grid-column: span 3;
	}

	#notice-area > div:nth-child(7) {
		grid-column: span 4;
	}

	#notice-btn-area {
		display: flex;
		justify-content: center;
	}

	#reply-form-area {
		width: 600px;
		margin: auto;
		border-left: 1px solid black;
		border-right: 1px solid black;
		box-sizing: border-box;
		padding-left: 10px;
		padding-right: 10px;
	}

	#reply-form-area > input:first-child {
		width: 480px;
	}

</style>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
		
			<h1 align="center">공지사항 상세조회</h1>

				<div id="notice-area">
					<div>제목</div>
					<div>${ vo.title }</div>
					<div>작성일</div>
					<div>${ vo.enrollDate }</div>
					<div>조회수</div>
					<div>${ vo.hit }</div>
					<div>${ vo.content }</div>
				</div>

				<c:if test="${ loginMember.id == 'ADMIN' }">
					<div id="notice-btn-area">
						<a class="btn btn-warning" href="${root}/notice/edit?no=${vo.no}">수정하기</a>
						<a class="btn btn-danger" href="${root}/notice/delete?no=${vo.no}">삭제하기</a>
					</div>
				</c:if>

			<div id="reply-area">
				<input type="hidden" name="noticeNo" value="${vo.no}">
				<div id="reply-form-area">
					<input type="text" name="content" placeholder="댓글을 입력하세요">
					<input type="button" value="댓글쓰기" onclick="writeComment();">
				</div>
			</div>
		
		</main>
	
	</div>

</body>
</html>

<script>

	//댓글 작성
	function writeComment(){
		const comment = document.querySelector("input[name=content]").value;
		$.ajax({
			url : "${root}/notice/reply/write" ,
			type : "POST" ,
			data : {
				noticeNo : '${vo.no}' ,
				content : comment ,
			} ,
			success : (x)=>{
				console.log(x);
				if(x == 'ok'){
					alert("댓글 작성 성공!");
				}else{
					alert("댓글 작성 실패...");
				}
			} ,
			error : (x)=>{
				console.log(x);
			} ,
		});
	}

</script>












