package com.basic.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.todo.model.ToDoTask;
import com.basic.todo.service.ToDoTaskService;

@RestController
public class ToDoTaskController {
	
	@Autowired
	private ToDoTaskService todoTaskService;

	@GetMapping(value="/getalltasks")
	public List<ToDoTask> getAllToDoTasks() {
		return todoTaskService.getAllTasks();
	}
	
	@GetMapping("/gettask/{summary}")
	public ToDoTask getTaskBySummary(@PathVariable String summary) {
		return todoTaskService.getTaskBySummary(summary);
	}
	
	@PostMapping(value="/savetask")
	public ToDoTask saveToDoTask(@RequestBody ToDoTask todoTask) {
		 return todoTaskService.saveToDoTask(todoTask);
	}
	
	@PutMapping(value="/updatetaskstatus/{summary}")
	public ToDoTask updateToDoTask(@PathVariable String summary) {
		 List<ToDoTask> taskList = todoTaskService.getAllTasks();
		 ToDoTask todoTask = null;
		 
		 for (ToDoTask task : taskList) {
			 if (task.getSummary().equalsIgnoreCase(summary)) {
				 todoTask = task;
				 break;
			 }
		 }
		 
		 todoTask.setStatus(Boolean.valueOf(true));
		 return todoTaskService.saveToDoTask(todoTask);
	}
	
    @DeleteMapping(value="/removeAllTasks")
    public void removeAllUser() {
    	todoTaskService.deleteAllTasks();
    }
    
    @DeleteMapping("/deletetask/{summary}")
	public void deleteTaskBySummary(@PathVariable String summary) {
    	todoTaskService.deleteBySummary(summary);
	}
}