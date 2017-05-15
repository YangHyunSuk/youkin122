<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>북마크 처리페이지</title>


</head>
<body>

<a href="../" id="favorite" title="home">홈</a>
</body>
<script>
	var title = "이름";   
		var url = "주소";
		var agent = navigator.userAgent.toLowerCase();
		

if ((navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1)||(agent.indexOf("msie") != -1) ){
window.external.AddFavorite( url, title);}
else {
alert("Ctrl+D키를 누르시면 즐겨찾기에 추가하실 수 있습니다.");
}	

</script>

</html>