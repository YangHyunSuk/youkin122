<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>request body</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
$("#sub").on("click",function(){
console.log('${contextPath}/web/json');
$.ajax({
type: "post",
url:"http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108",
data: {adminId : 'adminId', adminNm : 'adminNm'},
dataType: "JSON",
success: function(msg) {
alert('success');
},
error: function(xhr, status, error) {
alert('error');
}
});
});
});
</script>
</head>
<body>
<button id="sub">json 전송</button>
</body>
</html>