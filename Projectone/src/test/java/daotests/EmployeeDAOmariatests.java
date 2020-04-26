package daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.calapatia.daos.EmployeeDAO;
import dev.calapatia.daos.EmployeeDAOmaria;
import dev.calapatia.entities.Employee;




public class EmployeeDAOmariatests {
	
	public static EmployeeDAO edao = new EmployeeDAOmaria();

	@Test
	public void getEmployeeId() {
		Employee employee = edao.getEmployeeId(1);
		System.out.println(employee);
	}
	
	@Test
	public void getEmployeeByName() {
		Employee employee = edao.getEmployeeName("Ichika Nakano");
		System.out.println(employee);
	}
	
	@Test
	public void getEmployeeByUser() {
		Employee employee = edao.getEmployeeUserName("Oneesan");
		System.out.println(employee);
	}
	
	@Test
	public void getPassword() {
		Employee password = edao.getEmployeePassword("Oldest Sister");
		System.out.println(password);
	}
	
	@Test
	public void something() {
		String username = "d";
		String password = "Butterflies";
		boolean authentication = edao.authenticateEmployeeLogin(username,password);
	}

}
