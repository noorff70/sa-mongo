package com.sa.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.mongo.model.Lessons;
import com.sa.mongo.service.LessonService;


@RestController
public class VideoController {
	
	@Autowired
	private LessonService lessonService;
	
	
	@GetMapping("/video/getLessonByContentId")
	public Lessons getTopicDescription (@RequestParam("CONTENTID") long contentId) {

		Lessons lesson = lessonService.getLessonByContentId(contentId);
		
		return lesson;
		
	}
	
	/*@GetMapping("/video/getLessonByTitle")
	public Lessons getLessonByTitle (@RequestParam("TITLE") String title) {

		Lessons lesson = lessonService.findItemByLessonTilte(title);
		
		return lesson;
		
	}*/


}
