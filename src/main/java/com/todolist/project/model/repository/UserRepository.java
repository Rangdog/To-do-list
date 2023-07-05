package com.todolist.project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.project.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
