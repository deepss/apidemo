package com.startup.apidemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class ApidemoApplication {

	@RequestMapping("/hello")
	String home() {
		return "Hello World!";
	}

	static void main(String[] args) {
		SpringApplication.run ApidemoApplication, args
	}
}
