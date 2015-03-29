package org.elsysbg.anton.equationsolver.service;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.elsysbg.anton.equationsolver.model.Function;

public class FunctionService {
	private final List<Function> functions = new LinkedList<Function>();
	private long lastFunctionId = 0;
	
	public List<Function> getFunctions() {
		return functions;
	}
	
	public Function getFunction(long functionId) {
		for (Function next : functions) {
			if (next.getId() == functionId) {
				return next;
			}
		}
		return null;
	}
	
	public synchronized Function createFunction(Function function) {
		++lastFunctionId;
		function.setId(lastFunctionId);
		function.setDateOfCreation(new Date(System.currentTimeMillis()));
		return function;
	}
	
	public void deleteEquation(long functionId) {
		final Function toBeDeleted = getFunction(functionId);
		functions.remove(toBeDeleted);
	}
}