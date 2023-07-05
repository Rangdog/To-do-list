package com.todolist.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todolist.project.dto.TaskDto;
import com.todolist.project.model.Task;
import com.todolist.project.model.User;
import com.todolist.project.service.TaskService;
import com.todolist.project.service.UserService;

@Controller
public class TaskController {
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/homepage")
	public String listTasks(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return "redirect:/login";
		}
		User user = userService.getUserByEmail(session.getAttribute("username").toString());
		model.addAttribute("tasks", taskService.getAllTasks(user.getId()));
		return "homepage";
	}
	
	@RequestMapping("/new")
	public String creatnewpage(Model model) {
		Task task = new Task();
		model.addAttribute("task", task);
		return "new";
	}
	
	@PostMapping("/save")
	public String saveTask(@ModelAttribute("task") TaskDto taskDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = userService.getUserByEmail(session.getAttribute("username").toString());
		taskDto.setIdUser(user.getId());
		String s = taskDto.getTaskDeadLine();
		taskDto.setTaskDeadLine(s);
		taskService.save(taskDto);
		return "redirect:/homepage";
	}
	
	@GetMapping("/edit/{id}")
	public String editTaskForm(@PathVariable Long id, Model model) {
		model.addAttribute("task", taskService.getTaskById(id));
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String editTask(@PathVariable Long id, @ModelAttribute("task") Task task, Model model, HttpServletRequest request) throws ParseException {
		HttpSession session = request.getSession();
		User user = userService.getUserByEmail(session.getAttribute("username").toString());
		Task task2 = taskService.getTaskById(id);
		task2.setId(id);
		task2.setIdUser(user.getId());
		String s = task.getTaskDeadLine();
		String regex = "([0-9]{2})-([0-9]{2})-([0-9]{4})";
		if(s.matches(regex)) {
			SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
			Date date = dt.parse(s);
			SimpleDateFormat dtt = new SimpleDateFormat("yyyy-MM-dd");
			String t = dtt.format(date);
			task2.setTaskDeadLine(t);
		}
		else {
			task2.setTaskDeadLine(task.getTaskDeadLine());
		}
		task2.setTaskName(task.getTaskName());
		task2.setTaskPriority(task.getTaskPriority());
		task2.setTaskStatus(task.getTaskStatus());
		
		taskService.save(task2);
		return "redirect:/homepage";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteTaskByID(id);
		return "redirect:/homepage";
	}
}
