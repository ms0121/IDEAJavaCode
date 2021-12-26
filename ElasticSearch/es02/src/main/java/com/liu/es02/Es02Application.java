package com.liu.es02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Es02Application {

	public static void main(String[] args) {
		SpringApplication.run(Es02Application.class, args);
	}

}
