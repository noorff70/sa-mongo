package com.sa.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class MongoConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoConnectionApplication.class, args);
	}

}
