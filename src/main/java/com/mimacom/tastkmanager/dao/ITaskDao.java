package com.mimacom.tastkmanager.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.entities.User;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Task Manager Task DAO Interface
 */
public interface ITaskDao extends CrudRepository<Task, Long> {
	
	public List<Task> findTaskByUserOwner(User user);

}
