package com.basic.todo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.basic.todo.model.ToDoTask;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class taskControllerTest {

    private final ObjectMapper mapper = new JsonMapper();

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void getAlltasksTest() {
        try {
            mockMvc.perform(get("/tasks/"))
            	.andDo(print())
            	.andExpect(status().isOk())
            	.andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());

            mockMvc.perform(get("/tasks/").content(mapper.writeValueAsString(new ToDoTask()))
                    .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$").isEmpty());

        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }
}