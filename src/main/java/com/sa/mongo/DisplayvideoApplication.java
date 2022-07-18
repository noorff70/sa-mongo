package com.sa.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class DisplayvideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayvideoApplication.class, args);
	}

}
