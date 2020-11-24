<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 使用c:标签需要添加本行代码 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>userEdit.jsp</title>
</head>
<body>
	<form action="/SchoolManagementSystem/UserServlet?method=userEdit"
		method="post">
		<table>
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="userId" value="${user.userId}"
					readonly /></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="userName" value="${user.userName}" />
				</td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="text" name="userPassword"
					value="${user.userPassword}" /></td>
			</tr>
			<tr>
				<td>신분:</td>
				<td><select name="userRole" value="${user.userRole}">
						<option value="부교장">부교장</option>
						<option value="교수">교수</option>
						<option value="학생">학생</option>
						<option value="학과장">학과장</option>
						<option value="교수">학생</option>
						<option value="명예교수">명예교수</option>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="저장"></input>
	</form>
</body>
</html>
