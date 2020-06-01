package com.basic.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basic.todo.model.ToDoTask;
import com.basic.todo.repositories.ToDoTaskRepository;

@Service
public class ToDoTaskService extends AbstractService<ToDoTask, ToDoTaskRepository> {

	public ToDoTaskService(ToDoTaskRepository repository) {
		super(repository);
	}

	public ToDoTask getTaskBySummary(String summary) {
		return repository.findBySummary(summary);
	}

	public List<ToDoTask> get() {
		List<ToDoTask> todoTaskList = new ArrayList<>();
		for (ToDoTask todoTask : repository.findAll()) {
			todoTaskList.add(todoTask);
		}
		return todoTaskList;
	}

	public ToDoTask updateToDoTask(ToDoTask todoTask) {
		return repository.save(todoTask);
	}

	public Optional<ToDoTask> save(ToDoTask todoTask) {
		return Optional.of(repository.save(todoTask));
	}

	public void deleteBySummary(String summary) {
		repository.deleteBySummary(summary);
	}

	public void delete() {
		repository.deleteAll();
	}
}
