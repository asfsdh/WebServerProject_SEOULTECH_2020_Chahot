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
		// 设置输入输出格式、编码
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取method参数
		String method = request.getParameter("method");
		// 获取登录用户信息
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		// 操作数据库
		TitleDao titleDao = new TitleDao();
		SelectionDao selectionDao = new SelectionDao();
		JobDao jobDao = new JobDao();
		if (method.equals("titleAdd")) {
			// 新增作业题目
			Title title = new Title();
			title.setTitleContent(request.getParameter("titleContent"));
			title.setTitleCourse(Integer.parseInt(request.getParameter("titleCourse")));
			title.setTitleTime(TimeUtils.getNowSqlTime());
			int newId = titleDao.add(title);
			// 查询选择该门课的用户id
			List<Selection> selections = selectionDao.getSelectionsByCourseId(title.getTitleCourse());
			// 为每个选择该课的学生新增作业内容记录
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
		// 携带最新用户数据到人员管理页面
		request.setAttribute("titles", titleDao.getTitlesByUserId(loginUser.getUserId()));
		// 跳转到管理后台页
		request.setAttribute("childPage", "titleManage.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}


