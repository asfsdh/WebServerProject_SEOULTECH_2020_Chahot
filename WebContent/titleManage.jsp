<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 使用c:标签需要添加本行代码 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>titleManage.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="content_top">평가 관리</div>
	<div id="content_mid">
		<table class="table_theme1">
			<thead>
			    <tr>
					<th>강좌번호</th>
					<th>출제유형</th>
					<th>교과목명</th>
					<th>조작</th> 
				</tr>
			</thead>
			<c:forEach items="${titles}" var="item">
				<tr>
					<td>${item.titleId}</td>
					<td>${item.titleContent}</td>
					<td>${item.titleCourseName}</td>
					<td><a
						href="/SchoolManagementSystem/RouteServlet?childPage=titleEdit.jsp&titleId=${item.titleId}">신청</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="content_bottom">
		<a href="/SchoolManagementSystem/RouteServlet?childPage=titleAdd.jsp">시험/과제/프로젝트 출제</a>
	</div>
</body>
</html>
