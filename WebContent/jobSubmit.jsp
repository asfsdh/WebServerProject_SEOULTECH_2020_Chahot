<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 使用c:标签需要添加本行代码 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Submit.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<form action="/SchoolManagementSystem/JobServlet?method=jobSubmit" method="post">
		<div id="content_top">과제 작성</div>
		<div id="content_mid">
			<table class="table_theme1">
        <tr>
					<td>시험 코드:</td>
					<td><input type="text" name="jobId" value="${job.jobId}"
						readonly /></td>
				</tr>
		
				<tr>
					<td>내용 작성:</td>
					<td><textarea name="jobContent" value="${job.jobContent}" rows="3" cols="30"></textarea></td>
				</tr>
			</table>
		</div>
		<div id="content_bottom">
			<input type="submit" value="저장"></input>
		</div>
	</form>
</body>
</html>


