package com.todolist.project.dto;

import javax.persistence.Column;

public class TaskDto {
	private String taskName;
	private String taskPriority;
	private String taskStatus;
	private String taskDeadLine;
	private Long idUser;
	public TaskDto() {
		super();
	}
	public TaskDto(String taskName, String taskPriority, String taskStatus, String taskDeadLine, Long idUser) {
		super();
		this.taskName = taskName;
		this.taskPriority = taskPriority;
		this.taskStatus = taskStatus;
		this.taskDeadLine = taskDeadLine;
		this.idUser = idUser;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskDeadLine() {
		return taskDeadLine;
	}
	public void setTaskDeadLine(String taskDeadLine) {
		this.taskDeadLine = taskDeadLine;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	
	
}
