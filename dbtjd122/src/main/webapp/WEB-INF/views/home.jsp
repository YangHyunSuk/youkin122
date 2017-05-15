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
<h5 class="box-title">${msg}</h5>
<div data-role='content'>
<ul><li><a><img width=500 height=500 src="/resources/image/Springview.png"></a></ul>
</div>

<%@ include file="include/footer.jsp" %>
</body>
<script type="text/javascript">
var mobileKeyWords = new Array('iPhone', 'iPod', 'BlackBerry', 'Android', 'Windows CE', 'LG', 'MOT', 'SAMSUNG', 'SonyEricsson');
for (var word in mobileKeyWords){
    if (navigator.userAgent.match(mobileKeyWords[word]) != null){
        location.href = "http://192.168.20.8:8080;
        break;
    }
}
</script>
</html>
