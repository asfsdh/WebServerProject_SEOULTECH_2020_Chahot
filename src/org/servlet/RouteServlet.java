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
		// 设置输入输出格式、编码
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取用户在网页输入的用户名和密码
		String childPage = request.getParameter("childPage");
		request.setAttribute("childPage", childPage);
		if (childPage.equals("usermanage.jsp")) { // 进入人员管理页面需要携带人员列表信息
			UserDao userDao = new UserDao();
			List<User> users = userDao.getUsers();
			request.setAttribute("users", users);
		}else if (childPage.equals("userEdit.jsp")) {
			UserDao userDao = new UserDao();
			String userId = request.getParameter("userId");
			User user = userDao.getById(userId);
			request.setAttribute("user", user);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);// 跳转到index.jsp
	}
}
