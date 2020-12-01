<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 使用c:标签需要添加本行代码 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jobCheck.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="content_top">수업 평가</div>
	<div id="content_mid">
		<form method="get" action="/SchoolManagementSystem/RouteServlet">
			<input type="hidden" name="childPage" value="jobCheck.jsp"> <select
				name="selectedTitle">
				<c:forEach items="${titles}" var="item">
					<option value="${item.titleId}">${item.titleContent}</option>
				</c:forEach>
			</select> <input type="submit" value="조회" />
		</form>
		<table class="table_theme1">
			<thead>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>제출 시간</th>
					<th>내용</th>
					<th>점수</th>
					<th>평가</th>
				</tr>
			</thead>
			<c:forEach items="${jobs}" var="item">
				<tr>
					<td>${item.jobId}</td>
					<td>${item.jobUserName}</td>
					<td>${item.jobTime}</td>
					<td>${item.jobContent}</td>
					<td>${item.jobScore}</td>
					<td><a
						href="/SchoolManagementSystem/RouteServlet?childPage=jobCheckEdit.jsp&jobId=${item.jobId}">평가</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
