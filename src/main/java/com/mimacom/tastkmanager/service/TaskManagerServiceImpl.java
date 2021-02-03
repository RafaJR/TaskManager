/**
 * 
 */
package com.mimacom.tastkmanager.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.dao.TaskManagerDao;
import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.entities.User;
import com.mimacom.tastkmanager.model.InputTask;
import com.mimacom.tastkmanager.model.InputUdateTask;
import com.mimacom.tastkmanager.model.InputUser;
import com.mimacom.tastkmanager.model.OutputTask;
import com.mimacom.tastkmanager.model.TaskState;
import com.mimacom.tastkmanager.validation.TaskConstraint;
import com.mimacom.tastkmanager.validation.UserNameConstraint;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Task manager service
 */
@Service
public class TaskManagerServiceImpl implements ITaskManagerService {

	@Autowired
	TaskManagerDao taskManagerDao;

	public boolean finishTask(@NotNull Long idTask) {
		
		return taskManagerDao.finishTask(idTask);
		
	}

	@Override
	public boolean updateTask(@NotNull @Valid InputUdateTask inputUdateTask) {

		Optional<Task> optTask = taskManagerDao.findById(inputUdateTask.getIdTask());

		if (optTask.isPresent()) {

			Task task = optTask.get();

			task.setTaskName(inputUdateTask.getTaskName() != null ? inputUdateTask.getTaskName() : task.getTaskName());
			task.setIsFinished(
					inputUdateTask.getIsFinished() != null ? inputUdateTask.getIsFinished() : task.getIsFinished());
			task.setStartDate(inputUdateTask.getStarDate() != null
					? LocalDateTime.parse(inputUdateTask.getStarDate(), TaskManagerConstants.DATE_FORMAT)
					: task.getStartDate());
			task.setEndDate(inputUdateTask.getEndDate() != null
					? LocalDateTime.parse(inputUdateTask.getEndDate(), TaskManagerConstants.DATE_FORMAT)
					: task.getEndDate());

			return taskManagerDao.updateTask(task);
		}

		return false;

	}

	@Override
	@Transactional
	public boolean saveTask(
			@NotNull(message = TaskManagerConstants.NOT_NULL_TASK) @Valid @TaskConstraint InputTask inputTask) {

		Optional<User> optUser = Optional.ofNullable(taskManagerDao.findUserByUserName(inputTask.getUserName()));
		boolean checkTaskSave = optUser.isPresent();

		if (checkTaskSave) {

			Task task = inputTask.toEntity();
			task.setUserOwner(optUser.get());
			checkTaskSave = taskManagerDao.saveTask(task);
		}

		return checkTaskSave;
	}

	@Override
	public boolean saveUser(@NotNull(message = TaskManagerConstants.NOT_NULL_USER) @Valid InputUser inputUser) {

		return taskManagerDao.saveUser(inputUser.toEntity());
	}

	@Override
	public List<OutputTask> getUserTasks(
			@NotNull(message = TaskManagerConstants.NOT_NULL_USER) @UserNameConstraint String userName) {

		Optional<List<Task>> optTaskList = Optional.ofNullable(taskManagerDao.getUserTasks(userName));

		if (optTaskList.isPresent()) {

			return optTaskList.get().parallelStream()
					.map(task -> OutputTask.builder().taskName(task.getTaskName())
							.userName(task.getUserOwner().getUserName())
							.starDate(task.getStartDate().format(TaskManagerConstants.DATE_FORMAT))
							.endDate(task.getEndDate().format(TaskManagerConstants.DATE_FORMAT))
							.isFinished(task.getIsFinished()).build())
					.collect(Collectors.toList());

		}

		return null;
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
	public String deleteUser(Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTask(String idTask) {
		// TODO Auto-generated method stub
		return null;
	}

}
