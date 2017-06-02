<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">
					<h2>목록보기</h2>
				</td>
			<tr>
			<tr>
				<th>제품명</th>
				<th>제조사</th>
			</tr>	
			<c:forEach var="vo" items="${list}">
				<tr>
					<td><a href="detail?id=${vo.id}">${vo.name}</a></td>
					<td>${vo.manufacture }</td>
				</tr>	
			</c:forEach>	
			<tr>
				<td colspan="2" align="center">
				<a href='/dbtjd122'>[메인으로]</a>&nbsp;
				<a href='insert'>[제품등록]</a>
				</td>
			</tr>		
		</table>
</body>
</html>








