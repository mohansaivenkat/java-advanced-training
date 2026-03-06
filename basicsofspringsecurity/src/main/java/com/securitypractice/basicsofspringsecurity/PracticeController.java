package com.securitypractice.basicsofspringsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PracticeController {

	@GetMapping("/practices")
	public String getDetails() {
		return "Details";
	}
	
	
	@GetMapping("/admin")
	public String setDetails() {
		return "Delete";
	}
}
