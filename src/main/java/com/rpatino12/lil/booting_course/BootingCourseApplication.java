package com.rpatino12.lil.booting_course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootingCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootingCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			for (int i = 1; i <= 10; i++) {
				Thread.sleep(1000);
				System.out.println("Counting: " + i);
			}
		};
	}

}
