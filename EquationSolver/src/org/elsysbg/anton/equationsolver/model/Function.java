package org.elsysbg.anton.equationsolver.model;

import java.sql.Date;
import java.sql.Blob;

public class Function extends Problem {
	private Blob graphics;
	
	public Function(long id, User user, Date dateOfCreation, String problem, long category) {
		super(id, user, dateOfCreation, problem, category);
	}
	
	public Blob getGraphics() {
		return graphics;
	}

	public void setGraphics(Blob graphics) {
		this.graphics = graphics;
	}
}