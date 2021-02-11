package com.mimacom.tastkmanager.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * User entity
 */
@Entity
@Table(name="T_USER")
@Data
@ToString(exclude = {"userPassword"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USER")
	Long idUser;
	@Column(name="USER_NAME", unique=true, nullable=false)
	private String userName;
	@Column(name="USER_EMAIL", unique=true)
	private String userEmail;
	@Column(name="USER_PASSWORD")
	private String userPassword;
	@OneToMany(mappedBy="userOwner", fetch=FetchType.LAZY)
	List<Task> listTask;

}
