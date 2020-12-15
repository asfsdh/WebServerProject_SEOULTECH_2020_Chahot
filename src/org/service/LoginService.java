package org.service;
import org.dao.UserDao;
import java.util.List;
import org.model.User;

public class LoginService {
	public User checkLogin(String userName, String userPassword) throws Exception {
		if (userName.equals("") || userPassword.equals("")) {
			// 에러 처리
			throw new Exception("비밀번호나 성호는 비어 있습니다.");
		}
		User user = null;
		try {
			UserDao userDao = new UserDao();
			List<User> list = userDao.getUser(userName, userPassword);
			if (list.size() == 1) {// 데이터베이스에 있는 유저만 성공처리
				user = list.get(0);
			}
		} catch (Exception e) {
			// 에러 정보를 반환
			throw new Exception("데이터베이스 조작 에러 발생:" + e.getMessage());
		}
		return user;
	}

}
