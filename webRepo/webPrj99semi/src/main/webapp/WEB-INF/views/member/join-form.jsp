<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/member/join-form.css">
<script defer src="${pageContext.request.contextPath}/static/js/member/join-form.js"></script>
</head>
<body>

	<div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>

        <main>

            <form action="${pageContext.request.contextPath}/member/join" method="post" onsubmit="return checkValidation();" enctype="multipart/form-data">

                <div id="join-area">
                    <span>아이디</span>
                    <input type="text" name="memberId">
                    <span>비밀번호</span>
                    <input type="password" name="memberPwd">
                    <span>비밀번호확인</span>
                    <input type="password" name="memberPwd2">
                    <span>닉네임</span>
                    <input type="text" name="memberNick">
                    <span>프로필 사진</span>
                    <input type="file" name="memberProfile">
                    <span>취미</span>
                    <div>
                        <label>
                            코딩<input type="checkbox" name="hobby" value="20">
                        </label>
                        <label>
                            게임<input type="checkbox" name="hobby" value="30">
                        </label>
                        <label>
                            운동<input type="checkbox" name="hobby" value="40">
                        </label>
                        <label>
                            요리<input type="checkbox" name="hobby" value="50">
                        </label>
                    </div>

                    <input type="reset" value="초기화">
                    <input type="submit" value="회원가입">
                </div>


            </form>

        </main>

    </div>

</body>
</html>