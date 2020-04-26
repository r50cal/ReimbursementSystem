package dev.calapatia.Service;

import dev.calapatia.daos.EmployeeDAO;
import dev.calapatia.daos.EmployeeDAOmaria;
import dev.calapatia.daos.ManagerDAO;
import dev.calapatia.daos.ManagerDAOmaria;
import dev.calapatia.daos.ReimbursementDAO;
import dev.calapatia.daos.ReimbursementDAOmaria;
import dev.calapatia.entities.Employee;

public class LoginServiceImpl implements LoginService {
	private EmployeeDAO edao = new EmployeeDAOmaria();
	private ManagerDAO mdao = new ManagerDAOmaria();

//	@Override
//	public Employee authentication(Employee credentials) {
//		credentials.setUsername(credentials.getUsername());
//		credentials.setPassword(credentials.getPassword());
//	//credentials.authentication();
//	//	this.edao.authenticateEmployeeLogin(credentials.getUsername(),credentials.getPassword());
//		System.out.println(this.edao.authenticateEmployeeLogin(credentials.getUsername(),credentials.getPassword()).toString());
//		return this.edao.authenticateEmployeeLogin(credentials.getUsername(),credentials.getPassword().toString());
//	}

	@Override
	public boolean authentication(String username, String password) {
	//	edao.authenticateEmployeeLogin(username,password);
		return edao.authenticateEmployeeLogin(username,password);
	}

//	@Override
//	public Employee getEmployeeByUsername(String username) {
//		// TODO Auto-generated method stub
//		return edao.getEmployeeUserName(username);
//	}
@Override
public Employee getEmployeeByUsername(String username) {
	return edao.getEmployeeUserName(username);
}

@Override
public boolean managerAuthentication(String username, String password) {
	return mdao.authenticateManagerLogin(username,password);
}










}
