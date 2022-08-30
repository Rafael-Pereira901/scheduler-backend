package com.rafaelalves.scheduler.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelalves.scheduler.entity.Task;
import com.rafaelalves.scheduler.service.TaskService;

@CrossOrigin
@RestController
@RequestMapping(value="/tasks")
public class TaskController {

	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return new ResponseEntity<Task>(taskService.createTask(task),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllUsers() {
		return new ResponseEntity<List<Task>>(taskService.getAllTasks(),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Task> updateTask(@RequestBody Task task, @RequestParam(value = "id",required = false)Long id){
		return new ResponseEntity<Task>(taskService.updateTask(id, task),HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteTask(@RequestParam(value = "id",required = false)Long id){
		taskService.deleteTask(id);
		return new ResponseEntity<String>("Task deleted successfully!",HttpStatus.OK);
	}
}
