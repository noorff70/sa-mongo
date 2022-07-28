package com.sa.mongo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "webcourse")
public class WebCourse {

	@Field
	private long subjectId;
	private String name;
	private List <AvailableCourse> availableCourses ;
}


@Getter
@Setter
@Document
class AvailableCourse {
	
	private long courseId;
	private String courseIntroduction;
	private String courseTitle;
	private String duration;
	private List<String> tags;
}