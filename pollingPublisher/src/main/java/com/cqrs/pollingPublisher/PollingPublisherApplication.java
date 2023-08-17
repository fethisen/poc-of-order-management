package com.cqrs.pollingPublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PollingPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollingPublisherApplication.class, args);
	}

}
