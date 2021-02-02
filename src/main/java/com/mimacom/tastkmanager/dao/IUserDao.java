package com.mimacom.tastkmanager.dao;

import org.springframework.data.repository.CrudRepository;

import com.mimacom.tastkmanager.entities.User;

public interface IUserDao extends CrudRepository<User, Long> {
	
	public User findUserByUserName(String userName);

}
