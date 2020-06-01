package com.basic.todo.repositories;

import com.basic.todo.model.ToDoTask;

public interface ToDoTaskRepository extends BaseRepository<ToDoTask> {
	ToDoTask findBySummary(String summary);

	void deleteBySummary(String summary);
}
