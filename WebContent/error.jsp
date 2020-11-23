<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
    <!-- 如果tipInfo为空 -->
	<c:if test="${empty tipInfo}">
	  	☯서울과학기술대학교 모의 관리 시스템☯
	</c:if>
	<!-- 如果tipInfo不为空，显示 tipInfo -->
	<c:if test="${not empty tipInfo}">
		에러 정보：${tipInfo}<br />
	</c:if>
</body>
</html>