<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jobCheckEdit.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<form action="/SchoolManagementSystem/JobServlet?method=jobCheckEdit" method="post">
		<div id="content_top">시험 평가</div>
		<div id="content_mid">
			<table class="table_theme1">
        <tr>
					<td>시험 코드:</td>
					<td><input type="text" name="jobId" value="${job.jobId}"
						readonly /></td>
				</tr>
				<tr>
					<td>학생:</td>
					<td><input type="text" name="jobUserName"
						value="${job.jobUserName}" readonly /> <input type="hidden"
						name="jobTitle" value="${job.jobTitle}" /> <input type="hidden"
						name="jobUser" value="${job.jobUser}" /></td>
				</tr>
				<tr>
					<td>제출한 내용:</td>
					<td><textarea name="jobContent" value="${job.jobContent}" rows="3" cols="30" readonly></textarea></td>
				</tr>
				<tr>
					<td>점수:</td>
					<td><input type="text" name="jobScore" value="${job.jobScore}" /></td>
				</tr>
			</table>
		</div>
		<div id="content_bottom">
			<input type="submit" value="저장"></input>
		</div>
	</form>
</body>
</html>

