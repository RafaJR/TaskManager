package com.mimacom.tastkmanager.service;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Interface for task manager service
 */

import java.time.LocalDateTime;
import java.util.List;

import com.mimacom.tastkmanager.model.InputTask;
import com.mimacom.tastkmanager.model.InputUdateTask;
import com.mimacom.tastkmanager.model.InputUser;
import com.mimacom.tastkmanager.model.OutputTask;
import com.mimacom.tastkmanager.model.TaskState;

public interface ITaskManagerService {
	
	public List<OutputTask> getUserTasks(String idUser);
	public List<OutputTask> getUserTasksByState(String id, TaskState taskState);
	public List<OutputTask> getUserTasksByDate(String id, LocalDateTime startDate, LocalDateTime endDate);
	public boolean saveUser(InputUser inputUser);
	public String deleteUser(Long idUser);
	public boolean saveTask(InputTask inputTask);
	public String updateTask(InputUdateTask inputUdateTask);
	public String deleteTask(String idTask);

}