package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class StudentsApplication {
	
	@Autowired
	private StudentRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			repo.save(new Student("Efoe", "Akolly", new Date()));
			repo.save(new Student("Emmanuel", "Akolly", new Date()));
			repo.save(new Student("Alexander", "Akolly", new Date()));
			repo.save(new Student("Christina", "Akolly", new Date()));
			repo.save(new Student("Lydia", "Akolly", new Date()));
			repo.save(new Student("Claire", "Akolly", new Date()));
			
		};
	}
}
