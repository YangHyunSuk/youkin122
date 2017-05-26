<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<%@ include file="include/header.jsp" %>
<h2 class="box-title">${msg}</h2>
<table border="3">
</table>
<div data-role='content'>
<ul><li><a><img width=500 height=500 src="resources/image/Springview.png"></a></ul>
</div>
<a href="mongo/insert">데이터 삽입 </a><br/>
<a href="mongo/list">전체 데이터보기 </a><br/>
<a href="board/index">전체 데이터보기 </a><br/>

<%@ include file="include/footer.jsp" %>
</body>
</html>
