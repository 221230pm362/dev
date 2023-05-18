<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#write-area{
		width: 600px;
		display: grid;
		grid-template-columns: 1fr 3fr 1fr 1fr;
		grid-template-rows: 30px 470px 100px;
	}

	#write-area > textarea {
		grid-column: span 3;
	}

	#write-area > label > input {
		display: none;
	}

</style>
</head>
<body>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1>게시글 상세조회</h1>

			<div id="btn-area">
				<button class="btn btn-warning btn-sm" onclick="edit();">수정</button>
				<button class="btn btn-danger btn-sm" onclick="del();">삭제</button>
			</div>
			
			<form action="${root}/board/write" method="post" enctype="multipart/form-data">
				<div id="write-area">
					<span>제목</span>
					<input type="text" name="title" value="${vo.title}">
					<span>카테고리</span>
					<div>${vo.categoryName}</div>
					<span>내용</span>
					<textarea name="content">${vo.content}</textarea>
					<label>
						첨부파일
					</label>
					<div id="preview-area">
						<c:forEach items="${attList}" var="att">
							<img width="100" height="100" alt="첨부파일" src="${root}/static/img/board/${att.changeName}">
						</c:forEach>
					</div>
				</div>
				<input type="submit" value="작성하기">
			</form>

			
		</main>
		
	</div>

	<script>

		//미리보기
		const fileTag = document.querySelector("input[type=file]");
		const previewArea = document.querySelector("#preview-area");
		

		fileTag.onchange = function(e){
			
			if(fileTag.files.length == 0){		//취소누른상태
				previewArea.innerHTML = '';
				return;
			}

			for(let i = 0 ; i < fileTag.files.length; i++){
				const fr = new FileReader();
				fr.readAsDataURL(fileTag.files[i]);
	
				fr.onload = function(e){
					const imgTag = document.createElement('img');
					imgTag.src = e.target.result;
					imgTag.alt = "미리보기이미지사진";
					imgTag.width = 100;
					imgTag.height = 100;
					previewArea.appendChild(imgTag);
				};
			}


		};
		
		//게시글 삭제 요청
		function del(){
			const result = confirm("진짜 삭제 ??");
			if(!result){
				return;
			}
			location.href = '${root}/board/del?no=' + '${vo.no}';
		}

	</script>

</body>
</html>









