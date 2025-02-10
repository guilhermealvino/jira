package br.com.jira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.jira.domain")
public class MiniJiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniJiraApplication.class, args);
	}

}