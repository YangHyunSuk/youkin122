<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<%@ include file="../include/header.jsp"%>

	<div class="box-header with-border">
		<form enctype="multipart/form-data" method="post" id="regForm">
			<p align="center">
			<table width="60%" align="center">
				<tr>
					<td colspan="3" align="center">
						<h2>회원가입</h2>
					</td>
				</tr>

				<tr>
					<td rowspan="4" align="center"><img id="image" width="200"
						border="1" /> <br /> <input type="file" id="imginp" name="image" />
					</td>
				</tr>

				<tr>
					<td align="right" height="50">아이디</td>
					<td>&nbsp;<input type="text" name="id" id="id"
						placeholder="아이디를입력하세요" required="required" class="form-control" />
						<div id="idmsg"></div>
					</td>
				</tr>


				<tr>
					<td align="right" height="50">비밀번호</td>
					<td>&nbsp;<input type="password" name="pw" id="pw"
						placeholder="비밀번호를입력하세요" required="required" class="form-control" />
					</td>
				</tr>


				<tr>
					<td align="right" height="50">이름</td>
					<td>&nbsp;<input type="text" name="name" id="name"
						placeholder="이름입력" required="required"
						pattern="([a-z,A-Z,가-힣]){2,}" class="form-control" />
					</td>
				</tr>

				<tr>
					<td colspan="3" align="center"><input type="submit"
						class="btn btn-warning" value="회원가입">&nbsp; <input
						type="button" class="btn btn-primary" value="메인으로">&nbsp;
					</td>

				</tr>

			</table>
			</p>
		</form>
	</div>
	<script>
var chk;
$(function(){
$('#id').on('blur',function(){
chk=1
		//id 값을 서버로 전송해서 있는지 없는지 확인 
	//ajax로 확인한다 
	var v= $('#id').val();
$.ajax({
	url:"/user/idcheck",
	data:{"id":v},
	dataType:"json",
	success:function(data){
		
		if(data.result=='true'){
			$('#idmsg').html("사용이가능하답디다");
		chk=0
		}
		else{
			$('#idmsg').html("사용 불가능한아이디입다.");
			
	}
	}	
	});
	});
	$('#regForm').on('submit',function(){
	if(chk==0){
		return true;
	}
	else{
	$("#idmsg").html('아이디 중복검사를하세요')
	return false;
	}
	})
		//false를 리턴하면 전송하지 않고 
	//true를 리턴하거나 아무것도 리턴하지 않으면 전송한다 .
	//alert("앙")
	
	$(".btn-primary").on('click',function(){
		location.href="/";	
	});
	$("#imginp").on("change",function(){
		readURL(this);
	});
});
function readURL(param){
//사용자가 파일을 선택했다면 
//javascript나 python 같은 언어는 null과 0 은 false로 간주하고 그렇지 아니하면 true로 간주한다.
if(param.files && param.files[0]){
//파일이름 가져오기 
var filename=param.files[0].name;
var idx=filename.lastIndexOf('.');
var ext=filename.substr(idx+1);
alert(ext);
//확장자가 그림파일이아닐경우 빠져나가기
if(ext.toLowerCase()!='jpg'&&
	ext.toLowerCase()!='jpeg'&&
	ext.toLowerCase()!='bnp'&&		
	ext.toLowerCase()!='jpeg'&&
	ext.toLowerCase()!='gif'&&
	ext.toLowerCase()!='png'){
		alert("그림파일이 아니다");
	return;
	}
	//그림파일이라면 그림파일의 내용을 읽어서 
	//id가 image 인 영역에 출력하기 
	var reader =new FileReader();
	//파일의 내용을 전부 읽으면 호출되는 함수를 설정 콜백함수-이벤트헨들러는 전부콜백함수ㅡ 
	reader.onloar=function(e){
	$('#image').attr('src',e.target.result);		
	
	}
	//파일읽기 객체에 파일경로 설정
	reader.readAsDataURL(param.files[0]);
}
}
</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>