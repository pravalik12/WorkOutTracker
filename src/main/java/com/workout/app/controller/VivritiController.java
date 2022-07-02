package com.workout.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workout.app.model.User;
import com.workout.app.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class VivritiController {
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/register")
	public User doRegistration(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String dob,@RequestParam String username,@RequestParam String password) {
		User user = new User();
		user.setDob(dob);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setUserName(username);
		return userRepo.save(user);
	}
	
	@PatchMapping("/updateUser")
	public User updateUser(@RequestParam Long id) throws Exception {
		User user = userRepo.findById(id).orElseThrow(() -> new Exception("Not found"));
		user.setUserName(user.getUserName() + "abc");
		return userRepo.save(user);
		
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam Long id) throws Exception {
		User user = userRepo.findById(id).orElseThrow(() -> new Exception("Not found"));
		userRepo.delete(user);
		return "user deleted successfully";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return userRepo.findAll();
		
	}

}
