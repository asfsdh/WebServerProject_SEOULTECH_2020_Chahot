<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>login.jsp</title>
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
			<li>
				<a href="index.jsp">뒤로 가기</a>
			</li>
			</ul>
		</div>
		<!-- right 부분: 구체적인 내용 제시 -->
		<div id="right">
		<form id="mainForm" method="post" action="/SchoolManagementSystem/LoginServlet">
  		성호입력:<input type="text" name="userName" />
  		<br/>
  		비밀번호:<input type="password" name="userPassword"/>	
  		<br/>
  		<input type="submit" value="로그인"/>
  	</form>
		</div>
	</div>
  </body>
</html>
