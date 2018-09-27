package com.gr.service;

import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gr.HelloWOrld.Employee;
import com.service.EmployeeServiceRemote;


@Path("/javalogin")
public class ServiceLogin {
	
	@POST
	@Path("/validate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee validUser(Employee em) {
		
		InitialContext ctx = new InitialContext();
		 EmployeeServiceRemote br = (EmployeeServiceRemote) ctx.lookup("Bean30");
		 return br.validUser(em);
	}
	
	@GET
    @Path("/helloworld")
    public Response getHelloWorld() {
        String value = "Hello World";
        return Response.status(200).entity(value).build();
    }
    
    @GET
    @Path("")
    public Response get() {
        String value = "Hello World";
        return Response.status(200).entity(value).build();
    }
	
}
