package com.mimacom.tastkmanager.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.entities.User;

public interface ITaskDao extends CrudRepository<Task, Long> {
	
	public List<Task> findTaskByUserOwner(User user);

}
