package org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.UserDao;
import org.model.User;
import org.service.LoginService;
import org.utils.Constants;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// ´¦ÀípostÇëÇó
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		// 用户操作数据库
		UserDao userDao = new UserDao();
		if (method.equals("userAdd")) {
			// 获取用户在网页输入的用户名和密码
			User user = new User();
			user.setUserName(request.getParameter("userName"));
			user.setUserPassword(request.getParameter("userPassword"));
			user.setUserRole(request.getParameter("userRole"));
			
			userDao.add(user);
		} else if (method.equals("userEdit")) {
			// 获取用户在网页输入的用户名和密码
			User user = new User();
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			user.setUserName(request.getParameter("userName"));
			user.setUserPassword(request.getParameter("userPassword"));
			user.setUserRole(request.getParameter("userRole"));
			// 保存到数据库
			userDao.update(user);
		} else if (method.equals("userDelete")) {
			userDao.deleteById(Integer.parseInt(request.getParameter("userId")));
		} 
		// 携带最新用户数据到人员管理页面
		request.setAttribute("users", userDao.getUsers());
		// 跳转到管理后台页面，且子页面是用户管理
		request.setAttribute("childPage", "userManage.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
