package com.practice.todo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.practice.todo.entity.Task;
import com.practice.todo.service.TaskServiceImpl;

@RestController
public class TaskController {
	
	@Autowired
	TaskServiceImpl taskService;
	
	@GetMapping("/")
	public ResponseEntity<String> welcome() throws Exception{
		return new ResponseEntity<String>("Welcome to the HomePage",HttpStatus.OK);
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> addTask(@Valid @RequestBody Task task){
		Task newTask = taskService.addTask(task);
		return new ResponseEntity<Task>(newTask,HttpStatus.OK);
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> allTask() throws Exception{
		List<Task> tasks = taskService.getAllTask();
		return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTask(@PathVariable int id){
		Task task = taskService.getTask(id);
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
	
	@PutMapping("/tasks")
	public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task){
		Task updatedTask = taskService.updateTask(task);
		return new ResponseEntity<Task>(updatedTask,HttpStatus.OK);
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable int id){
		Task deletedTask = taskService.deleteTask(id);
		return new ResponseEntity<Task>(deletedTask,HttpStatus.OK);
	}

}
