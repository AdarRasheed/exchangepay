package com.exercise.exchangepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {"com.exercise"})
@EnableCaching
public class ExchangepayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangepayApplication.class, args);
	}

}
