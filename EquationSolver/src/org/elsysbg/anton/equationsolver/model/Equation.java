package org.elsysbg.anton.equationsolver.model;

import java.sql.Date;

public class Equation extends Problem {
	private String solution;
	
	public Equation(long id, User user, Date dateOfCreation, String problem, long category) {
		super(id, user, dateOfCreation, problem, category);
	}
	
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
}