<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
<link href="css/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="main">
		<div id="top">
			<!-- title -->
			<div id="top_title">☯서울과학기술대학교 모의 관리 시스템☯</div>
			<!-- 등록 후 전달하는 유저의 이름 -->
			<div id="top_info">${loginUser.userName}님 환영합니다.</div>
		</div>
		<!-- left 부분: 메뉴의 항목을 클릭한후 대응하는 페이지 내용을 right로 전달 -->
        <div id="left">
			<ul>
			<li>
				<a href="index.jsp">뒤로 가기</a>
			</li>
			</ul>
		</div>
		<!-- right 부분: 구체적인 내용 제시 -->
		<div id="right">
	    <!-- 如果tipInfo为空 -->
	    <c:if test="${empty tipInfo}">
	  	서울과학기술대학교 모의 관리 시스템 에러 피이지입니다
	    </c:if>
	    <!-- 如果tipInfo不为空，显示 tipInfo -->
	    <c:if test="${not empty tipInfo}">
		에러 정보：${tipInfo}<br/>
	    </c:if>
		</div>
	</div>
</body>
</html>