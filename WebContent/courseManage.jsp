<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>courseManage.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="content_top">수업관리</div>
	<div id="content_mid">
		<table class="table_theme1">
			<thead>
                <tr>
					<th>강좌번호</th>
					<th>교과목명</th>
					<th>담당교수</th>
					<th>조작</th> 
				</tr>
			</thead>
			<c:forEach items="${courses}" var="item">
				<tr>
					<td>${item.courseId}</td>
					<td>${item.courseName}</td>
					<td>${item.courseUserName}</td>
					<td><a
						href="/SchoolManagementSystem/RouteServlet?childPage=courseEdit.jsp&courseId=${item.courseId}">편집</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="content_bottom">
		<a href="/SchoolManagementSystem/RouteServlet?childPage=courseAdd.jsp">수업 개설</a>
	</div>
</body>
</html>
