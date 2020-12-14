package com.ahc.springmysqlapp.controllers;

import com.ahc.springmysqlapp.domain.User;
import com.ahc.springmysqlapp.repositories.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/register")
  public String getUserRegistrationPage() {
    return "user/register";
  }

  /**
   * Register new user into database.
   * 
   * @param name  is user's name
   * @param email is user's email
   * @return Spring View
   */
  @PostMapping("/register")
  public String userSubmit(@RequestParam String name, @RequestParam String email, Model model) {

    User user = new User();
    user.setName(name);
    user.setEmail(email);
    userRepository.save(user);

    model.addAttribute("name", name);
    model.addAttribute("email", email);
    return "user/register-result";
  }

}
