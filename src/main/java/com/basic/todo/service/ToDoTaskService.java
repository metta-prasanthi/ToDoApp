package com.basic.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.todo.model.ToDoTask;
import com.basic.todo.repositories.ToDoTaskRepository;

@Service
public class ToDoTaskService {
	
	@Autowired
	ToDoTaskRepository todoTaskRepo;

	public ToDoTask getTaskBySummary(String summary) {
		return todoTaskRepo.findBySummary(summary);
	}
	
	public List<ToDoTask> getAllTasks() {	
		List<ToDoTask> todoTaskList = new ArrayList<>();
		for (ToDoTask todoTask : todoTaskRepo.findAll()) {
			todoTaskList.add(todoTask);
		}
		return todoTaskList;
	}		
	
	public ToDoTask updateToDoTask(ToDoTask todoTask) {
		return todoTaskRepo.save(todoTask);
	}
	
	public ToDoTask saveToDoTask(ToDoTask todoTask){
		  return todoTaskRepo.save(todoTask);
	}
	
	public void deleteBySummary(String summary){
		todoTaskRepo.deleteBySummary(summary);
	}
	
	public void deleteAllTasks(){
		todoTaskRepo.deleteAll();
	}
}
