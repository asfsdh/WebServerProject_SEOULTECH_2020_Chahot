package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.LoginService;
import org.model.User;
import org.utils.Constants;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		// dopost 메서드 사용하여 get요청을 처리
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// 处理post请求
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 브라우저의 정보를 전달용 
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");

		LoginService lc = new LoginService();
		User user = null;
		
		String tipInfo = "";// 에러 내용
		String page = "";// 에러 페이지
		try {
			user = lc.checkLogin(userName, userPassword);
			if (user == null) {
				//입력이 없는 경우에서 에러 메시지
				tipInfo = "사용자가 존재하지 않습니다.";
				page = "tip.jsp";
			}
			else
			{
				// 로그인 성공하면 
				request.getSession().setAttribute("loginUser", user);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				page="index.jsp";
				
				String[][] loginMenus = Constants.roleMenuMap.get(user.getUserRole());
				request.getSession().setAttribute("loginMenus", loginMenus);
			}
			// 신분에 따라 전달 페이지도 다르다
		} catch (Exception e) {
			//에러 미시지를 에러 페이지에 전달
			tipInfo = e.getMessage();
			page = "tip.jsp";
		}
		request.setAttribute("tipInfo", tipInfo);
		request.getRequestDispatcher("/" + page).forward(request, response);
	}
}
