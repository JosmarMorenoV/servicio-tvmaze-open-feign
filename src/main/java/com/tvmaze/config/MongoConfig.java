package com.tvmaze.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

	@Value("${tvmaze.mongodb.uri}")
	private String mongoUri;

	@Bean
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString(mongoUri);
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		return MongoClients.create(settings);
	}

	@Bean
	public MongoDatabaseFactory mongoDatabaseFactory() {
		return new SimpleMongoClientDatabaseFactory(mongoClient(), new ConnectionString(mongoUri).getDatabase());
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoDatabaseFactory());
	}

}
