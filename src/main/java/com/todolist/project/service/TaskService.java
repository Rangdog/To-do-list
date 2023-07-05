package com.todolist.project.service;

import java.util.List;

import com.todolist.project.dto.TaskDto;
import com.todolist.project.model.Task;



public interface TaskService {
	Task save(TaskDto taskDto);
	List<Task> getAllTasks(Long id);
	
	Task getTaskById(Long id);
	
	Task save(Task Task);
	
	void deleteTaskByID(Long id);
}
