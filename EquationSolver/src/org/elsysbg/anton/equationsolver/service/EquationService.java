package org.elsysbg.anton.equationsolver.service;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.elsysbg.anton.equationsolver.model.Equation;

public class EquationService {
	private final List<Equation> equations = new LinkedList<Equation>();
	private long lastEquationId = 0;
	
	public List<Equation> getEquations() {
		return equations;
	}
	
	public Equation getEquation(long equationId) {
		for (Equation next : equations) {
			if (next.getId() == equationId) {
				return next;
			}
		}
		return null;
	}
	
	public synchronized Equation createEquation(Equation equation) {
		++lastEquationId;
		equation.setId(lastEquationId);
		equation.setDateOfCreation(new Date(System.currentTimeMillis()));
		return equation;
	}
	
	public void deleteEquation(long equationId) {
		final Equation toBeDeleted = getEquation(equationId);
		equations.remove(toBeDeleted);
	}
}