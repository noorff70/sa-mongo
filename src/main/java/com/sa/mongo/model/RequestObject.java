package com.sa.mongo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestObject {
	
	private String webCourseSearchCriteria; // from web course table
	private String courseDescription; // from course table
	
	//WebAvailableCourse- To add a new User to a date offered
	private int webCourseScheduleId;
	private Student webAddStudent;
	private int webSubjectId;
	private int webAvailableCourseId;
	
	private String tutorId;

}
