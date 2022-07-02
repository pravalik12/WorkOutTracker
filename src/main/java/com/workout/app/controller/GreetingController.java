package com.workout.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class GreetingController {
	
	@GetMapping("/helloUser")
	public String greetUser() {
		return "Hello User!!";
	}
}
