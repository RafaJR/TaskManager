/**
 * 
 */
package com.mimacom.tastkmanager.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mimacom.tastkmanager.model.InputTask;
import com.mimacom.tastkmanager.model.InputUdateTask;
import com.mimacom.tastkmanager.model.InputUser;
import com.mimacom.tastkmanager.model.OutputTask;
import com.mimacom.tastkmanager.model.TaskState;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Task manager service
 */
@Service
public class TaskManagerServiceImpl implements ITaskManagerService {

	@Override
	public String getUserTasks(String idUser) {
		
		long lIdUser = Long.valueOf(idUser);
		return String.format("Tasks for user %s from the beginins of time to today", idUser);
	}

	@Override
	public List<OutputTask> getUserTasksByState(String id, TaskState taskState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OutputTask> getUserTasksByDate(String id, LocalDateTime startDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertUser(InputUser inputUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertTask(InputTask inputTask) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTask(InputUdateTask inputUdateTask) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTask(String idTask) {
		// TODO Auto-generated method stub
		return null;
	}

}
