package dev.calapatia.Service;

import dev.calapatia.entities.Employee;

public interface LoginService {
	

	

	boolean authentication(String username, String password);
	
	boolean managerAuthentication(String username, String password);

	

	Employee getEmployeeByUsername(String username);

	//Employee getEmployeeByUsername(String username);




}
