package org.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.dao.*;
import org.model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RouteServlet")
public class RouteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String childPage = request.getParameter("childPage");
		request.setAttribute("childPage", childPage);
		if (childPage.equals("usermanage.jsp")) { 
			UserDao userDao = new UserDao();
			List<User> users = userDao.getUsers();
			request.setAttribute("users", users);
		}else if (childPage.equals("userEdit.jsp")) {
			UserDao userDao = new UserDao();
			String userId = request.getParameter("userId");
			User user = userDao.getById(userId);
			request.setAttribute("user", user);
		}else if (childPage.equals("courseView.jsp")) {
			CourseDao courseDao=new CourseDao();
			request.setAttribute("courses", courseDao.getCourses());
		}else if (childPage.equals("courseManage.jsp")) {
			
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			if (loginUser != null) {
				CourseDao courseDao = new CourseDao();
				
				request.setAttribute("courses", courseDao.getCoursesByUserId(loginUser.getUserId()));
			}
		}else if (childPage.equals("courseEdit.jsp")) {
			CourseDao courseDao = new CourseDao();
			String courseId = request.getParameter("courseId");
			Course course = courseDao.getById(courseId);
			request.setAttribute("course", course);
		}else if (childPage.equals("titleManage.jsp")) {
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			if (loginUser != null) {
				TitleDao titleDao = new TitleDao();
				
				request.setAttribute("titles", titleDao.getTitlesByUserId(loginUser.getUserId()));
			}
		}else if (childPage.equals("titleAdd.jsp")) {
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			CourseDao courseDao = new CourseDao();
			request.setAttribute("courses", courseDao.getCoursesByUserId(loginUser.getUserId()));
		}else if (childPage.equals("titleEdit.jsp")) {
			TitleDao titleDao = new TitleDao();
			String titleId = request.getParameter("titleId");
			Title title = titleDao.getById(titleId);
			request.setAttribute("title", title);
		}else if (childPage.equals("jobCheck.jsp")) {
			
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			TitleDao titleDao = new TitleDao();
			request.setAttribute("titles", titleDao.getTitlesByUserId(loginUser.getUserId()));
			String selectedTitle = request.getParameter("selectedTitle");
			JobDao jobDao = new JobDao();
			List<Job> jobs = null;
			if (selectedTitle != null && !"".equals(selectedTitle)) { 
				jobs = jobDao.getJobsByTitleId(Integer.parseInt(selectedTitle));
			} else {
				jobs = new ArrayList<Job>();
			}
			request.setAttribute("jobs", jobs);
		}else if (childPage.equals("jobCheckEdit.jsp")) {
			JobDao jobDao = new JobDao();
			String jobId = request.getParameter("jobId");
			Job job = jobDao.getById(Integer.parseInt(jobId));
			request.setAttribute("job", job);
		}if (childPage.equals("selection.jsp")) { 
			CourseDao courseDao=new CourseDao();
			request.setAttribute("courses", courseDao.getCourses());
		}else if (childPage.equals("jobView.jsp")) {
			
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			
			TitleDao titleDao = new TitleDao();
			request.setAttribute("titles", titleDao.getTitlesByUserId(1));
			
			String selectedTitle = request.getParameter("selectedTitle");
			JobDao jobDao = new JobDao();
			List<Job> jobs = null;
			if (selectedTitle != null && !"".equals(selectedTitle)) { 
				jobs = jobDao.getJobsByTitleId(Integer.parseInt(selectedTitle));
			} else {
				jobs = new ArrayList<Job>();
			}
			request.setAttribute("jobs", jobs);
		}else if (childPage.equals("jobSubmit.jsp")) {
			JobDao jobDao = new JobDao();
			String jobId = request.getParameter("jobId");
			Job job = jobDao.getById(Integer.parseInt(jobId));
			request.setAttribute("job", job);
		}

	request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}

