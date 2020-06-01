package com.basic.todo.service;

import java.util.List;
import java.util.Optional;

import com.basic.todo.model.AbstractEntity;
import com.basic.todo.model.ToDoTask;

public interface BaseService<E extends AbstractEntity> {
    Optional<E> save(E entity);
    public void delete();
    public List<ToDoTask> get();
}