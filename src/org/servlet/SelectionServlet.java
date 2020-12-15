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
import org.dao.SelectionDao;
import org.dao.TitleDao;
import org.model.Job;
import org.model.Selection;
import org.model.User;
import org.utils.TimeUtils;

/**
 * Servlet implementation class SelectionServlet
 */
@WebServlet("/SelectionServlet")
public class SelectionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// ´¦ÀípostÇëÇó
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		
		SelectionDao SelectionDao = new SelectionDao();
		if (method.equals("selecAdd")) {
		Selection selection=new Selection();
		
		selection.setSelectionUser(loginUser.getUserId());
		selection.setSelectionCourse(Integer.parseInt(request.getParameter("selection_course")));
		
		SelectionDao.add(selection);
		}

		
		request.setAttribute("selections", SelectionDao.getSelectionsByCourseId(loginUser.getUserId()));
		
		request.setAttribute("childPage", "sele.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
