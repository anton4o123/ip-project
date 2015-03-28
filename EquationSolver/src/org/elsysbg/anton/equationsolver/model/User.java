package org.elsysbg.anton.equationsolver.model;

public class User {
	private long id;
	private String username;
	private String password;
	private String email;
	private boolean isAdmin;
	
	public User(long id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean is_admin) {
		this.isAdmin = is_admin;
	}
}