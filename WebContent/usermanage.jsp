<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>userManage.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <div id="content_top">인원 관리</div>
	<div id="content_mid">
	<table class="table_theme1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>신분</th>
				<th>조작1</th>
				<th>조작2</th>
			</tr>
		</thead>
		<c:forEach items="${users}" var="item">
			<tr>
				<td>${item.userId}</td>
				<td>${item.userName}</td>
				<td>${item.userRole}</td>
				<td>
				<a href="/SchoolManagementSystem/RouteServlet?childPage=userEdit.jsp&userId=${item.userId}">편집</a>
				</td>
				<td>
				<a href="/SchoolManagementSystem/UserServlet?method=userDelete&userId=${item.userId}">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div id="content_bottom">	
	<a href="/SchoolManagementSystem/RouteServlet?childPage=userAdd.jsp">교수 위임/학생 입학 허가</a>
	</div>
</body>
</html>