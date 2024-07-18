package com.example.Integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
@SpringBootApplication
@ImportResource({"classpath:datasource-config.xml", "classpath:integration-config.xml"})
public class IntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}

}
