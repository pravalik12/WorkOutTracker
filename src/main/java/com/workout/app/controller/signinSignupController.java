package com.workout.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workout.app.model.Employee;
import com.workout.app.model.SigninSignup;
import com.workout.app.repository.SigninSignupRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gym")
public class signinSignupController {
	
	@Autowired
	private SigninSignupRepository signinSignupRepository;
	
	@GetMapping("/login")
	public String greetUser() {
		return "Welcome to gym Login";
	}
	
	@GetMapping("login/users")
	public List<SigninSignup> getAllEmployees(){
		return signinSignupRepository.findAll();
	}
	
	@PostMapping("login/users")
	public SigninSignup createUser(@RequestBody SigninSignup signinSignup) {
		return signinSignupRepository.save(signinSignup);
	}
}
