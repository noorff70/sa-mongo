package com.sa.mongo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "webAvailableCourse")
	
public class WebAvailableCourse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long courseId;
	private String courseIntroduction;
	private String courseName;
	private String courseObjective;
	private String duration;
	private boolean available;
	private String courseInstruction;
	//private String courseType; // Free=1, Paid=2
	private int courseSize;
	private int courseFee;
	private List<String> tags;
	private List<WebCourseSchedule> webCourseSchedule;
	private String tutorId;
}
