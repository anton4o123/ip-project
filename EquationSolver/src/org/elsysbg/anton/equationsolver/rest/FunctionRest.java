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
import org.elsysbg.anton.equationsolver.model.Function;
import org.elsysbg.anton.equationsolver.service.FunctionService;

@Path("function")
public class FunctionRest {
	private final FunctionService functionService;
	
	public FunctionRest() {
		functionService = Services.getFunctionService();
	}
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Function> getEquations() {
		return functionService.getFunctions();
	}
	@GET
	@Path("/{functionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Function getEquation(@PathParam("functionId") long functionId) {
		return functionService.getFunction(functionId);
	}
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Function createEquation(Function equation) {
		return functionService.createFunction(equation);
	}
	@DELETE
	@Path("/{functionId}")
	public void deleteEquation(@PathParam("functionId") long functionId) {
		functionService.deleteFunction(functionId);
	}
}