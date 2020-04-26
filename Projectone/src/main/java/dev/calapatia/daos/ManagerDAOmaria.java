package dev.calapatia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.calapatia.entities.Employee;
import dev.calapatia.entities.Manager;
import dev.calapatia.utils.ConnectionUtil;

public class ManagerDAOmaria implements ManagerDAO {

	@Override
	public Manager getManagerId(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.MANAGER WHERE MANAGER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Manager manager = new Manager();
			
			manager.setmId(rs.getInt("MANAGER_ID"));
			manager.setUsername(rs.getString("USERNAME"));
			manager.setPassword(rs.getString("PASSWORD"));
			//school.setCapacity(rs.getInt("CAPACITY"));
			
			return  manager;
		} catch (SQLException e) {
			System.out.println("No Manager with that ID");
			//e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public Manager getManagerUsername(String username) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.MANAGER WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Manager manager = new Manager();
			
			manager.setmId(rs.getInt("MANAGER_ID"));
			manager.setUsername(rs.getString("USERNAME"));
			manager.setPassword(rs.getString("PASSWORD"));
			
			
			return manager;
		} catch (SQLException e) {
			System.out.println("Cannot find employee with that username");
		//	e.printStackTrace();
		}
				
		return null;	
	}

	@Override
	public Manager getManagerPassword(String password) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.MANAGER WHERE PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Manager manager = new Manager();
			
			manager.setmId(rs.getInt("MANAGER_ID"));
			manager.setUsername(rs.getString("USERNAME"));
			manager.setPassword(rs.getString("PASSWORD"));
			
			
			return manager;
		} catch (SQLException e) {
			System.out.println("Cannot find employee with that username");
		//	e.printStackTrace();
		}
				
		return null;	
	}

	@Override
	public boolean authenticateManagerLogin(String username, String password) {
		boolean st = false;
		try (Connection conn = ConnectionUtil.createConnection()) {
			String sql = "SELECT * FROM MANAGER WHERE USERNAME = ? and PASSWORD = ? and isManager = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, username);
			ps.setObject(2, password);

			ResultSet rs = ps.executeQuery();
			
		st =	rs.next();
			
			Manager manager = new Manager();
			
			manager.setmId(rs.getInt("MANAGER_ID"));
			manager.setUsername(rs.getString("USERNAME"));
			manager.setPassword(rs.getString("PASSWORD"));
			manager.setManager(rs.getBoolean("isManager"));
			
			
		//	return employee;
			
		} catch (SQLException e) {
			System.out.println("Cannot find employee with that username");
		//	e.printStackTrace();
			return false;
		}
//		System.out.println(st);	
		System.out.println("Login Successful");
		return st;
		
		
	}
	}


