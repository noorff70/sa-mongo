package com.sa.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableDiscoveryClient
//@EnableCaching
public class MongoApplication {

	static Logger logger = LoggerFactory.getLogger(MongoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(MongoApplication.class, args);
	}

}

