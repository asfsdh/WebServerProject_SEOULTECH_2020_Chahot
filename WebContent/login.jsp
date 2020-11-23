<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>login.jsp</title>
  </head>
  <body>
  	<form id="mainForm" method="post" action="/SchoolManagementSystem/LoginServlet">
  		아이디:<input type="text" name="userName" />
  		<br/>
  		비밀번호:<input type="password" name="userPassword"/>	
  		<br/>
  		<input type="submit" value="로그인"/>
  	</form>
  </body>
</html>
