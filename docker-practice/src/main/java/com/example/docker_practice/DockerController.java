package com.example.docker_practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
	@GetMapping("/api")
	public String demo() {
		return "demo";
	}

	
}