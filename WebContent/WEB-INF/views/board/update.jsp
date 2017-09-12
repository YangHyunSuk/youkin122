<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물수정 </title>
</head>
<body>


<%@ include file="../include/header.jsp" %>
<section class="center">
<div class="box box-primary">
<div class="box-header">
<h3 class="box-title">게시물수정</h3>
</div>
<form role="form" method="post" action="../updateboard">
<!-- 글번호 넘겨주기 위해 ㅚ든 -->
<input type="hidden"  name= "bno"  value= "${vo.bno}" />
<div class="box-body">
<div class="form-group">
<label>제목</label>
<input type="text" name="title" class="form-control"  value="${vo.title}" /></div>
<div class="form-group">
<label>내용</label>
<textarea name="content" class="form-control" placeholder="내용입력" rows="5">${vo.content }</textarea>
</div>
<div class="form-group">
<label>작성자</label>
<input type="text" name="writer" class="form-control" value="${vo.writer}" readonly="readonly" />
</div>
</div>

<div class="box-footer">
<button type="submit" class="btn btn-primary">작성완료</button></div>
</form>
</div>
</section>
<%@ include file="../include/footer.jsp" %>
</body>
</html>
