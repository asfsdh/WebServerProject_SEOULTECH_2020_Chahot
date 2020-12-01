package org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.CourseDao;
import org.model.Course;
import org.model.User;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// ´¦ÀípostÇëÇó
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		
		CourseDao courseDao = new CourseDao();
		if (method.equals("courseAdd")) {
			Course course = new Course();
			course.setCourseName(request.getParameter("courseName"));
			course.setCourseUser(loginUser.getUserId());
			courseDao.add(course);
		} else if (method.equals("courseEdit")) {
			Course course = new Course();
			course.setCourseId(Integer.parseInt(request.getParameter("courseId")));
			course.setCourseUser(loginUser.getUserId());
			course.setCourseName(request.getParameter("courseName"));
			
			courseDao.update(course);
		}
		
		request.setAttribute("courses", courseDao.getCoursesByUserId(loginUser.getUserId()));
		
		request.setAttribute("childPage", "courseManage.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}