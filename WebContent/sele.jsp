<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- 使用c:标签需要添加本行代码 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>courseManageByStudent.jsp</title>
    <link href="css/content.css" type="text/css" rel="stylesheet" />
  </head>
  <body>
    <div id="content_top">
        수강신청
    </div><!-- user_top end -->
    <div id="content_mid">
        <table class="table_theme1">
            <thead>
            <tr>
                <th>강좌번호</th>
                <th>교과목명</th>
                <th>담당교수</th>
                <th>수강신청</th>
            </tr>
            </thead>
            <c:forEach items="${courses}" var="item">
                <tr>
                    <td>${item.courseId}</td>
                    <td>${item.courseName}</td>
                    <td>${item.courseUser.userName}</td>
                    <td><a href="/SchoolManagementSystem/ActionServlet?method=save&entityType=Lesson&courseId=${item.courseId}">选课</a></td>
                </tr>
            </c:forEach>    
        </table>
    </div><!-- user_mid end -->
    <div id="content_bottom">

    </div><!-- "user_bottom" end -->
  </body>
</html>

作者：慕课熊猫
链接：https://www.imooc.com/article/16513
来源：慕课网
本文原创发布于慕课网 ，转载请注明出处，谢谢合作