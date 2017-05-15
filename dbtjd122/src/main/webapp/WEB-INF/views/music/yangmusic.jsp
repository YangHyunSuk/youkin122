<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인</title>

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role='page'>
<div data-role='header' data-position='fixed'>
<h2>모바일웹</h2>
</div>

<div data-role='content'>
<ul data-role="lisetview">
<li data-role="list-divider">4월의 노래</li>
<c:forEach var="yangsong" items="${list}">
<li>
<a href="#" onclick="play('${yangsong.song}')"data-ajax='false'>
<img width=100 height=100 src="/resources/image/${yangsong.image}">
<h3>${yangsong.song}</h3>
<p>${yangsong.singer}</p>
<span class="ui-li-count">${yangsong.num}</span>
</a>
</c:forEach>
</ul>
</div>

<script>
function play(song){
	var audio= new Audio('/resources/song/'+song);
	audio.voulume=0.5;
	audio.play();
}
</script>


<div data-role='footer'>
<h3>바닥글</h3>
</div>
</div>
</body>
</html>