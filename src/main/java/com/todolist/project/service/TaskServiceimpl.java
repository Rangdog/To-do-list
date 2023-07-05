package com.todolist.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.project.dto.TaskDto;
import com.todolist.project.model.Task;
import com.todolist.project.model.repository.TaskRepository;

@Service
@Transactional
public class TaskServiceimpl implements TaskService{
	@Autowired
	private TaskRepository taskRepository;
	
	public TaskServiceimpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}



	@Override
	public Task save(TaskDto taskDto) {
		Task task = new Task(taskDto.getTaskName(), taskDto.getTaskPriority(), taskDto.getTaskStatus(),taskDto.getIdUser() , taskDto.getTaskDeadLine());
		return taskRepository.save(task);
	}



	@Override
	public List<Task> getAllTasks(Long id) {
		return taskRepository.findAllByIdUser(id);
	}



	@Override
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).get();
	}



	@Override
	public Task save(Task Task) {
		return taskRepository.save(Task);
	}



	@Override
	public void deleteTaskByID(Long id) {
		taskRepository.deleteById(id);
	}
}
