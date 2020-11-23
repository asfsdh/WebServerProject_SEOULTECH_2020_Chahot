package org.service;
import java.util.List;
import org.model.User;

public class LoginService {
	public User checkLogin(String userName, String userPassword) throws Exception {
		if (userName.equals("") || userPassword.equals("")) {
			// 抛出输入信息异常
			throw new Exception("用户名和密码不能为空");
		}
		User user = null;
		try {
			// 从数据库中执行查询，此处暂时用一个固定对象代替
			user = new User();
			user.setUserId(1);
			user.setUserName("test");
			user.setUserPassword("1234");
			user.setUserRole("student");// 学生
		} catch (Exception e) {
			// 抛出数据库异常
			throw new Exception("数据库操作异常:" + e.getMessage());
		}
		return user;// 返回查询结果
	}

}
