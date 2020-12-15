<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>userAdd.jsp</title>
</head>
<body>
	<form action="/SchoolManagementSystem/UserServlet?method=userAdd" method="post">
		<table>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="text" name="userPassword" /></td>
			</tr>
			<tr>
				<td>신분:</td>
				<td><select name="userRole">
						<option value="교수">교수</option>
						<option value="학생">학생</option>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="저장"></input>
	</form>
</body>
</html>

