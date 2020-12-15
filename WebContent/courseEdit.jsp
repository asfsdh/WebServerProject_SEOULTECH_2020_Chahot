<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>courseEdit.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<form action="/SchoolManagementSystem/CourseServlet?method=courseEdit"
		method="post">
		<div id="content_top">수업 편집</div>
		<div id="content_mid">
			<table class="table_theme1">
				<tr>
					<td>강좌번호:</td>
					<td><input type="text" name="courseId"
						value="${course.courseId}" readonly /></td>
				</tr>
				<tr>
					<td>교과목명:</td>
					<td><input type="text" name="courseName"
						value="${course.courseName}" /></td>
				</tr>
			</table>
		</div>
		<div id="content_bottom">
			<input type="submit" value="저장"></input>
		</div>
	</form>
</body>
</html>
