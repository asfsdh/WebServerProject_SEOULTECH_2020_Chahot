package org.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
	public static String getNowSqlTime() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime now = LocalDateTime.now();
		return now.format(formatter);
	}
}
