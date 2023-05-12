package com.sa.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.mongo.model.Course;
import com.sa.mongo.model.Lessons;
import com.sa.mongo.model.RequestObject;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.UserAccessReturnObject;
import com.sa.mongo.model.UserCourse;
import com.sa.mongo.service.CourseService;



@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/mongo/getLessonByContentId")
	public Lessons getTopicDescription (@RequestParam("CONTENTID") long contentId) {

		Lessons lesson = courseService.getLessonByContentId(contentId);
		
		return lesson;
		
	}

	
	/*
	 * get all courses by courseDesc in input box 
	 */
	
	@PostMapping("/mongo/getCourseListByCourseDesc")
	public List<Course> getCourseListByCourseDesc (@RequestBody RequestObject req) {
		
		String description = req.getCourseDescription();

		List<Course> contentList = courseService.getCourseListByCourseDesc(description);
		
		return contentList;
	}
	
	/*
	 * Add course to user/ enroll a course
	 */
	@PostMapping("/mongo/addCourseToUser")
	public UserAccessReturnObject addCourseToUser(@RequestBody UserCourse content) {
		
		Long courseId = content.getCourseId();
		String userName = content.getUserName();
		
		UserAccessReturnObject returnObject = courseService.addCourseToUser(courseId, userName);
	
		return returnObject;
		
	}
	
	/*@PostMapping("/mongo/getCourseContentsByStudentId")
	public List<Course> getCourseContentsWithStudentId (@RequestBody Student student) {
		
		List <Course> contentList = contentService.getContentsByStudentId(student.getUserId());
		return contentList;
	}
	*/
	

	
}
