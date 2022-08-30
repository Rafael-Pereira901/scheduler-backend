package com.rafaelalves.scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rafaelalves.scheduler.entity.Task;
import com.rafaelalves.scheduler.repository.TaskRepository;

@Service
public class TaskService {
	
	private TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id:"+ id));
	}
	
	public Task updateTask(Long id, Task updatedTask) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id:"+ id));
		task.setTitle(updatedTask.getTitle());
		task.setName(updatedTask.getName());
		task.setDate(updatedTask.getDate());
		task.setHour(updatedTask.getHour());
		return taskRepository.save(task);
	}
	
	public void deleteTask(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id:"+ id));
		taskRepository.delete(task);
	}
	
}
