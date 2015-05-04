package org.elsysbg.anton.equationsolver.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.elsysbg.anton.equationsolver.Services;
import org.elsysbg.anton.equationsolver.model.Function;

public class FunctionService extends ProblemService {
	private final EntityManagerFactory emf;
	
	private String drawGraphics(ArrayList<Double> function) {
		final double gridOffset = 300;
		ArrayList<Double> roots = solveEquation(function);
		double difference = Math.abs(roots.get(0)) + Math.abs(roots.get(roots.size() - 1));
		double step = difference / 100;
		String path = "<svg version='1.1' xmlns='http://www.w3.org/2000/svg'>";
		
		path += "<line stroke='black' stroke-width='2' x1='150' x2='450' y1='300' y2='300'/>";
		path += "<line stroke='black' stroke-width='2' x1='300' x2='300' y1='150' y2='450'/>";
		path += "<path d='M";
		
		for (double i = roots.get(0); i <= roots.get(roots.size() - 1); i += step) {
			path += " L" + (i + gridOffset);
			path += " " + ((-findValueOfFunction(i, function)) + gridOffset);
		}
		
		path += "' fill='none' strike-width='2' stroke='blue'/></svg>";
		return path;
	}
	
	public FunctionService() {
		emf = Services.getEntityManagerFactory();
	}
	
	public List<Function> getFunctions() {
		final EntityManager em = emf.createEntityManager();
		
		try {
			return em.createNamedQuery("allFunctions", Function.class).getResultList();
		} finally {
			em.close();
		}
	}
	
	public Function getFunction(long functionId) {
		final EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Function.class, functionId);
		} finally {
			em.close();
		}
	}
	
	public synchronized Function createFunction(Function function) {
		EntityManager em = emf.createEntityManager();
		final EntityTransaction tx = em.getTransaction();
		ArrayList<Double> functionCoefficients = new ArrayList<Double>();
		
		for (String next : function.getProblem().split(" ")) {
			functionCoefficients.add(Double.parseDouble(next));
		}
		function.setGraphics(drawGraphics(functionCoefficients));
		
		try {
			tx.begin();
			em.persist(function);
			tx.commit();
			return function;
		} finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}
	
	public void deleteFunction(long functionId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			final Function fromDb = em.find(Function.class, functionId);
			if(fromDb != null) {
				em.remove(fromDb);
			}
			tx.commit();
		} finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}
}