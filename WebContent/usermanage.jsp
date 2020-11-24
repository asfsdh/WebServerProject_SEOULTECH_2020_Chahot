<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 使用c:标签需要添加本行代码 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>userManage.jsp</title>
</head>
<body>
	<table>
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
	<a href="/SchoolManagementSystem/RouteServlet?childPage=userAdd.jsp">교수 위임/학생 입학 허가</a>
	
</body>
</html>
