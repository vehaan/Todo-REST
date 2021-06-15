package com.practice.todo.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.practice.todo.entity.Task;
import com.practice.todo.repo.ITaskRepository;
import com.practice.todo.service.TaskServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TaskTest {
	
	@Mock
	ITaskRepository taskRepo;
	
	@InjectMocks
	TaskServiceImpl taskService;
	
	static Task task1;
	static Task task2;
	static List<Task> tasks;
	
	@BeforeAll
	 static void setUpBeforeclass() {
		System.out.println("Starting the test...");
		task1 = new Task(1,"Go to gym");
		task2 = new Task(2,"Study Java");
		tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("Test complete!");

	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Executing the next test case...");
		
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Executed this test case!");
	}
	
	@Test
	@Order(1)
	void addTaskTest() {
		when(taskRepo.save(task1)).thenReturn(task1);
		assertEquals(task1, taskService.addTask(task1));
	}
	
	@Test
	@Order(2)
	void getTaskTest() {
		when(taskRepo.findById(task1.getId())).thenReturn(Optional.of(task1));
		assertEquals(task1, taskService.getTask(task1.getId()));
	}
	
	@Test
	@Order(3)
	void updateTaskTest() {
		taskService.addTask(task2);
		task2.setMessage("Study Javascript");
		when(taskRepo.save(task2)).thenReturn(task2);
		assertEquals(task2, taskService.updateTask(task2));
	}
	
	@Test
	@Order(4)
	void getAllTaskTest() throws Exception {
		when(taskRepo.findAll()).thenReturn(tasks);
		assertEquals(tasks, taskService.getAllTask());
	}
	
	@Test
	@Order(5)
	void deleteTaskTest() throws Exception {
		assertTrue((taskService.deleteTask(task1.getId())) == null || taskService.deleteTask(task1.getId()) == task1);
	}
	
	

}
