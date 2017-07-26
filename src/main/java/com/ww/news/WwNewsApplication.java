package com.ww.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WwNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WwNewsApplication.class, args);
	}
}
