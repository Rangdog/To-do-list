package com.todolist.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todolist.project.dto.UserRegistrationDto;
import com.todolist.project.service.TaskService;
import com.todolist.project.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@GetMapping("/login")
	public String showloginform(){
		return"login";
	}
	
	
	
	@PostMapping("/login")
	public String authen(ModelMap modelMap, RedirectAttributes redirectAttributes ,@RequestParam("username")String username,@RequestParam("password")String password , HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (userService.getUserByEmail(username) != null) {
			if(userService.getUserByEmail(username).getPassword().equals(password)) {
				session.setAttribute("username",username);
				return "redirect:/homepage";
			}
			else {
				redirectAttributes.addFlashAttribute("error", "Username or password not exist");
				return "redirect:/login";
			}
		}
		return "redirect:/login";
	}
	@GetMapping("/logout")
	public String logoutauthen(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		return "redirect:/login";
	}
}
