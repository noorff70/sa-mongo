package com.sa.mongo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "lesson")
public class Lessons {
	
	//@Id
	//private long _id;
	@Field
	private long lessonId;
	private String lessonTitle;
	private String lessonAuthor;
	private List<LessionMission> lessonMission;
	private List<LessonContent> lessonContent;	
}

@Getter
@Setter
@Document
class LessionMission {
	private int id;
	private String description;
}


@Getter
@Setter
@Document
class LessonContent {
	
	private String lessonTitle;
	private List<LessonSubTitle> subTitle;
}


@Getter
@Setter
@Document
class LessonSubTitle {
	
	private String name;
	private String lessonLink;
	private String lessonType;
}
