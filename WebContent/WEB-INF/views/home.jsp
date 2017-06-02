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
OS:windows <br/>
Langugo:java <br/>
IDE:STS(Spring Tool suite)  <br/>
DB : Oracle, MongoDB <br/>
Front End :HTML ,CSS,JavaScript <br/>
Front work : Spring Jquery   <br/>
Mybatis Jquery<br/>
Mobile  node.js boot strop<br/>    
Open APi:Daum Map APi   Google chart API<br/>

<div data-role='content'>
<ul><li><a><img width=500 height=500 src="resources/image/Springview.png"></a></ul>
</div>

<a href="board/index">전체 데이터보기 </a><br/>

<%@ include file="include/footer.jsp" %>
</body>
</html>
