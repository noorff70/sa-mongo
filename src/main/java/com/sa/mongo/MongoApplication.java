package com.sa.mongo;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;



@SpringBootApplication
@EnableMongoRepositories
@EnableDiscoveryClient
@EnableCaching
public class MongoApplication {
	
	static Logger logger = LoggerFactory.getLogger(MongoApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(MongoApplication.class, args);
	}
	/*
	@Bean
	public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException {
		DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
		//System.setProperty("javax.net.ssl.keyStore", "src/main/resources/mongo.p12");
		System.setProperty("javax.net.ssl.keyStore", "/tmp/mongo.p12");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		//System.setProperty("javax.net.ssl.trustStore", "src/main/resources/mongo.p12");
		System.setProperty("javax.net.ssl.trustStore", "/tmp/mongo.p12");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName("mongo");
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());
		return args;
	}
*/
}
// comment