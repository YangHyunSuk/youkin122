<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jsp 안에서 반복 및 if  c:out문사용시 사용하는 라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!--  댓글 수정버튼을 눌렀을때 대화상자로 출력될 영역 -->
	<div id="dialog" title="댓글수정">
		<p>댓글을입력하세요</p>
		<input type="text" id="replytext"
			class="text ud-widjet-content ui-corner-all" size="35" /> <input
			type="button" value="댓글수정" onclick='update()' /> <input
			type="button" value="작성취소" onclick='cancel()' />

	</div>
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세보기</h3>
			</div>
			<div class="box-body">
				<div class="form-group">
					<label>제목</label> <input type="text" name="title"
						class="form-control" value="${vo.title}" readonly="readonly" />
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea name="content" rows="5" class="form-control"
						readonly="readonly">${vo.content}</textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> <input type="text" name="writer"
						class="form-control" readonly="readonly" value="${vo.writer}" />
				</div>

			</div>
		</div>
		<div class="box- footer">
			<button id="main" class="btn btn-success">메인</button>
			<c:if test="${vo.writer==LOGIN.id}">
				<button id="update" class="btn btn-warning">수정</button>
				<button id="delete" class="btn btn-danger">삭제</button>
			</c:if>
			<button id="list" class="btn btn-primary">목록</button>
		</div>
		<br />
		<div>
			<button class="btn btn-primary" onclick="add()" id="addBtn">댓글
				작성</button>
		</div>
		<!-- 댓글작성영역 -->
		<div class="box-body" style="display: none;" id="replyform">
			<!--원본글번호저장  -->
			<input type="hidden" id="bno" value="${vo.bno}" /> <label>작성자</label>
			<input type="text" class="form-control" placeholder="작성자 이름을 입력하세요"
				id="newReplyWriter" /> <label>내용</label> <input type="text"
				class="form-control" placeholder="댓글을 입력하세요" id="newReplyText" />
			<button type="button" class="btn btn-warning" id="addReply">저장</button>
			<button type="button" class="btn btn-danger" id="cancelAdd">취소</button>

		</div>
		<!-- 댓글 출력 영역  -->
		<div id="replyDisp" class="box box-primary">

			<script>
				//댓글수정 버튼을 눌렀을때 호출될함수
				var rno = '0';
				function update() {
					//	alert("수정완료버튼클릭");
					var bno = '${vo.bno}';
					var replytext = $('#replytext').val();
					//완료후 닫기 
					$('#dialog').dialog('close');
					$.ajax({
						url : '/reply/update',
						data : {
							'rno' : rno,
							'bno' : bno,
							'replytext' : replytext
						},
						dateType : 'json',
						success : function(data) {
							//댓글영역에 삭제
							$('#replyDisp').html('');
							//댓글영역에 data 출력	
							display(data);
						}
					})
				}
				function mod(btn) {
					rno = btn.id.substr(3);
					$('#dialog').dialog('open');
				}
				//댓글 수정 대화살자에서 취소버튼을 눌렀을시 호출될함수
				function cancel() {
					$('#dialog').dialog('close');
				}

				//문서구조파악이 끝나면 이함수를 부른다
				$(function() {
					getReply();

					//댓글수정 대화상자옵션설정
					$('#dialog').dialog({
						autoOpen : false,
						show : {
							effect : 'blind',
							duration : 500
						},
						hide : {
							effect : 'explode',
							duration : 500
						}
					});

					$('#cancelAdd').on('click', function() {
						$('#addBtn').show('fast')
						$('#replyform').hide('slow');
					});

					$('#addReply').on('click', function() {
						var bno = $('#bno').val();
						var replyText = $('#newReplyText').val();
						var replyer = $('#newReplyWriter').val();
						$.ajax({
							url : "/reply/insert",
							data : {
								'bno' : bno,
								'replytext' : replyText,
								'replyer' : replyer
							},
							dataType : 'json',
							success : function(data) {
								//댓글작성버튼출력
								$('#addBtn').show('fast')
								//댓글작성영ㅇ역은 숨기고
								$('#replyform').hide('slow');
								//기존댓글은지우고
								$('#replyDisp').html('');

								$('#newReplyDisp').val('');
								$('#newReplyWriter').val('');
								//새로운댓글을출력
								display(data);

							}
						})
					});
				});
				//댓글작성을눌럿을시
				function add() {
					//alert("댓글삽입")
					$('#replyform').show('show')
					$('#addBtn').show('fast')

				}

				//ajax로 댓글요청
				function getReply() {
					$.ajax({
						url : "/reply/list",
						//글번호
						data : {
							bno : '${vo.bno}'
						},
						//데이터타입 정해져있고
						dataType : 'json',
						success : function(data) {
							display(data);
						}
					});
				};
				//가져온댓글을 출력하는함수
				function display(data) {
					//출력 내용을 저장할 변수 
					var disp = "";
					//가져온데이터가없을시
					if (data.length == 0) {

					}
					//data 순회
					//idx는 순번이고 item은 하나 하나의 데이터
					$(data)
							.each(
									function(idx, item) {
										disp += "<div style='width:80%;height:50px;'>";
										disp += "<label>" + item.replyer + ":"
												+ item.replytext;
										disp += "</label>"
										disp += "<button class='btn btn-danger' id=del"
												+ item.rno
												+ " ' style=float:right;' onclick='del(this)'>";
										disp += "댓글삭제</button>"
										disp += "<button class='btn btn-warning' id=mod"
												+ item.rno
												+ " ' style=float:right;' onclick='mod(this)'>";
										disp += "수정</button>"
										disp += "</div>"
										$("#replyDisp").append(disp);
										disp = "";

									});
				}
			</script>
		</div>
	</section>

	
	<script>
		function del(btn) {
			var rno = btn.id.substr(3);
			$.ajax({
				url : '/reply/delete',
				data : {
					'rno' : rno,
					'bno' : '${vo.bno}'
				},
				dataType : 'json',
				success : function(data) {
					$('#replyDisp').html('');
					display(data);
				}
			});
		}
		$(function() {
			$("#main").click(function() {
				//메인열떄처리
				location.href = "/";
			});
			//목록버튼
			$("#list")
					.click(
							function() {
								location.href = "/board/list?page=${criteria.page}&perPageNum=${criteria.perPageNum}&searchType=${criteria.searchType}&keyword=${criteria.keyword}";
							});
			//버튼눌렀을시삭제
			$("#delete").click(function() {
				location.href ="/board/delete/"+${vo.bno};});
			//수정버튼눌럿을시
			$("#update").click(function() {
				location.href = "/board/update/"+${vo.bno};});
		});
	</script>
	
<%@ include file="../include/footer.jsp" %>
</body>
</html>