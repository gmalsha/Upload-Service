package com.upload.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;




@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.upload.server.repository")
public class MongoConfig extends AbstractReactiveMongoConfiguration{
	@Value("${port}")
	private String port;
	@Value("${dbname}")
	private String dbName;
	
	@Override
	protected String getDatabaseName() {
		System.out.println(dbName);
		return dbName;
	}
	public MongoClient reactiveMongoClient(){
		System.out.println("mongo client created");
		return MongoClients.create();
		
	}
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
    	System.out.println("ReactiveMongoTemplate bean created");
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }

}
