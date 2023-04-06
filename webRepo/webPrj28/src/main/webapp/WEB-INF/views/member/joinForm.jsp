<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

	<h1>회원가입</h1>

	<input type="text" name="memberId">
	<button id="btn01">중복확인</button>
	
	<script>
	
		$('#btn01').click( ()=>{
			
			const memberId = $("input[name=memberId]").val();
			
			$.ajax({
				url : "/app/member/dup-check" ,
				type : "post" ,
				data : {
					memberId : memberId ,
				} ,
				success : function(x){
					if(x == 'ok'){
						alert("사용가능한 아이디 입니다.");
					}else{
						alert("사용불가한 아이디 입니다.");
					}
				} ,
				error : function(x){
					alert("중복확인실패 ...");
					console.log(x);
				} ,
			});
			
		} );
		
	</script>
	
	
	

</body>
</html>