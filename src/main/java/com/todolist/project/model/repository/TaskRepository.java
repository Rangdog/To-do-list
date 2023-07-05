package com.todolist.project.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.project.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findAllByIdUser(Long id);

}
