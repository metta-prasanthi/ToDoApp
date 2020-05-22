package com.basic.todo.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.basic.todo.model.ToDoTask;
import com.basic.todo.service.ToDoTaskService;

@SpringBootTest
public class taskServiceTest {

	@Autowired
	private ToDoTaskService todotaskService;
	
	@Test
	public void saveTaskTest() {
		ToDoTask task = todotaskService.saveToDoTask(new ToDoTask("read", "Read SRE Book", false));

		assertNotNull(task);
		assertEquals(task.getSummary(), "read");
		
	}
	
	@Test
	public void GetBySummaryTaskTest() {
		ToDoTask task1 = todotaskService.saveToDoTask(new ToDoTask("code", "Code ToDo App", false));
		
		assertNotNull(task1);
		assertNotNull(todotaskService.getTaskBySummary("code"));
	}
	
	@Test
	public void testUpdateTaskStatus() {
		ToDoTask task1 = todotaskService.saveToDoTask(new ToDoTask("read", "Read SRE Book", false));

		task1.setStatus(Boolean.valueOf(true));

		assertEquals(task1.getStatus(), true);
	}
	
}


