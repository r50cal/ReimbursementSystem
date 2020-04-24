package dev.calapatia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dev.calapatia.entities.Employee;
import dev.calapatia.utils.ConnectionUtil;

public class EmployeeDAOmaria implements EmployeeDAO {

	public Employee getEmployeeId(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Employee employee = new Employee();
			
			employee.seteId(rs.getInt("EMPLOYEE_ID"));
			employee.setName(rs.getString("NAME"));
			employee.setUsername(rs.getString("USERNAME"));
			employee.setPassword(rs.getString("PASSWORD"));
			//school.setCapacity(rs.getInt("CAPACITY"));
			
			return  employee;
		} catch (SQLException e) {
			System.out.println("No employee with that ID");
		//	e.printStackTrace();
		}
				
		return null;
	}

	public Employee getEmployeeName(String name) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.EMPLOYEE WHERE NAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Employee employee = new Employee();
			
			employee.seteId(rs.getInt("EMPLOYEE_ID"));
			employee.setName(rs.getString("NAME"));
			employee.setUsername(rs.getString("USERNAME"));
			employee.setPassword(rs.getString("PASSWORD"));
			
			
			return employee;
		} catch (SQLException e) {
			System.out.println("Cannot find employee with that name");
		//	e.printStackTrace();
		}
				
		return null;	
	}

	public Employee getEmployeeUserName(String username) {

		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.EMPLOYEE WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Employee employee = new Employee();
			
			employee.seteId(rs.getInt("EMPLOYEE_ID"));
			employee.setName(rs.getString("NAME"));
			employee.setUsername(rs.getString("USERNAME"));
			employee.setPassword(rs.getString("PASSWORD"));
			
			
			return employee;
		} catch (SQLException e) {
			System.out.println("Cannot find employee with that username");
		//	e.printStackTrace();
		}
				
		return null;	
	}

	public Employee getEmployeePassword(String password) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.EMPLOYEE WHERE PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Employee employee = new Employee();
			
			employee.seteId(rs.getInt("EMPLOYEE_ID"));
			employee.setName(rs.getString("NAME"));
			employee.setUsername(rs.getString("USERNAME"));
			employee.setPassword(rs.getString("PASSWORD"));
			
			
			return employee;
		} catch (SQLException e) {
			System.out.println("wrong password");
		//	e.printStackTrace();
		}
				
		return null;	
	}



	public boolean authenticateEmployeeLogin(String username, String password) {
		boolean st = false;
		try (Connection conn = ConnectionUtil.createConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? and PASSWORD = ? and isManager = 0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, username);
			ps.setObject(2, password);

			ResultSet rs = ps.executeQuery();
			
		st =	rs.next();
			
			Employee employee = new Employee();
			
			employee.seteId(rs.getInt("EMPLOYEE_ID"));
			employee.setName(rs.getString("NAME"));
			employee.setUsername(rs.getString("USERNAME"));
			employee.setPassword(rs.getString("PASSWORD"));
			employee.setManager(rs.getBoolean("isManager"));
			
			
		//	return employee;
			
		} catch (SQLException e) {
			System.out.println("Cannot find employee with that username");
		//	e.printStackTrace();
			return (Boolean) null;
		}
//		System.out.println(st);	
		System.out.println("Login Successful");
		return st;
		
		
	}



}
