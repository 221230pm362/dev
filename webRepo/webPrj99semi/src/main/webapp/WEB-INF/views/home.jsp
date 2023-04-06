<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/app/static/js/home.js"></script>
<link rel="stylesheet" href="/app/static/css/common/reset.css">
<style>
    #wrap{
        width: 800px;
        height: 100vh;
        margin: auto;
        border: 5px solid black;
        box-sizing: border-box;
    }

    header{
        width: 100%;
        height: 150px;

        display: grid;
        grid-template-columns: 1fr 3fr 1fr;
        grid-template-rows: 1fr;
    }

    #logo-area{background-color: red;}
    #member-area{background-color: blue;}

</style>



</head>
<body>

	<div id="wrap">

        <header>
            <div></div>
            <div id="logo-area">
                <img width="100%" height="150px" src="/app/static/img/logo.png" alt="로고이미지">
            </div>
            <div id="member-area">
                로그인화면
                또는
                현재유저정보
            </div>
        </header>

    </div>

</body>
</html>