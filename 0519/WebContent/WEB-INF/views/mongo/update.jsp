<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>업뎃</title>
</head>
<body>
<table align="center" border="1">
<form action ="update"  method="post">
<tr>
<td>제품종류</td>
<td>
<input type="text" name="name" value="${product.name }"/>
</td>
</tr>
<tr>
<td>원산지</td>
<td>
<input type="text" name="name" value="${product.manufacture }"/>
</td>
</tr>
<tr>
<td>가격</td>
<td>
<input type="text" name="name" value="${product.price }"/>
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type=" submit" value="수정완료"/>&nbsp;
<input type=" button" id="mainbtn"value="메인으로"/>&nbsp;
</td> 
</tr>
<input type="hidden" name="id" value="${product.id }"/>
</form>
</table>

<script >
window.onload=function(){
	document.getElementByid("mainbtn").onclick=function(){
		location.href="../";
	}
}
</script>
</body>
</html>