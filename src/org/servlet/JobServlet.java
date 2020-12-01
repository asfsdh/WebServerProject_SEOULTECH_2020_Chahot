package org.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.JobDao;
import org.dao.TitleDao;
import org.model.Job;
import org.model.User;
import org.utils.TimeUtils;

@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// ´¦ÀípostÇëÇó
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		
		JobDao jobDao = new JobDao();
		if (method.equals("jobCheckEdit")) {
			Job job = new Job();
			job.setJobId(Integer.parseInt(request.getParameter("jobId")));
			job.setJobContent(request.getParameter("jobContent"));
			job.setJobScore(request.getParameter("jobScore"));
			job.setJobTime(TimeUtils.getNowSqlTime());
			job.setJobTitle(Integer.parseInt(request.getParameter("jobTitle")));
			job.setJobUser(Integer.parseInt(request.getParameter("jobUser")));
			
			jobDao.update(job);
			
			TitleDao titleDao = new TitleDao();
			request.setAttribute("titles", titleDao.getTitlesByUserId(loginUser.getUserId()));
			String selectedTitle = request.getParameter("selectedTitle");
			List<Job> jobs = null;
			if (selectedTitle != null && !"".equals(selectedTitle)) { 
				jobs = jobDao.getJobsByTitleId(Integer.parseInt(selectedTitle));
			} else {
				jobs = new ArrayList<Job>();
			}
			request.setAttribute("jobs", jobs);
			
			request.setAttribute("childPage", "jobCheck.jsp");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
