package org.model;


public class Title {
	private int titleId;
	private String titleContent;
	private int titleCourse;
	private String titleTime;

	private String titleCourseName;

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitleContent() {
		return titleContent;
	}

	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}

	public int getTitleCourse() {
		return titleCourse;
	}

	public void setTitleCourse(int titleCourse) {
		this.titleCourse = titleCourse;
	}

	public String getTitleTime() {
		return titleTime;
	}

	public void setTitleTime(String titleTime) {
		this.titleTime = titleTime;
	}

	public String getTitleCourseName() {
		return titleCourseName;
	}

	public void setTitleCourseName(String titleCourseName) {
		this.titleCourseName = titleCourseName;
	}

}