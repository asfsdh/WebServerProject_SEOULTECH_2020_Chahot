package org.utils;
import java.util.HashMap;

public class Constants {
	public static HashMap<String, String[][]> roleMenuMap = new HashMap<String, String[][]>();
	static { // 使用static代码块对roleMenuMap进行初始化
		// 注意，二位数组中的每一组表示一个菜单的信息，又通过map建立了角色名和菜单直接的对应关系
		roleMenuMap.put("student", new String[][] { { "页面1", "page1.jsp" }, { "页面2", "page2.jsp" }, { "不存在页面", "xxxx.jsp" }});
	}
}
