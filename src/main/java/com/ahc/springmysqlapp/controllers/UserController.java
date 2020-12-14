package com.ahc.springmysqlapp.controllers;

import com.ahc.springmysqlapp.repositories.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping({ "", "/", "/index" })
  public String getUserPage(Model model) {
    model.addAttribute("users", userRepository.findAll());
    return "user/index";
  }

  @RequestMapping("/new")
  public String getUserRegistrationPage() {
    return "user/new";
  }
  
}
