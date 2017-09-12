<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터삽입</title>
</head>
<body>

<!--  action은 생략하면 요청주소가 되고 method는 생략하면 get 이된다  -->
<form action="insert" method="post">
이름:<input type="text" name="name" required="required" placeholder="제품이름을 입력"/><br/>
종류:<input type="text" name="category" required="required" placeholder="제품종류"/><br/>
제조사:<input type="text" name="manufacture" required="required" placeholder="제조사입력"/><br/>
가격:<input type="text" name="price" required="required" placeholder="제품가격"/><br/>

<input type="submit" value="작성완료 "/>
</form>
</body>
</html>