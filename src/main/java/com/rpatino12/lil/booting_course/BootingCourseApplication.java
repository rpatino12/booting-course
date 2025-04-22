package com.rpatino12.lil.booting_course;

import com.rpatino12.lil.booting_course.data.repository.EmployeeRepository;
import com.rpatino12.lil.booting_course.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootingCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootingCourseApplication.class, args);
	}

	// We can inject the RoomRepository because it is annotated with @Repository
	// and the ComponentScan of Spring Boot will pick it up
	@Bean
	public CommandLineRunner run(RoomRepository roomRepository, EmployeeRepository employeeRepository) {
		return args -> {
			roomRepository.findAll().forEach(System.out::println);
			employeeRepository.findAll().forEach(System.out::println);
		};
	}

}
