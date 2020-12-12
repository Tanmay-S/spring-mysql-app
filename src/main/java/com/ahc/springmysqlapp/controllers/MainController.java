package com.ahc.springmysqlapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahc.springmysqlapp.domain.User;
import com.ahc.springmysqlapp.repositories.UserRepository;

@Controller
@RequestMapping("/demo")
public class MainController {

	private final UserRepository userRepository;

	public MainController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@PostMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return "Saved";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

}
