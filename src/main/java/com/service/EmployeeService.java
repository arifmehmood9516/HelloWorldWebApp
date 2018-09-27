package com.service;


import javax.ejb.Stateless;

import com.gr.api.Employee;

/**
 * Session Bean implementation class ManagedEmployeeBean
 */
@Stateless
public class EmployeeService implements EmployeeServiceRemote {

    /**
     * Default constructor. 
     */
 
    public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean addEmployee(Employee employee) {
        return true;
    }
	
	public Employee validUser(Employee em) {
		em.setValidUser(false);
		if(em.getFirstName().equals("aarif") && em.getUserName().equals("amehmood")) {
			em.setValidUser(true);
		}
		return em;
	}
}
