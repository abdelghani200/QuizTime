package com.QuizTime.QuizTime;

import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class QuizTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizTimeApplication.class, args);
	}

	@Bean
	public Faker faker() {
		return new Faker();
	}

}
