package org.elsysbg.anton.equationsolver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="Equation")
@NamedQueries({
	@NamedQuery(name="allEquations", query="Select e from Article e")
})
public class Equation extends Problem {
	@Column(nullable=false, length=500)
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