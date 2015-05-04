package org.elsysbg.anton.equationsolver.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="Article")
@NamedQueries({
	@NamedQuery(name="allArticle", query="Select a from Article a")
})
public class Article {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private Date dateOfLastUpdate;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Column(nullable=false, length=10000)
	private String body;
	
	@Column(nullable=false)
	private long category;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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