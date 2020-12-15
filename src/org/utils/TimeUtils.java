package org.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
	public static String getNowSqlTime() {
		//과제 제출할 때 현재의 시각 기록
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime now = LocalDateTime.now();
		return now.format(formatter);
	}
}
