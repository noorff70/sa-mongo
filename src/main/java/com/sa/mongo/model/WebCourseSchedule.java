package com.sa.mongo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "webCourseSchedule")
public class WebCourseSchedule implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int webCourseOfferNumber;
	private String webCourseScheduleDate;
	private List<Student> webCourseStudentList;
		
}
