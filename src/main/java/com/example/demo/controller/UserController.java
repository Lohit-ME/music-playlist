package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String front() {
		return "front";
	}

@GetMapping("/register")
public String showRegistionForm(Model model) {
	model.addAttribute("user",new User());
	return "Register";
}

@GetMapping("/login")
public String login() {
	return "login";
}                                                                  


//This method helps to implement registering authorized users and throws validation error

@PostMapping("/register")
public String registeruser(@Valid User user,BindingResult result,Model model) {
	
	List<String>errors=userservice.registerUser(user, result);
	
	if(!errors.isEmpty()) {
		
//		the errors enclosed doduble quotes will be used in the register.html file to get the errors 
		model.addAttribute("errors",errors);
		return "Register";
	}
	
//	redirect/login,it helps to load the "login.html file" by using the url named as "login"
	return "redirect:/login";
	
}
//close of register user methods

@PostMapping("/login")
public String loginUser(String username,String password,Model model) {
	
	User user=userservice.loginUser(username, password);
	
	if(user!=null) {
		
		model.addAttribute("username",username);
		return "home";
	}
	
	model.addAttribute("error","invaild username or password");
	return "login";
  }
}
