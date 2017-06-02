<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Board</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="/dbtjd122/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/dbtjd122/resources/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="/dbtjd122/resources/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.comrespond/1.4.2respond.min.js"></script>
    <![endif]-->

</head>
<!-- jQuery 2.1.4 -->
<script src="/dbtjd122/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="#" class="logo"> <span class="logo-lg">SpringBoard</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>
			</nav>
		</header>
	</div>

	<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">
			<ul class="sidebar-menu">
				<li class="header">MAIN NAVIGATION</li>
				<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
						<span>게시판</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="/dbtjd122/board/list"><i class="fa fa-circle-o"></i>
								목록보기</a></li>
										<c:if test="${LOGIN!=null}">
						<li><a href="/dbtjd122/board/register"><i class="fa fa-circle-o"></i> 게시물쓰기</a></li>
						</c:if>
					</ul></li>
				<c:if test="${LOGIN!=null}">
					<li><a href="/dbtjd122/board/register"><i
							class="fa fa-circle-o text-red"></i> <span>글쓰기</span></a></li>
					<li><a href="/dbtjd122/board/list"><i
							class="fa fa-circle-o text-yellow"></i> <span>list</span></a></li>
					<li><a href="/dbtjd122/user/logout"><i
							class="fa fa-circle-o text-red"></i> <span>로그아웃</span></a></li>
				</c:if>
				<c:if test="${LOGIN==null}">
					<li><a href="/dbtjd122/user/register"><i
							class="fa fa-circle-o text-red"></i> <span>회원가입</span></a></li>
				</c:if>
<li><a href="/dbtjd122/home2"><i class="fa fa-circle-o text-red"></i> <span>개발자 홈페이지 </span></a></li>
<li><a href="/dbtjd122/board/list"><i class="fa fa-circle-o text-yellow"></i> <span>list</span></a></li>
<li><a href="/dbtjd122/music/yangmusic"><i class="fa fa-circle-o text-yellow"></i> <span>음악 감상</span></a></li>						
<li><a href="/dbtjd122/user/jido"><i class="fa fa-circle-o text-yellow"></i> <span>상담소 위치</span></a></li>
<li><a href="/dbtjd122/board/bookmark"><i class="fa fa-circle-o text-yellow"></i> <span>즐겨찾기 추가</span></a></li>
<li><a href="/dbtjd122/pasing/message"><i class="fa fa-circle-o text-yellow"></i> <span>관리자에게 메세지보내기</span></a></li>
<li><a href="/dbtjd122/board/socket"><i class="fa fa-circle-o text-yellow"></i> <span>web소켓채팅</span></a></li>
<li><a href="http://127.0.0.1:9003/"><i class="fa fa-circle-o text-yellow"></i> <span>Node소켓채팅</span></a></li>
<li><a href="/mongodata/mongo/insert"><i class="fa fa-circle-o text-yellow"></i> <span>MongoDB(inset)</span></a></li>
<li><a href="/mongodata/mongo/list"><i class="fa fa-circle-o text-yellow"></i> <span>MongoDB(list)</span></a></li>

				<li><a href="/dbtjd122"><i class="fa fa-circle-o text-yellow"></i>
						<span>home</span></a></li>

			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>Start</h1>
			<ol class="breadcrumb">
				<footer class="main-footer">
					<c:if test="${LOGIN!=null}">
						<span class="badge bg-red">${LOGIN.name}</span>
					</c:if>
					
					
					
					<div class="box">
						<c:if test="${LOGIN==null}">
							<div class="box-header with-border">
								<a href="/dbtjd122/user/login"><h3 class="box-title">로그인</h3></a>
						
							</div>
						</c:if>
						<c:if test="${LOGIN!=null}">
							<div class="box-header with-border">
								<a href="/dbtjd122/user/logout"><h3 class="box-title">로그아웃</h3></a>
							</div>
						</c:if>
					</div>

					<c:if test="${LOGIN==null}">
						<div class="box-header with-border">
								<a href="/dbtjd122/user/register"><h3 class="box-title">회원가입</h3></a>
							<br/>
					<a href="/dbtjd122/user/kakao"><img height="40" src="/dbtjd122/resources/naverimg/o.jpg" ></a>
					<a href="/dbtjd122/user/callback"><img height="50" src="/dbtjd122/resources/naverimg/icon1.PNG"/></a>
					<br/>
					<a href="/dbtjd122/"><i class="fa fa-dashboard"></i> Home</a>
					<a href="/dbtjd122/board/list"><i class="fa fa-dashboard"></i> list</a>
			
							</div>
					</c:if>
				</footer>
				
					
		
			</ol>
		</section>