package com.mimacom.tastkmanager.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.controller.TaskManagerController;
import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.entities.User;
import com.mimacom.tastkmanager.validation.IdTaskConstraint;
import com.mimacom.tastkmanager.validation.IdUserConstraint;
import com.mimacom.tastkmanager.validation.TaskConstraint;
import com.mimacom.tastkmanager.validation.UserNameConstraint;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Task Manager DAO implementation
 */
@Slf4j
@Repository
public class TaskManagerDao {

	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private ITaskDao iTaskDao;
	
	/**
	 * @param taskId
	 * @return Optional<Task>
	 */
	public Optional<Task> findTaskById(@NotNull Long taskId) {
		
		log.info(String.format(TaskManagerConstants.DAO_FIND_TASK_BY_ID, taskId.toString()));
		return iTaskDao.findById(taskId);
		
	}
	
	/**
	 * @param idUser
	 * @return boolean (true if success, false in other case)
	 */
	public boolean deleteUser(@NotNull @IdUserConstraint Long idUser) {
		
		log.info(String.format(TaskManagerConstants.DAO_DELETING_USER_BY_ID, idUser.toString()));
		
		try {
			
			iUserDao.deleteById(idUser);
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}

		return !iUserDao.existsById(idUser);
	}
	
	/**
	 * @param idTask
	 * @return boolean (true if success, false in other case)
	 */
	public boolean deleteTask(@NotNull Long idTask) {
		
		log.info(String.format(TaskManagerConstants.DAO_DELETING_TASK_BY_ID, idTask.toString()));
		
		try {
			
			iTaskDao.deleteById(idTask);
			
		}catch(Exception e) {
			log.info(String.format(TaskManagerConstants.DAO_DELETING_TASK_BY_ID_ERROR, idTask.toString()));
			e.printStackTrace();
			return false;
		}
		
		return !iTaskDao.existsById(idTask);
		
	}
	
	/**
	 * @param idTask
	 * @return boolean (true if success, false in other case)
	 */
	public boolean finishTask(@NotNull @IdTaskConstraint Long idTask) {
		
		log.info(String.format(TaskManagerConstants.DAO_FINISHING_TASK, idTask.toString()));
		
		Optional<Task> optTask = iTaskDao.findById(idTask);
		
		if(optTask.isPresent()) {
			Task task = optTask.get();
			task.setIsFinished(true);
			return iTaskDao.save(task).equals(task);
		}else {
			log.error(String.format(TaskManagerConstants.DAO_FINISHING_TASK_NOT_FOUND, idTask.toString()));
		}
		
		return false;
		
	}
			
	/**
	 * @param task
	 * @return boolean (true if success, false in other case)
	 */
	public boolean updateTask(@NotNull Task task) {
		
		log.info(String.format(TaskManagerConstants.DAO_UPDATING_TASK, task.toString()));
		
		if(task.getIdTask() != null) {
			return iTaskDao.save(task).equals(task);
		}
		return false;
		
	}
	
	/**
	 * @param userName
	 * @return List<Task>	 * 
	 */
	public List<Task> getUserTasks(@NotNull(message=TaskManagerConstants.NOT_NULL_USER) @UserNameConstraint String userName) {
		
		log.info(String.format(TaskManagerConstants.DAO_GETTING_TASK_FROM_USER, userName));
		
		Optional<User> optUser = Optional.ofNullable(iUserDao.findUserByUserName(userName));
		boolean foundTasks = optUser.isPresent();
		Optional<List<Task>> optTaskList = Optional.ofNullable(null);
		
		if(foundTasks) {
			optTaskList = Optional.ofNullable(iTaskDao.findTaskByUserOwner(optUser.get()));
			foundTasks = optTaskList.isPresent();
			if(!foundTasks) {
				log.error(String.format(TaskManagerConstants.DAO_NO_TASKS_FOR_USER, userName));
			}
		}else {
			log.error(String.format(TaskManagerConstants.DAO_GETTING_TASK_USER_NOT_FOUND, userName));
		}
		
		return foundTasks ? optTaskList.get() : null;
	}

	/**
	 * @param user
	 * @return boolean (true if success, false in other case)
	 * @throws IllegalArgumentException
	 */
	public boolean saveUser(@NotNull(message = TaskManagerConstants.NOT_NULL_USER) @Valid User user) throws IllegalArgumentException {
		
		log.info(String.format(TaskManagerConstants.DAO_CREATING_USER, user.toString()));
		
		Optional<User> optUser = Optional.ofNullable(iUserDao.save(user));

		return optUser.isPresent();

	}
	
	public User findUserByUserName(String userName) {
		
		return iUserDao.findUserByUserName(userName);
		
	}
	
	/**
	 * @param task
	 * @return (true if success, false in other case)
	 */
	public boolean saveTask(@NotNull(message = TaskManagerConstants.NOT_NULL_TASK) @Valid @TaskConstraint Task task) {
		
		log.info(String.format(TaskManagerConstants.DAO_CREATING_TASK, task.toString()));
		
		Optional<Task> optTask = Optional.ofNullable(iTaskDao.save(task));
		
		return optTask.isPresent();
	}

}
