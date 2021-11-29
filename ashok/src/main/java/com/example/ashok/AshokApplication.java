package com.example.ashok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class AshokApplication {

	public static void main(String[] args) {
		SpringApplication.run(AshokApplication.class, args);
	}

	@GetMapping("/data")
	public String hello() {
		return "Hi welcome..!!";
	}
}
