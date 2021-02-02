package com.mimacom.tastkmanager.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.entities.User;

@Repository
public class TaskManagerDao {

	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private ITaskDao iTaskDao;

	public boolean saveUser(User user) throws IllegalArgumentException {

		Optional<User> optUser = Optional.ofNullable(iUserDao.save(user));

		return optUser.isPresent();

	}
	
	public User findUserByUserName(String userName) {
		
		return iUserDao.findUserByUserName(userName);
		
	}
	
	public boolean saveTask(Task task) {
		
		Optional<Task> optTask = Optional.ofNullable(iTaskDao.save(task));
		
		return optTask.isPresent();
	}

}
