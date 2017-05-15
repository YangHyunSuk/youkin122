<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메일</title>
</head>
<body>
<form role="form" method="post" id="mailForm">
<div class="box-title">
<input type="text" value="보내는사람" id="from"/>
<input type="text" value="e-mail" id="tubject"/>
<textarea name="content" class="form-control" placeholder="내용입력" rows="5"></textarea>
<input type="submit" value="보내기">
</div>
</form>
<script>
document.getElementById("mailForm").onsubmit=function(){
	var writer =document.getElementById("writer");
	var msgwriter=document.getElementById("msgwriter");
	if(writer==null||writer.value.length==0){
		msgwriter.innerHTML="작성자는 필수 입력입니다.";
		return false;
	}
};
</script>
</body>
</html>