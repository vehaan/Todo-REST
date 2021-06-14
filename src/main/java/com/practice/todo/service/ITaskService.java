package com.practice.todo.service;

import java.util.List;

import com.practice.todo.entity.Task;

public interface ITaskService {
	
	Task addTask(Task task);
	Task deleteTask(int id);
	Task updateTask(Task task);
	Task getTask(int id);
	List<Task> getAllTask();

}
