package com.sa.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.model.RequestObject;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.WebCourse;
import com.sa.mongo.service.WebCourseService;

@RestController
public class WebCourseController {
	
	@Autowired
	private WebCourseService webCourseService;
	
	/*
	 * Instructor led courselist. List from drop down
	 */
//	@Cacheable("cacheWebCourse")
	@PostMapping("/mongo/getWebCourseList")
	public WebCourse getWebCourseList (@RequestBody RequestObject obj) {
		String WEBCOURSEDESC = obj.getWebCourseSearchCriteria();
		WebCourse webCourseList = webCourseService.getWebCourseList(WEBCOURSEDESC);
		return webCourseList;
	}
	
	@PostMapping("/mongo/addStudentToScheduledCourse")
	public APIResponseObject addStudentToOfferedCourse (@RequestBody RequestObject obj) {
		
		APIResponseObject apiResponse = new APIResponseObject();
		
		int webScheduleId = obj.getWebCourseScheduleId();
		int webCourseId = obj.getWebAvailableCourseId();
		Student student = obj.getWebAddStudent();
		int subjectId = obj.getWebSubjectId();
		
		apiResponse = webCourseService.addStudentToScheduledCourse(subjectId, webScheduleId, webCourseId, student); 
		
		return apiResponse;
		
	}
	
	@PostMapping("/mongo/addWebCourse")
	public void addWebCourse(@RequestBody WebCourse course){
		webCourseService.addWebCourse(course);
	}

}
