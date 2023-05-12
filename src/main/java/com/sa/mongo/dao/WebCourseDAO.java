package com.sa.mongo.dao;

import com.sa.mongo.model.WebAvailableCourse;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.WebCourse;


public interface WebCourseDAO {

	WebCourse findByWebCourseName(String desc);
	public String addStudentToScheduledCourse(int subjectId, int webScheduleId, int webCourseId, Student student) ;
	public void addWebCourse (WebCourse course);
	
}
