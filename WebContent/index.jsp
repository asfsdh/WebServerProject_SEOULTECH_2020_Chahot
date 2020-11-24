<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>index.jsp</title>
<link href="css/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="main">
		<div id="top">
			<!-- title -->
			<div id="top_title">☯서울과학기술대학교 모의 관리 시스템☯</div>
			<!-- 등록 후 전달하는 유저의 이름 -->
			<div id="top_info">${loginUser.userName}님 환영합니다.</div>
		</div>
		<!-- left 부분: 메뉴의 항목을 클릭한후 대응하는 페이지 내용을 right로 전달 -->
        <div id="left">
			<ul>
			<c:forEach items="${loginMenus}" var="menu">
			<li>
				<a href="/SchoolManagementSystem/RouteServlet?childPage=${menu[1]}">${menu[0]}</a>
			</li>
			</c:forEach>
			</ul>
		</div>
		<!-- right 부분: 구체적인 내용 제시 -->
		<div id="right">
			<c:if test="${empty childPage}">
	  			공지: 서울과학기술대학교 모의 관리 시스템 인덱스 페이지입니다.<br><hr>
	  			<br>
	  			불법 접근 등 위험이 막히기 위해서는 반드시 등록해야 시스템에 접근할 수 있습니다.
	  			<br>
	  			우리 학교에 속하는 학생 및 교직원들만 접근하는 사이트입니다. 
	  			<br>
	  			<img src = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2465035512,3291108693&fm=26&gp=0.jpg" >
	  		<br>
			<br>
              등록 페이지 이동: <a href="login.jsp">Login Page</a> 	  			
	  		</c:if>
			<c:if test="${not empty childPage}">
				<jsp:include page="${childPage}" flush="true"></jsp:include>
			</c:if>
	
		</div>
	</div>
</body>
</html>
