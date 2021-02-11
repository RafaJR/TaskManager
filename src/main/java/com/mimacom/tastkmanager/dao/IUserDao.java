package com.mimacom.tastkmanager.dao;

import org.springframework.data.repository.CrudRepository;

import com.mimacom.tastkmanager.entities.User;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Task Manager User Intferface
 */
public interface IUserDao extends CrudRepository<User, Long> {
	
	public User findUserByUserName(String userName);

}
