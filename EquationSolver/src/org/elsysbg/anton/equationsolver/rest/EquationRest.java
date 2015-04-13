package org.elsysbg.anton.equationsolver.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.elsysbg.anton.equationsolver.Services;
import org.elsysbg.anton.equationsolver.model.Equation;
import org.elsysbg.anton.equationsolver.service.EquationService;

@Path("equation")
public class EquationRest {
	private final EquationService equationService;
	
	public EquationRest() {
		equationService = Services.getEquationService();
	}
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Equation> getEquations() {
		return equationService.getEquations();
	}
	@GET
	@Path("/{equationId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Equation getEquation(@PathParam("equationId") long equationId) {
		return equationService.getEquation(equationId);
	}
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Equation createEquation(Equation equation) {
		return equationService.createEquation(equation);
	}
	@DELETE
	@Path("/{equationId}")
	public void deleteEquation(@PathParam("equationId") long equationId) {
		equationService.deleteEquation(equationId);
	}
}