package com.mimacom.tastkmanager.dao;

import org.springframework.data.repository.CrudRepository;

import com.mimacom.tastkmanager.entities.Task;

public interface ITaskDao extends CrudRepository<Task, Long> {
	
	

}
