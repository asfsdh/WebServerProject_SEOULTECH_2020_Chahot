package org.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

	// 连接所需的固定参数
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/sms?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String password = "Chahot";

	// 初始化的时候加载去的弄
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * 获取连接
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * 释放连接
	 */
	public static void releaseConnection(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}
}