<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트</title>
</head>
<body>


<%@ include file="../include/header.jsp" %>
<section class="center">
<div class="box box-primary">
<div class="box-header">
<h3 class="box-title">글쓰기</h3>
</div>
<form role="form" method="post" id="registerForm">
<div class="box-body">
<div class="form-group">
<label>제목</label>
<input type="text" name="title" class="form-control" placeholder="제목입력" /></div>
<div class="form-group">
<label>내용</label>
<textarea name="content" class="form-control" placeholder="내용입력" rows="5"></textarea>
</div>
<div class="form-group">
<label>작성자</label>
<input type="text" name="writer"id="writer" class="form-control" value="${LOGIN.id}" readonly="readonly" />
<div id="msgwriter"></div>
</div>
</div>

<div class="box-footer">
<button type="submit" class="btn btn-primary">작성완료</button></div>
</form>
</div>
</section>
<script>
document.getElementById("registerForm").onsubmit=function(){
	var writer =document.getElementById("writer");
	var msgwriter=document.getElementById("msgwriter");
	if(writer==null||writer.value.length==0){
		msgwriter.innerHTML="작성자는 필수 입력입니다.";
		return false;
	}
};
</script>

<%@ include file="../include/footer.jsp" %>
</body>
</html>
