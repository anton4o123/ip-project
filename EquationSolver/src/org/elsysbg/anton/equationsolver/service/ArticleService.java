package org.elsysbg.anton.equationsolver.service;

import java.util.LinkedList;
import java.util.List;

import org.elsysbg.anton.equationsolver.model.Article;

public class ArticleService {
	private final List<Article> articles = new LinkedList<Article>();
	private long lastArticleId = 0;
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public Article getArticle(long articleId) {
		for (Article next : articles) {
			if (next.getId() == articleId) {
				return next;
			}
		}
		return null;
	}
	
	public synchronized Article createArticle(Article article) {
		++lastArticleId;
		
		article.setId(lastArticleId);
		articles.add(article);
		return article;
	}
	
	public Article updateArticle(long articleId, Article article) {
		final Article fromDb = getArticle(articleId);
		fromDb.setBody(article.getBody());
		fromDb.setTitle(article.getTitle());
		return fromDb;
	}
	
	public void deleteArticle(long articleId) {
		final Article toBeDeleted = getArticle(articleId);
		articles.remove(toBeDeleted);
	}
}