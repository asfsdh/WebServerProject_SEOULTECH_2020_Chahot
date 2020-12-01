package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.SelectionDao;
import org.model.User;

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
		
		}
	}

}
