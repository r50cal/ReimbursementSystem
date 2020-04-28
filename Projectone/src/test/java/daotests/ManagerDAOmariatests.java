package daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.calapatia.daos.ManagerDAO;
import dev.calapatia.daos.ManagerDAOmaria;
import dev.calapatia.entities.Manager;




public class ManagerDAOmariatests {
	
	public static ManagerDAO mdao = new ManagerDAOmaria();

	@Test
	public void getManagerById() {
		Manager manager = mdao.getManagerId(3);
		System.out.println(manager);
	}
	
	@Test
	public void getManagerUsername() {
		Manager manager = mdao.getManagerUsername("Karen");
		System.out.println(manager);
	}
	
	@Test
	public void getManagerPassword() {
		Manager manager = mdao.getManagerPassword("Meow");
		System.out.println(manager);
	}
	
	@Test
	public void authenticateManager() {
		String username = "K5aren";
		String password = "admin";
		boolean authentication = mdao.authenticateManagerLogin(username,password);
	}

}
