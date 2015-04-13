package org.elsysbg.anton.equationsolver.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.elsysbg.anton.equationsolver.Services;
import org.elsysbg.anton.equationsolver.model.Function;

public class FunctionService {
	private final EntityManagerFactory emf;
	
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