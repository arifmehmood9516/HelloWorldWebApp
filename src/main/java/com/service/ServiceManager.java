package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;


public class ServiceManager {
	
/*	public static EmployeeServiceRemote lookupJNDI() {
		try {
		InitialContext ctx = new InitialContext();
		 EmployeeServiceRemote br = (EmployeeServiceRemote) ctx.lookup("java:global/HelloWorldWebApp/EmployeeService!com.service.EmployeeServiceRemote");
		 return br;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static EmployeeServiceRemote lookupJNDI(String jndi) {
		try {
		InitialContext ctx = new InitialContext();
		 EmployeeServiceRemote br = (EmployeeServiceRemote) ctx.lookup(jndi);
		 return br;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}*/
	
	public static List<String> toMap(Context ctx) throws NamingException {
	    String namespace = "java:global/HelloWorldWebApp/";
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    List<String> names = new ArrayList<String>();
	    //System.out.println("> Listing namespace: " + namespace);
	    NamingEnumeration<NameClassPair> list = ctx.list("java:global/HelloWorldWebApp/");
	    while (list.hasMoreElements()) {
	        NameClassPair next = list.next();
	        String name = next.getName();
	        String jndiPath = namespace + name;
	        names.add(name);
	        Object lookup;
	        try {
	        	 //System.out.println("> Looking up name: " + jndiPath);
	            Object tmp = ctx.lookup(jndiPath);
	            if (tmp instanceof Context) {
	                lookup = toMap((Context) tmp);
	            } else {
	                lookup = tmp.toString();
	            }
	        } catch (Throwable t) {
	            lookup = t.getMessage();
	        }
	        map.put(jndiPath, lookup);
	    }
	    return names;
	}
	
	
	public static Object jndiLookup(Class ejbJndi )
	{
		try {
		InitialContext ctx = new InitialContext();
		List<String> list=toMap(ctx);
		int lp=list.indexOf(ejbJndi.getSimpleName());
		//System.out.println(list.toString());
		String loup="java:global/HelloWorldWebApp/"+list.get(lp+1);
		Object lpObj= ctx.lookup(loup);
		return lpObj;
		}
		catch(Exception e){
			System.out.println(e.getStackTrace().toString());
			return null;
		}
	}
	
	
	/*public static AccountServiceRemote lookupAccountJNDI() {
		try {
		 AccountServiceRemote br =  (AccountServiceRemote) jndiLookup("AccountService");
				 return br;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static AlertProfileServiceRemote lookupAlertProfileJNDI() {
		try {
		InitialContext ctx = new InitialContext();
		AlertProfileServiceRemote br = (AlertProfileServiceRemote) ctx.lookup("java:global/HelloWorldWebApp/AlertProfileService!com.service.AlertProfileServiceRemote");
		 return br;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static AddressServiceRemote lookupAddressJNDI() {
		try {
		InitialContext ctx = new InitialContext();
		AddressServiceRemote br = (AddressServiceRemote) ctx.lookup("java:global/HelloWorldWebApp/AddressService!com.service.AddressServiceRemote");
		 return br;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}*/
}
