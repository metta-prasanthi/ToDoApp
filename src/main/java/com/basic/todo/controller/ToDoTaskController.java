package com.basic.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.todo.model.ToDoTask;
import com.basic.todo.service.ToDoTaskService;

@RestController
@RequestMapping("/tasks")
public class ToDoTaskController extends AbstractController<ToDoTask, ToDoTaskService> {

	public ToDoTaskController(ToDoTaskService service) {
		super(service);
	}

	@GetMapping(value = "/")
	public List<ToDoTask> get() {
		return service.get();
	}

	@GetMapping("/{summary}")
	public ToDoTask getTaskBySummary(@PathVariable String summary) {
		return service.getTaskBySummary(summary);
	}

	@PostMapping(value = "/")
	public Optional<ToDoTask> save(@RequestBody ToDoTask todoTask) {
		return service.save(todoTask);
	}

	@PutMapping(value = "/{summary}")
	public Optional<ToDoTask> updateToDoTask(@PathVariable String summary) {
		List<ToDoTask> taskList = service.get();
		ToDoTask todoTask = null;

		for (ToDoTask task : taskList) {
			if (task.getSummary().equalsIgnoreCase(summary)) {
				todoTask = task;
				break;
			}
		}

		todoTask.setStatus(Boolean.valueOf(true));
		return service.save(todoTask);
	}

	@DeleteMapping(value = "/")
	public void delete() {
		service.delete();
	}

	@DeleteMapping("/{summary}")
	public void deleteTaskBySummary(@PathVariable String summary) {
		service.deleteBySummary(summary);
	}

	@GetMapping("/tweet")
	public String gettweet() {
		return "Tweet";
	}
}