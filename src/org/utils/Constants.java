package org.utils;
import java.util.HashMap;

public class Constants {
	public static HashMap<String, String[][]> roleMenuMap = new HashMap<String, String[][]>();
	static { // 使用static代码块对roleMenuMap进行初始化
		// 注意，二位数组中的每一组表示一个菜单的信息，又通过map建立了角色名和菜单直接的对应关系
		roleMenuMap.put("학생", new String[][] { { "수강신청", "sele.jsp" }, { "页面2", "page2.jsp" }, { "不存在页面", "xxxx.jsp" }});
		// 校长拥有的菜单
		roleMenuMap.put("교장", new String[][] { { "인원 관리", "usermanage.jsp" }, { "수업 조회", "courseView.jsp" } });
		roleMenuMap.put("교수", new String[][] { { "수업 개설/폐기", "courseManage.jsp" },{ "시험 출제", "titleManage.jsp" },{ "시험 평가", "jobCheck.jsp" }  });
		roleMenuMap.put("명예교수", new String[][] { { "시험 평가", "jobCheck.jsp" }  });
		roleMenuMap.put("학과장", new String[][] { { "수업 개설/폐기", "courseManage.jsp" },{ "시험 출제", "titleManage.jsp" },{ "시험 평가", "jobCheck.jsp" }  });
		roleMenuMap.put("부교장", new String[][] { { "수업 조회", "courseView.jsp" } });
	}
}
