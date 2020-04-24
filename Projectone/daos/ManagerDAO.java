package dev.calapatia.daos;

import dev.calapatia.entities.Manager;

public interface ManagerDAO {
	
	Manager getManagerId(int id);
	Manager getManagerUsername(String username);
	Manager getManagerPassword(String password);

}
