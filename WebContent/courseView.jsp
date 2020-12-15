<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>courseView.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="content_top">수업 조회</div>
	<div id="content_mid">
		    <table class="table_theme1">
			<thead>
				<tr>
					<th>강좌번호</th>
					<th>교과목명</th>
					<th>담당교수</th>
				</tr>
			</thead>
			<c:forEach items="${courses}" var="item">
				<tr>
					<td>${item.courseId}</td>
					<td>${item.courseName}</td>
					<td>${item.courseUserName}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>
