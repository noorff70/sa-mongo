package com.sa.mongo.dao;

import com.sa.mongo.model.Student;
import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.model.WebCourse;


public interface WebCourseDAO {

	WebCourse getWebCourseList(String desc);
	public APIResponseObject addStudentToScheduledCourse(int subjectId, int webScheduleId, int webCourseId, Student student) ;
	public void addWebCourse (WebCourse course);
	
}
