package com.sa.mongo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "webcourse")
public class WebCourse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private long subjectId;
	private String webCourseName;
	private List <WebAvailableCourse> availableCourses ;
}
