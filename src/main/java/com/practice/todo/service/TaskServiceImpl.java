package com.practice.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.todo.entity.Task;
import com.practice.todo.exception.IdNotFoundException;
import com.practice.todo.repo.ITaskRepository;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService {
	
	@Autowired
	ITaskRepository taskRepo;

	@Override
	public Task addTask(Task task) {
		taskRepo.save(task);
		return task;
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
		Optional<Task> optionalTask =  taskRepo.findById(id);
		return optionalTask.orElseThrow(() -> new IdNotFoundException("Task with given id doesn't exist!"));
	}

	@Override
	public List<Task> getAllTask() throws Exception {
		List<Task> tasks = taskRepo.findAll();
		if (tasks.size() == 0)
			throw new Exception("Relax, You have nothing todo :)");
		return tasks;
	}

}
