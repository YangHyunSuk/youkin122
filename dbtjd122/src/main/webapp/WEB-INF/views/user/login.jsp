<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="login-box">
	<div class="login-logo">
	<h2>Spring MVC Board</h2>
	</div>
	<!-- 로그인실패시 메세지 출력  -->
	<div>
	<h3>${msg}</h3>
	</div>
	<!-- 로그인 영역 -->
	<div class="login-box-body">
	<p class="login-box-msg">
		아이디와 비밀번호를 입력하세요
	</p>
	<form action="loginpost" method="post">
	<label>아이디</label>
	<input type="text" class="form-control" placeholder="아이디입력하시오" required="required" name="id"/>
	<label>비밀번호</label>	
	<input type="password" class="form-control" placeholder="비밀번호를입력" required="required" name="pw"/>
	<br/>
	<input type="checkbox" name="useCookie"/>
	<label>자동로긴</label>
	<input type="submit" value="로그인" class="btn btn-primary btnblock btn-flat"/>

</form>

<a href="" class="text-center">비밀번호 찾기</a>
<a href="/user/register" class="text-center">회원 가입</a>

</div>
</div>
<%@ include file="../include/footer.jsp" %>
</body>
</html>