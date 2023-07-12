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
		
		<h1 align="center">회원가입</h1>
		
		<main>
			<form action="" method="POST" onsubmit="return checkValid();">
				<input type="text" name="id" placeholder="아이디">
				<br>
				<input type="password" name="pwd" placeholder="비밀번호">
				<br>
				<input type="password" name="pwd2" placeholder="비밀번호 확인">
				<br>
				<input type="text" name="nick" placeholder="닉네임">
				<br>
				<input type="submit" value="회원가입">
			</form>
		</main>
		
	</div>

	<script>

		function checkValid(){
			const pwdInputTag = document.querySelector("main > form > input[name='pwd']");
			const pwd = pwdInputTag.value;
			if( pwd.length < 4 ){
				alert("패스워드는 4글자 이상 입력해주세요");
				return false;
			}
			return true;
		}

	</script>
	
	

</body>
</html>
















