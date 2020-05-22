package com.basic.todo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.basic.todo.model.ToDoTask;

public interface ToDoTaskRepository extends CrudRepository<ToDoTask, Long>{
	ToDoTask findBySummary(String summary);
	void deleteBySummary(String summary);
}
