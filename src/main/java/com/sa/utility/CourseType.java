package com.sa.utility;

public enum CourseType {
	
	Free("FREE"), PAID("PAID");
	
	private String courseType;
	
	CourseType(String type) {
		this.courseType = type;
	}
	
	public String getCourseType() {
		return this.courseType;
	}

}
