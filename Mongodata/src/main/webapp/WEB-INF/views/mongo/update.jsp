<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 수정</title>
</head>
<body>
		<table border="1" align="center">
			<form action="update" method="post">
			<tr>
				<td colspan="2" align="center">
				<h2>제품수정</h2>
				</td>
			</tr>
			<tr>	 
				<td>제품이름</td>
				<td>
					<input type="text" name="name" value="${product.name}">
				</td>
			</tr>
			<tr>	 
				<td>제품종류</td>
				<td>
					<input type="text" name="category" value="${product.category}">
				</td>
			</tr>
			<tr>	 
				<td>원산지</td>
				<td>
					<input type="text" name="manufacture" value="${product.manufacture}">
				</td>
			</tr>
			<tr>	 
				<td>가격</td>
				<td>
					<input type="text" name="price" value="${product.price}">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정완료">&nbsp;
					<input type="button" id="mainbtn" value="메인으로" />
				</td>
			</tr>	
			
			<input type="hidden" name="id" value="${product.id }" />
			</form>
		</table>
		
		<script>
			window.onload = function(){
				document.getElementById("mainbtn").onclick = function(){
					location.href = "/dbtjd122";
				}
			}
		</script>
</body>
</html>







