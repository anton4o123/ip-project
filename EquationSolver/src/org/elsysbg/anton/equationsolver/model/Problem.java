package org.elsysbg.anton.equationsolver.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Problem")
public class Problem {
	@Id
	@GeneratedValue
	private long id;
//	private User user;
	
	@Column(nullable=false)
	private Date dateOfCreation;
	
	@Column(nullable=false, length=500)
	private String problem;
	
	@Column(nullable=false)
	private long category;
	
	public Problem(long id, User user, String problem, long category) {
		this.id = id;
	//	this.user = user;
		this.dateOfCreation = new Date(System.currentTimeMillis());
		this.problem = problem;
		this.category = category;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
/*	public User getUser() {
		return user;
	}*/
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getProblem() {
		return problem;
	}

	public long getCategory() {
		return category;
	}
}