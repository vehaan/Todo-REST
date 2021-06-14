package com.practice.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.todo.entity.Task;
import com.practice.todo.repo.ITaskRepository;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService {
	
	@Autowired
	ITaskRepository taskRepo;

	@Override
	public Task addTask(Task task) {
		taskRepo.save(task);
		return taskRepo.getById(task.getId());
	}

	@Override
	public Task deleteTask(int id) {
		Task task = taskRepo.getById(id);
		taskRepo.deleteById(id);
		return task;
	}

	@Override
	public Task updateTask(Task task) {
		taskRepo.save(task);
		return task;
		
	}

	@Override
	public Task getTask(int id) {
		return taskRepo.getById(id);
	}

	@Override
	public List<Task> getAllTask() {
		List<Task> tasks = taskRepo.findAll();
		return tasks;
	}

}
