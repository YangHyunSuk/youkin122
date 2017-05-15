<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>날짜 출력</title>
</head>
<body>
<input type="button" value="날짜 가져오기" onclick="proxy()"><a href="../">홈</a>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
//window.onload=function(){
function proxy(){
	$.ajax({
		url:"/pasing/download",
		data:{addr:'http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108'},
		dataType:'xml',
		success : function(data){
			var cities = $(data).find('city');
			  alert(cities.length);
			  $(data).find('data').each(function(index, item){
				var output = '';
              if(index % 6 == 0){          	           	
              	 output += '<table align="center">';
              	 output += '<tr><td>' + $(cities[index / 6]).text() + '</td></tr>';
              }
              output += '<table align="center"><tr><th>' + $(this).find('tmEf').text() + '</th>';              
              output += ':<th>' + $(this).find('wf').text() + '</th><tr></table>';
              
              if(index % 6 == 0){
              	output += '</table>';
              }
             
             document.body.innerHTML += output;
             $('body').html($('body').html() + output);
              
              
             //var view =output; 
             //$("#id").append(view);  //#id 에 viewtext 삽입
				})
		  }
	})
}

</script>

</body>
</html>