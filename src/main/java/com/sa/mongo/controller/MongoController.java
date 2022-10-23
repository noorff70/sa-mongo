package com.sa.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.mongo.model.Lessons;
import com.sa.mongo.service.MongoService;
import com.sa.mongo.model.WebCourse;


@RestController
public class MongoController {
	
	@Autowired
	private MongoService mongoService;
	
	
	@GetMapping("/mongo/getLessonByContentId")
	public Lessons getTopicDescription (@RequestParam("CONTENTID") long contentId) {

		Lessons lesson = mongoService.getLessonByContentId(contentId);
		
		return lesson;
		
	}
	
	@GetMapping("/mongo/getWebCourseList")
	public WebCourse getWebCourseList (@RequestParam("WEBCOURSEDESC") String desc) {
		
		WebCourse webCourseList = mongoService.getWebCourseList(desc);
		
		return webCourseList;
	}


}
