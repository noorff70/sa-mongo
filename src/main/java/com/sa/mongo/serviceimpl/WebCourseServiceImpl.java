package com.sa.mongo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.mongo.dao.WebCourseDAO;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.model.WebCourse;
import com.sa.mongo.service.WebCourseService;


@Service("webCourseService")
public class WebCourseServiceImpl implements WebCourseService{
	
	@Autowired
	private WebCourseDAO webCourseDAO;
	
	@Override
	public WebCourse getWebCourseList(String desc) {
		return webCourseDAO.findByWebCourseName(desc);
	}
	
	public APIResponseObject addStudentToScheduledCourse(int subjectId, int webScheduleId, int webCourseId, Student student) {
		return webCourseDAO.addStudentToScheduledCourse(subjectId, webScheduleId, webCourseId, student);
	}
	
	public void addWebCourse (WebCourse course) {
		webCourseDAO.addWebCourse(course);
	}

}
