package com.basic.todo.controller;

import java.util.List;
import java.util.Optional;

import com.basic.todo.model.AbstractEntity;
import com.basic.todo.model.ToDoTask;
import com.basic.todo.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;


public class AbstractController<E extends AbstractEntity, S extends BaseService<E>> {
    public final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    public Optional<E> save(@RequestBody E entity) {
        return service.save(entity);
    }
    
    public List<ToDoTask> get() {
    	return service.get();
    }
    
    public void delete() {
    	service.delete();
    }
}