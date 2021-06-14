package com.practice.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.todo.entity.Task;
import com.practice.todo.service.TaskServiceImpl;

@RestController
//@RequestMapping("/")
public class TaskController {
	
	@Autowired
	TaskServiceImpl taskService;
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		Task newTask = taskService.addTask(task);
		return new ResponseEntity<Task>(newTask,HttpStatus.OK);
	}
	
	@RequestMapping("/tasks")
	public ResponseEntity<List<Task>> allTask(){
		List<Task> tasks = taskService.getAllTask();
		return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);
	}
	
	@RequestMapping("/tasks/{id}")
	public ResponseEntity<Task> getTask(@PathVariable int id){
		Task task = taskService.getTask(id);
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
	
	@PutMapping("/tasks")
	public ResponseEntity<Task> updateTask(@RequestBody Task task){
		Task updatedTask = taskService.updateTask(task);
		return new ResponseEntity<Task>(updatedTask,HttpStatus.OK);
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable int id){
		Task deletedTask = taskService.deleteTask(id);
		return new ResponseEntity<Task>(deletedTask,HttpStatus.OK);
	}

}
