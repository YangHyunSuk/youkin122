<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
<table align="center" border="1">
<tr>
<td colspan="2" align="left">
<h2>목록보기</h2>
</td>
</tr>
<tr>
<td>제품명</td>
<td>제조사</td>
</tr>
<c:forEach var="vo" items="${list}">
<tr>
<td><a href="detail?id=${vo.id}">${vo.name}</a> </td>
<td>${vo.manufacture} </td>
<td><a href="insert/id=${product.id}">업데이트 </a><br/>
</tr>
</c:forEach>
<tr>
<td colspan="2" align="center"><a href='../'>메인으로</a><a href='insert'>삽입페이지</a></td>
</tr>
</table>
</body>
</html>
