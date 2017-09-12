<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
<table align="center"border="1">

<tr>
<td colspan="2" align="center"> 목록보기</td>
</tr>
<tr>
<td>제품명</td>
<td>제조사</td>
</tr>
<tr>
<td>제품명</td>
<td>${product.name} </td>
</tr>
<tr>
<td>종류</td>
<td>${product.category} </td>
</tr>
<tr>
<td>종류</td>
<td>${product.manufacture} </td>
</tr>
<tr>
<td>가격</td>
<td>${product.price} </td>
</tr>

<tr>
<td colspan="2" align="center">
<a href="../">메인</a>
<a href="inset">등록</a>
<a href="delete/id=${product.id}">삭제 </a><br/>
<a href="insert/id=${product.id}">업데이트 </a><br/>
</td>
</tr>
</table>
</body>
</html>
