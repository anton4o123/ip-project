package org.elsysbg.anton.equationsolver.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="Function")
@NamedQueries({
	@NamedQuery(name="allFunctions", query="Select f from Article f")
})
public class Function extends Problem {
	@Column(nullable=false)
	private Blob graphics;
	
	public Function(long id, User user, String problem, long category) {
		super(id, user, problem, category);
	}
	
	public Blob getGraphics() {
		return graphics;
	}

	public void setGraphics(Blob graphics) {
		this.graphics = graphics;
	}
}