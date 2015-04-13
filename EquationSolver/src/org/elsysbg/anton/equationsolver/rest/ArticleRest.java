package org.elsysbg.anton.equationsolver.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.elsysbg.anton.equationsolver.Services;
import org.elsysbg.anton.equationsolver.model.Article;
import org.elsysbg.anton.equationsolver.service.ArticleService;

@Path("article")
public class ArticleRest {
	private final ArticleService articleService;
	
	public ArticleRest() {
		articleService = Services.getArticleService();
	}
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Article> getArticles() {
		return articleService.getArticles();
	}
	@GET
	@Path("/{articleId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Article getArticle(@PathParam("articleId") long articleId) {
		return articleService.getArticle(articleId);
	}
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Article createArticle(Article article) {
		return articleService.createArticle(article);
	}
	@PUT
	@Path("/{articleId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Article updateArticle(@PathParam("articleId") long articleId, Article article) {
		return articleService.updateArticle(articleId, article);
	}
	@DELETE
	@Path("/{articleId}")
	public void deleteArticle(@PathParam("articleId") long articleId) {
		articleService.deleteArticle(articleId);
	}
}