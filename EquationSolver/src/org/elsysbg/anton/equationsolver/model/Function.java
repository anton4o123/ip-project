package org.elsysbg.anton.equationsolver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="Func")
@NamedQueries({
	@NamedQuery(name="allFunctions", query="Select f from Func f")
})
public class Function extends Problem {
	
	@Lob
	@Column(nullable=false, length=1024*1024*20)
	private String graphics;
	
	public Function() {
		
	}
	
	public Function(long id, User user, String problem, long category) {
		super(id, user, problem, category);
	}
	
	public String getGraphics() {
		return graphics;
	}

	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}
}