package com.mcs.pmay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PmayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmayApplication.class, args);
	}
}
