package com.mimacom.tastkmanager.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Task entity
 */
@Entity
@Table(name = "T_TASK", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "FK_USER", "START_DATE" }),
		@UniqueConstraint(columnNames = { "FK_USER", "END_DATE" })
	} // The same user can't start or end more than one task at the same time
)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Task")
	private Long idTask;
	@Column(name = "TASK_NAME")
	private String taskName;
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	@Column(name = "IS_FINISHED")
	private Boolean isFinished;
	@ManyToOne
	@JoinColumn(name = "FK_USER", nullable = false)
	private User userOwner;

}
