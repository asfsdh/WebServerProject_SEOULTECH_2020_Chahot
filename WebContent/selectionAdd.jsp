<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 使用c:标签需要添加本行代码 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>selecAdd.jsp</title>
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<form action="/SchoolManagementSystem/SelectionServlet?method=selecAdd"
		method="post">
		<div id="content_top">수강 신청</div>
		<div id="content_mid">
			<table class="table_theme1">
				<tr>
					<td>강좌번호 입력:</td>
					<td><input type="text" name="selection_course"/></td>
				</tr>
			</table>
		</div>
		<div id="content_bottom">
			<input type="submit" value="확인"></input>
		</div>
	</form>
</body>
</html>