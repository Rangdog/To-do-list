package com.todolist.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "taskssss")
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "task_name")
	private String taskName;
	@Column(name = "task_priority")
	private String taskPriority;
	@Column(name = "task_status")
	private String taskStatus;
	@Column(name = "user_id")
	private Long idUser;
	@Column(name = "task_deads_line")
	private String taskDeadLine;

	public Task() {
	}

	public Task(String taskName, String taskPriority, String taskStatus, Long idUser, String taskDeadLine) {
		super();
		this.taskName = taskName;
		this.taskPriority = taskPriority;
		this.taskStatus = taskStatus;
		this.idUser = idUser;
		this.taskDeadLine = taskDeadLine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getTaskDeadLine() {
		return taskDeadLine;
	}

	public void setTaskDeadLine(String taskDeadLine) {
		this.taskDeadLine = taskDeadLine;
	}
}
