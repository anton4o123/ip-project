package org.elsysbg.anton.equationsolver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="Function")
@NamedQueries({
	@NamedQuery(name="allFunctions", query="Select f from Function f")
})
public class Function extends Problem {
	@Column(nullable=false)
	@Lob
	private byte[] graphics;
	
	public Function() {
		
	}
	
	public Function(long id, User user, String problem, long category) {
		super(id, user, problem, category);
	}
	
	public byte[] getGraphics() {
		return graphics;
	}

	public void setGraphics(byte[] graphics) {
		this.graphics = graphics;
	}
}