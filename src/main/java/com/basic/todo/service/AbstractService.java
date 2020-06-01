package com.basic.todo.service;

import com.basic.todo.model.AbstractEntity;
import com.basic.todo.repositories.BaseRepository;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<E extends AbstractEntity, R extends BaseRepository<E>> implements BaseService<E> {
    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }
}