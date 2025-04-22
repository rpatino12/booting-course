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
			int limit = args.length > 0 ? Integer.parseInt(args[0]) : 0;
			for (int i = 1; i <= limit; i++) {
				String result = "";
				result += (i % 3) == 0 ? "Fizz" : "";
				result += (i % 5) == 0 ? "Buzz" : "";
				System.out.println(result.isEmpty() ? i : result);
			}
		};
	}

}
