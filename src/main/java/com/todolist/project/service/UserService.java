package com.todolist.project.service;

import com.todolist.project.model.User;
import com.todolist.project.dto.UserRegistrationDto;

public interface UserService {
	User save(UserRegistrationDto registrationDto);
	
	User getUserByEmail(String email);

}
