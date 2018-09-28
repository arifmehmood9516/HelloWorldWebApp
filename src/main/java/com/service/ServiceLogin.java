package com.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.qr.repository.entity.Account;
import com.qr.repository.entity.Address;
import com.qr.repository.entity.AlertProfile;
import com.qr.repository.entity.Contact;
import com.service.ServiceManager;

@Path("/javalogin")
public class ServiceLogin {
	
	@GET
    @Path("/helloworld")
    public Response getHelloWorld() {
        String value = "Hello World";
        return Response.status(200).entity(value).build();
    }
    
    
    @POST
    @Path("/addaccount")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Account addAccount(Account account) {
    	AccountServiceRemote br = (AccountServiceRemote ) ServiceManager.jndiLookup(AccountService.class);
    	account = br.addAccount(account);
    	return account;
    }
    
    
    @POST
    @Path("/deleteaccount")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAccount(Account account) {
    	AccountServiceRemote br = (AccountServiceRemote ) ServiceManager.jndiLookup(AccountService.class);
    	Boolean resp = br.deleteAccount(account);
    	return Response.status(200).entity(resp.toString()).build();
    }
    
    
    @POST
    @Path("/addcontact")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContact(Contact contact) {
    	ContactServiceRemote br = (ContactServiceRemote ) ServiceManager.jndiLookup(ContactService.class);
    	String message= "Your Address Matches Alert Profile "+ br.addContact(contact);
    	return Response.ok().entity(message).build();
    }
    
    @POST
    @Path("/deletecontact")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteContact(Contact contact) {
    	ContactServiceRemote br = (ContactServiceRemote ) ServiceManager.jndiLookup(ContactService.class);
    	Boolean resp =br.deleteContact(contact);
    	return Response.status(200).entity(resp.toString()).build();
    }
    
    
    
    @POST
    @Path("/addprofile")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response addProfile(AlertProfile alertprofile) {
    	AlertProfileServiceRemote br = (AlertProfileServiceRemote) ServiceManager.jndiLookup(AlertProfileService.class);
    	alertprofile = br.addAlertProfile(alertprofile);
    	return Response.ok().entity(Boolean.TRUE).build();
    }
    
    @POST
    @Path("/addaddress")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAddress(Address address) {
    	AddressServiceRemote br = (AddressServiceRemote ) ServiceManager.jndiLookup(AddressService.class);
    	AlertProfile alertprofile = br.addAddress(address);
    	String message= "Your Address Matches Alert Profile "+alertprofile.getName();
    	if(!alertprofile.equals(null))
    		return Response.status(200).entity(message).build();
    	else
    		return null;
    }
    
}
