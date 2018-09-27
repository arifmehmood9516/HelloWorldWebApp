package com.gr.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {

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