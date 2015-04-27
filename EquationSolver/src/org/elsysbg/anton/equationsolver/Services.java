package org.elsysbg.anton.equationsolver;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.elsysbg.anton.equationsolver.service.ArticleService;
import org.elsysbg.anton.equationsolver.service.EquationService;
import org.elsysbg.anton.equationsolver.service.FunctionService;

public class Services {
	private static EquationService equationService;
	private static FunctionService functionService;
	private static ArticleService articleService;
	private static EntityManagerFactory entityManagerFactory;
	
	public synchronized static EquationService getEquationService() {
		if (equationService == null) {
			equationService = new EquationService();
		}
		return equationService;
	}
	public static void setEquationService(EquationService equationService) {
		Services.equationService = equationService;
	}
	public static FunctionService getFunctionService() {
		if (functionService == null) {
			functionService = new FunctionService();
		}
		return functionService;
	}
	public static void setFunctionService(FunctionService functionService) {
		Services.functionService = functionService;
	}
	public static ArticleService getArticleService() {
		if (articleService == null) {
			articleService = new ArticleService();
		}
		return articleService;
	}
	public static void setArticleService(ArticleService articleService) {
		Services.articleService = articleService;
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory == null) {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("No driver", e);
			}
			entityManagerFactory = Persistence.createEntityManagerFactory("EquationSolver");
		}
		return entityManagerFactory;
	}
	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		Services.entityManagerFactory = entityManagerFactory;
	}
}