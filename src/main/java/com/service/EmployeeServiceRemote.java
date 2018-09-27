package com.service;

import javax.ejb.Remote;

import com.gr.api.Employee;

@Remote
public interface EmployeeServiceRemote {
	  public boolean addEmployee(Employee employee);
	  public Employee validUser(Employee em);
	  
}
