package br.com.jira.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.jira.adapters.output.mongo")
public class MongoConfig {
}
