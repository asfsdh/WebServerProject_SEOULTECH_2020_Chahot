package org.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import org.dao.JobDao;
import org.dao.SelectionDao;
import org.dao.TitleDao;
import org.model.Job;
import org.model.Selection;
import org.model.Title;
import org.model.User;
import org.utils.TimeUtils;

@WebServlet("/TitleServlet")
public class TitleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// 处理post请求
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		// DB 조작
		TitleDao titleDao = new TitleDao();
		SelectionDao selectionDao = new SelectionDao();
		JobDao jobDao = new JobDao();
		if (method.equals("titleAdd")) {
			
			Title title = new Title();
			title.setTitleContent(request.getParameter("titleContent"));
			title.setTitleCourse(Integer.parseInt(request.getParameter("titleCourse")));
			title.setTitleTime(TimeUtils.getNowSqlTime());
			int newId = titleDao.add(title);
			// id로 유저 조회
			List<Selection> selections = selectionDao.getSelectionsByCourseId(title.getTitleCourse());
			// 과제 추가 기능 실현
			for (Selection selection : selections) {
				Job job = new Job();
				job.setJobTitle(newId);
				job.setJobUser(selection.getSelectionUser());
                job.setJobTime(TimeUtils.getNowSqlTime());
				jobDao.add(job);
			}
		}else if (method.equals("titleEdit")) {
			Title title = new Title();
			title.setTitleId(Integer.parseInt(request.getParameter("titleId")));
			title.setTitleContent(request.getParameter("titleContent"));
			title.setTitleCourse(Integer.parseInt(request.getParameter("titleCourse")));
			title.setTitleTime(request.getParameter("titleTime"));
			
			titleDao.update(title);
		}
		//조작된 정보 반환
		request.setAttribute("titles", titleDao.getTitlesByUserId(loginUser.getUserId()));
		//조작 완성한 후에 전달할 페이지
		request.setAttribute("childPage", "titleManage.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}


