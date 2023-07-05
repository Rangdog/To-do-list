package com.todolist.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.project.dto.UserRegistrationDto;
import com.todolist.project.model.User;
import com.todolist.project.model.repository.UserRepository;

@Service
@Transactional
public class UserServicelmpl implements UserService{
	@Autowired
	private UserRepository uRepository;
	public UserServicelmpl(UserRepository uRepository) {
		super();
		this.uRepository = uRepository;
	}
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),registrationDto.getPassword());
		return uRepository.save(user);
	}
	@Override
	public User getUserByEmail(String email) {
		User user = new User();
		user = uRepository.findByEmail(email);
		return user;
	}

}
