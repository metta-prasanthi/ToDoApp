package com.basic.todo.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import com.basic.todo.model.ToDoTask;
import com.basic.todo.service.ToDoTaskService;

@SpringBootTest
public class taskServiceTest {

	@Autowired
	private ToDoTaskService todotaskService;

	@Test
	public void saveTaskTest() {
		Optional<ToDoTask> task = todotaskService.save(new ToDoTask("read", "Read SRE Book", false));

		assertNotNull(task);
		assertEquals(task.get().getSummary(), "read");

	}

	@Test
	public void GetBySummaryTaskTest() {
		Optional<ToDoTask> task1 = todotaskService.save(new ToDoTask("code", "Code ToDo App", false));

		assertNotNull(task1);
		assertNotNull(todotaskService.getTaskBySummary("code"));
	}

	@Test
	public void testUpdateTaskStatus() {
		Optional<ToDoTask> task1 = todotaskService.save(new ToDoTask("read", "Read SRE Book", false));

		task1.get().setStatus(Boolean.valueOf(true));

		assertEquals(task1.get().getStatus(), true);
	}
}
