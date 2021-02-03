package com.mimacom.tastkmanager.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.entities.User;
import com.mimacom.tastkmanager.validation.TaskConstraint;
import com.mimacom.tastkmanager.validation.UserNameConstraint;

@Repository
public class TaskManagerDao {

	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private ITaskDao iTaskDao;
	
	public boolean updateTask(Task task) {
		
		return iTaskDao.save(task).equals(task);
		
	}
	
	public List<Task> getUserTasks(@NotNull(message=TaskManagerConstants.NOT_NULL_USER) @UserNameConstraint String userName) {
		
		Optional<User> optUser = Optional.ofNullable(iUserDao.findUserByUserName(userName));
		boolean foundTasks = optUser.isPresent();
		Optional<List<Task>> optTaskList = Optional.ofNullable(null);
		
		if(foundTasks) {
			optTaskList = Optional.ofNullable(iTaskDao.findTaskByUserOwner(optUser.get()));
			foundTasks = optTaskList.isPresent();
		}
		
		return foundTasks ? optTaskList.get() : null;
	}

	public boolean saveUser(@NotNull(message = TaskManagerConstants.NOT_NULL_USER) @Valid User user) throws IllegalArgumentException {

		Optional<User> optUser = Optional.ofNullable(iUserDao.save(user));

		return optUser.isPresent();

	}
	
	public User findUserByUserName(String userName) {
		
		return iUserDao.findUserByUserName(userName);
		
	}
	
	public boolean saveTask(@NotNull(message = TaskManagerConstants.NOT_NULL_TASK) @Valid @TaskConstraint Task task) {
		
		Optional<Task> optTask = Optional.ofNullable(iTaskDao.save(task));
		
		return optTask.isPresent();
	}

}
