package dev.calapatia.servicetests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.calapatia.Service.LoginService;
import dev.calapatia.Service.LoginServiceImpl;
import dev.calapatia.Service.ReimbursementService;
import dev.calapatia.Service.ReimbursementServiceImpl;
import dev.calapatia.daos.EmployeeDAO;
import dev.calapatia.entities.Employee;

public class LoginServicetests {
	private static LoginService ls = new LoginServiceImpl();
	
	@Test
	public void test() {
	String username = "MiddleSister";
	String password = "Headphones";
	ls.authentication(username,password);
	}
	
	@Test
	public void test2() {
	//String username = "MiddleSister";
	//String password = "Headphones";
	//ls.getEmployeeByUsername("MiddleSister");
	System.out.println(ls.getEmployeeByUsername("MiddleSister"));
	}
	
	@Test
	public void testManagerAuth() {
	String username = "Karen";
	String password = "admin";
	ls.managerAuthentication(username,password);
	}
	

}
