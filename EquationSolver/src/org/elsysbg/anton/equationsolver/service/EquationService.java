package org.elsysbg.anton.equationsolver.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.elsysbg.anton.equationsolver.Services;
import org.elsysbg.anton.equationsolver.model.Equation;

public class EquationService extends ProblemService {
	final EntityManagerFactory emf;
	
	public EquationService() {
		emf = Services.getEntityManagerFactory();
	}
	
	public List<Equation> getEquations() {
		final EntityManager em = emf.createEntityManager();
		
		try {
			return em.createNamedQuery("allEquations", Equation.class).getResultList();
		} finally {
			em.close();
		}
	}
	
	public Equation getEquation(long equationId) {
		final EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Equation.class, equationId);
		} finally {
			em.close();
		}
	}
	
	public synchronized Equation createEquation(Equation equation) {
		EntityManager em = emf.createEntityManager();
		final EntityTransaction tx = em.getTransaction();
		ArrayList<Double> equationCoefficients = new ArrayList<Double>();
		String results = "";
		
		for (String next : equation.getProblem().split(" ")) {
			equationCoefficients.add(Double.parseDouble(next));
		}
		for (Double next : solveEquation(equationCoefficients)) {
			results += next + " ";
		}
		equation.setSolution(results);
		
		try {
			tx.begin();
			em.persist(equation);
			tx.commit();
			return equation;
		} finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}
	
	public void deleteEquation(long equationId) {
		EntityManager em = emf.createEntityManager();
		final EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			final Equation fromDb = em.find(Equation.class, equationId);
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