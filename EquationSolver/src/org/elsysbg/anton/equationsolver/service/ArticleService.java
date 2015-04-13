package org.elsysbg.anton.equationsolver.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.elsysbg.anton.equationsolver.Services;
import org.elsysbg.anton.equationsolver.model.Article;

public class ArticleService {
	private final EntityManagerFactory emf;
	
	public ArticleService() {
		emf = Services.getEntityManagerFactory();
	}
	
	public List<Article> getArticles() {
		final EntityManager em = emf.createEntityManager();
		try {
			return em.createNamedQuery("allArticle", Article.class).getResultList();
		} finally {
			em.close();
		}
	}
	
	public Article getArticle(long articleId) {
		final EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Article.class, articleId);
		} finally {
			em.close();
		}
	}
	
	public synchronized Article createArticle(Article article) {
		EntityManager em = emf.createEntityManager();
		final EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(article);
			tx.commit();
			return article;
		} finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}
	
	public Article updateArticle(long articleId, Article article) {
		EntityManager em = emf.createEntityManager();
		final EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			final Article fromDb = em.find(Article.class, articleId);
			if(fromDb != null) {
				em.merge(fromDb);
			}
			tx.commit();
			return fromDb;
		} finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}
	
	public void deleteArticle(long articleId) {
		EntityManager em = emf.createEntityManager();
		final EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			final Article fromDb = em.find(Article.class, articleId);
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