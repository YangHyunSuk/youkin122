<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트</title>
</head>
<body>

<%@ include file="../include/header.jsp" %>
<div class="box">
<div class="box-header with-border">
<h3 class="box-title">게시판목록보기</h3>
<h5 class="box-title">${msg}</h5>
</div>
<div class="box-header with-boder">
<span>목록개수</span>
<select id="count" class="form -control">
<option value="5"
<c:out value="${pageMaker.criteria.perPageNum==5?'selected':'' }"/>>5개씩</option>
<option value="10"
<c:out value="${pageMaker.criteria.perPageNum==10?'selected':'' }"/>>10개씩</option>
<option value="15"
<c:out value="${pageMaker.criteria.perPageNum==15?'selected':'' }"/>>15개씩</option>
<option value="20"
<c:out value="${pageMaker.criteria.perPageNum==20?'selected':'' }"/>>20개씩</option>

</select>
</div>
<script>

//여러번작성해도 모두동작
$(function(){
	//선택상자의 선택이변경되면
	var cnt=document.getElementById("count");
	var searchType=document.getElementById("searchType");
	var keyword=document.getElementById("keyword");
cnt.onchange=function(){
//board/list 요청을 보내고 이ㅏ때 page =1 페이지 페이지당 데이터 출력개수는 선택한항목 값으로 
	location.href="/board/list?page=1&perPageNum="
+cnt.value+"&searchType="+searchType.value+"&keyword="+keyword.value;
}
})
</script>

<div class="box-body">

<table class="table table-bordered">

<tr>
<th width="70">글번호</th> 
<th>제목</th>
<th>내용</th>
<th>작성자</th>
<th width="70">조회수</th>
</tr>
<c:forEach var="vo" items="${list}">
<tr>
<td align="right">${vo.bno}&nbsp;</td>
<td>&nbsp;
<a href="detail?bno=${vo.bno}&page=${pageMaker.criteria.page}&perPageNum=${pageMaker.criteria.perPageNum}&searchType=${criteria.searchType}&keyword=${criteria.keyword}">${vo.title}<span class="badge bg-red">${vo.replyCnt}</span></a>
</td>
<td>${vo.title}</td>
<td>${vo.writer}</td>
<td>${vo.readcnt}</td>
<td align="right">
<span class="badge bg-blue">
${vo.readcnt}</span></td>
</tr>
</c:forEach>
</table>
</div>
<div class="box-footer">
<div class="text-center">
<ul class="pagination">

<c:if test="${pageMaker.prev}">
<li>
<a href="/board/list?page=${pageMaker.startPage-1}&perPageNum=${pageMaker.criteria.perPageNum}&searchType=${criteria.searchType}&keyword=${criteria.keyword}">이전</a>
</li>
</c:if>

<c:forEach var="idx"  begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
<li <c:out value="${pageMaker.criteria.page==idx?'class=active':''}"/>>
<a href="/board/list?page=${idx}&perPageNum=${pageMaker.criteria.perPageNum}&searchType=${criteria.searchType}&keyword=${criteria.keyword}">${idx}</a>
</li>
</c:forEach>


<c:if test="${pageMaker.next}">
<li>
<a href="/board/list?page=${pageMaker.endPage+1}&perPageNum=${pageMaker.criteria.perPageNum}&searchType=${criteria.searchType}&keyword=${criteria.keyword}">다음</a>
</li>
</c:if>
</ul>
</div>
<div class="box-body" align="right">

<div align="center">
<select name="searchType" id="searchType" >
<option value="n"
		<c:out value="${cri.searchType == null?'selected':''}"/>>
		---</option>

<option value="t"
		<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
		제목</option>
		
<option value="c"
		<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
		내용</option>
<option value="w"
		<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
		작성자</option>
<option value="tc"
		<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
		제목또는내용</option>
<option value="cw"
		<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
		내용 또는 작성자</option>
</select>
<input type="text" name="keyword" id="keyword" size='40' value="${criteria.keyword}"/>
<button class="btn-warning" id="searchBtn">검색</button>
<button class="btn-danger" id="newBtn">새글</button>
<button class="btn-danger" id="mainBtn">메인으로</button>
<div>
</div>
<script>
$(function(){
	var newBtn =document.getElementById("newBtn");
	newBtn.onclick=function(){
		location.href="register";
		
	};
	var mainBtn =document.getElementById("mainBtn");
	mainBtn.onclick=function(){
		location.href="../";
		
	};												
	var searchBtn =document.getElementById("searchBtn");
	var searchType=document.getElementById("searchType");
	var keyword=document.getElementById("keyword");
	searchBtn.onclick=function(){location.href="/board/list?page=1&perPageNum=${pageMaker.criteria.perPageNum}&searchType="+searchType.value+"&keyword="+keyword.value;
	};
});
</script>

</div>
</div>
<%@ include file="../include/footer.jsp" %>
</body>
</html>
