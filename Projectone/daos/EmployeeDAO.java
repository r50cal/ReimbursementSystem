package dev.calapatia.daos;

import java.util.List;

import dev.calapatia.entities.Employee;

public interface EmployeeDAO {
	
	Employee getEmployeeId(int id);
	
	Employee getEmployeeName(String name);
	
	Employee getEmployeeUserName(String username);
	
	Employee getEmployeePassword(String password);

	Employee authenticateEmployeeLogin(String string, String string2);

}
