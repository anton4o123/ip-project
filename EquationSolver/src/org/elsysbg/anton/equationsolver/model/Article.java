package org.elsysbg.anton.equationsolver.model;

import java.sql.Date;

public class Article {
	private long id;
	private Date dateOfLastUpdate;
	private String title;
	private String body;
	private long category;
	public long getId() {
		return id;
	}
	public Date getDateOfCreation() {
		return dateOfLastUpdate;
	}
	public void setDateOfCreation(Date dateOfLastUpdate) {
		this.dateOfLastUpdate = dateOfLastUpdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
}