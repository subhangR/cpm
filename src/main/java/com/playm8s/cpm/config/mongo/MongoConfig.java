package com.playm8s.cpm.config.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
//@EnableMongoAuditing
public class MongoConfig {
    public static final String APPCONFIG = "appConfig";

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    /**
     * Creates a mongo client bean in spring container.
     * @return - MongoClient bean.
     */
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), APPCONFIG);
    }

}
