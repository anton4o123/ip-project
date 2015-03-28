package org.elsysbg.anton.equationsolver.model;

import java.sql.Date;

public class Problem {
	private long id;
	private User user;
	private Date dateOfCreation;
	private String problem;
	private long category;
	
	public Problem(long id, User user, Date dateOfCreation, String problem, long category) {
		this.id = id;
		this.user = user;
		this.dateOfCreation = dateOfCreation;
		this.problem = problem;
		this.category = category;
	}
	
	public long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public String getProblem() {
		return problem;
	}

	public long getCategory() {
		return category;
	}
}