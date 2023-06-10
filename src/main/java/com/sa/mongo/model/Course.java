package com.sa.mongo.model;


import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "course")
public class Course {
	
	@Field
	private long courseId;
	@TextIndexed
	private String courseName;
	private String courseDesc;
	private String tutorName;
	//private String courseType;

}
