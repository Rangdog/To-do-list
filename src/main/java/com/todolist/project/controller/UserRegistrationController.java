package com.todolist.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todolist.project.dto.UserRegistrationDto;
import com.todolist.project.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	private UserService userService;
	
	
	@Autowired
	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	public UserRegistrationController() {
	}
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	@GetMapping
	public String showRegistrationForm(Model model){
		model.addAttribute("user", new UserRegistrationDto());
		return"registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		userService.save(userRegistrationDto);
		return"login";
	}
}
