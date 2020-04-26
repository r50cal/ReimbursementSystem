package dev.calapatia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.calapatia.entities.Employee;
import dev.calapatia.utils.ConnectionUtil;

public interface EmployeeDAO {
	
	Employee getEmployeeId(int id);
	
	Employee getEmployeeName(String name);
	
	Employee getEmployeeUserName(String username);
	
	Employee getEmployeePassword(String password);

	 boolean authenticateEmployeeLogin(String string, String string2);

	

}
