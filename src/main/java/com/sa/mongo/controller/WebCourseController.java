package com.sa.mongo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	static Logger logger = LoggerFactory.getLogger(WebCourseController.class);
	
	/*
	 * Instructor led courselist. List from drop down
	 */
	
	@GetMapping("/mongo/helloWorldTest")
	public String helloWorldTest () {

		logger.info("WebCourse.getWebCourseList():: Hello World Test");
		
		return "Hello World";
	}
	
//	@Cacheable("cacheWebCourse")
	@PostMapping("/mongo/getWebCourseList")
	public WebCourse getWebCourseList (@RequestBody RequestObject obj) {
		String WEBCOURSEDESC = obj.getWebCourseSearchCriteria();
		logger.info("WebCourse.getWebCourseList():: Requested for " + WEBCOURSEDESC);
		WebCourse webCourseList = webCourseService.getWebCourseList(WEBCOURSEDESC);
		return webCourseList;
	}
	
	@PostMapping("/mongo/addStudentToScheduledCourse")
	public APIResponseObject addStudentToScheduledCourse (@RequestBody RequestObject obj) {
		
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
