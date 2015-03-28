package org.elsysbg.anton.equationsolver.model;

public class Equation extends Problem {
	private String solution;
	
	public Equation(long id, User user, String problem, long category) {
		super(id, user, problem, category);
	}
	
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
}