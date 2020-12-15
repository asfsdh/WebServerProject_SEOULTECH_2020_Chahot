package org.utils;
import java.util.HashMap;

public class Constants {
	public static HashMap<String, String[][]> roleMenuMap = new HashMap<String, String[][]>();
	static { 
		// 윈 쪽, 오른 쪽 대응하는 신분 및 페이지 관계가 여기서
		roleMenuMap.put("학생", new String[][] { { "수강신청", "selection.jsp" }, { "과제 조회", "jobView.jsp" }});
		roleMenuMap.put("교장", new String[][] { { "인원 관리", "usermanage.jsp" }, { "수업 조회", "courseView.jsp" } });
		roleMenuMap.put("교수", new String[][] { { "수업 개설", "courseManage.jsp" },{ "시험 출제", "titleManage.jsp" },{ "시험 평가", "jobCheck.jsp" }  });
		roleMenuMap.put("명예교수", new String[][] { { "시험 평가", "jobCheck.jsp" }  });
		roleMenuMap.put("학과장", new String[][] { { "수업 개설", "courseManage.jsp" },{ "시험 출제", "titleManage.jsp" },{ "시험 평가", "jobCheck.jsp" }  });
		roleMenuMap.put("부교장", new String[][] { { "수업 조회", "courseView.jsp" } });
	}
}
