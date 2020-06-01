package com.basic.todo.repositories;

import com.basic.todo.model.AbstractEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {

}