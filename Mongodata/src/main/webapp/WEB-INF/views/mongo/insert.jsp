<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터 삽입</title>
</head>
<body>
	<!-- action은 생략하면 요청 주소가 되고 method는 생략하면
	get이 됩니다. -->
	<form action="insert" method="post">
		이름:<input type="text" name="name" required="required"
		placeholder="제품 이름을 입력하세요" /><br />
		종류:<input type="text" name="category" required="required"
		placeholder="제품 종류를 입력하세요" /><br />
		제조사:<input type="text" name="manufacture" required="required"
		placeholder="제조사를 입력하세요" /><br />
		가격:<input type="text" name="price" required="required"
		placeholder="제품 가격을 입력하세요" /><br />
	
		<input type="submit" value="작성완료" />
	</form>
</body>
</html>