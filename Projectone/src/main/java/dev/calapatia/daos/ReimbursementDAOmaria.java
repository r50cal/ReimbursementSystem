package dev.calapatia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.calapatia.entities.Reimbursement;
import dev.calapatia.utils.ConnectionUtil;


public class ReimbursementDAOmaria implements ReimbursementDAO {
	
	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO Project1draft.REIMBURSEMENT VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setInt(2, reimbursement.getAmount());
			ps.setString(3, reimbursement.getDescription());
			ps.setInt(4, reimbursement.getRequesterId());
			ps.setString(5, reimbursement.getStatus());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();// gets first record
			
			int key = rs.getInt("REIMBURSEMENT_ID");
			reimbursement.setrId(key);
			return reimbursement;		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public Reimbursement getReimbursementId(int rId) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rId);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Reimbursement reimbursement = new Reimbursement();
			
			reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
			reimbursement.setAmount(rs.getInt("AMOUNT"));
			reimbursement.setDescription(rs.getString("DESCRIPTION"));
			reimbursement.setRequesterId(rs.getInt("REQUESTER_ID"));
			reimbursement.setStatus(rs.getString("STATUS"));
			
			return  reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public Reimbursement getAmount(int amount) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.REIMBURSEMENT WHERE AMOUNT = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, amount);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Reimbursement reimbursement = new Reimbursement();
			
			reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
			reimbursement.setAmount(rs.getInt("AMOUNT"));
			reimbursement.setDescription(rs.getString("DESCRIPTION"));
			reimbursement.setRequesterId(rs.getInt("REQUESTER_ID"));
			reimbursement.setStatus(rs.getString("STATUS"));
			
			return  reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public Reimbursement getDescription(String description) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.REIMBURSEMENT WHERE DESCRIPTION = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, description);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Reimbursement reimbursement = new Reimbursement();
			
			reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
			reimbursement.setAmount(rs.getInt("AMOUNT"));
			reimbursement.setDescription(rs.getString("DESCRIPTION"));
			reimbursement.setRequesterId(rs.getInt("REQUESTER_ID"));
			reimbursement.setStatus(rs.getString("STATUS"));
			
			return  reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public Reimbursement getRequesterId(int requesterId) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.REIMBURSEMENT WHERE REQUESTER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, requesterId);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Reimbursement reimbursement = new Reimbursement();
			
			reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
			reimbursement.setAmount(rs.getInt("AMOUNT"));
			reimbursement.setDescription(rs.getString("DESCRIPTION"));
			reimbursement.setRequesterId(rs.getInt("REQUESTER_ID"));
			reimbursement.setStatus(rs.getString("STATUS"));
			
			return  reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}
	

	@Override
	public Reimbursement getStatus(String status) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);

			ResultSet rs = ps.executeQuery();
			
			rs.next();
				
				Reimbursement reimbursement = new Reimbursement();
				
				reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
				reimbursement.setAmount(rs.getInt("AMOUNT"));
				reimbursement.setDescription(rs.getString("DESCRIPTION"));
				reimbursement.setRequesterId(rs.getInt("REQUESTER_ID"));
				reimbursement.setStatus(rs.getString("STATUS"));
				
			
			
			return reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Reimbursement updateStatus(Reimbursement updateStatus) {
try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE Project1draft.REIMBURSEMENT  SET STATUS = ? WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, updateStatus.getStatus());
			ps.setInt(2, updateStatus.getrId());
			ps.executeUpdate();
		//	System.out.println("Right" + updateStatus);
			
			return updateStatus;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	



	@Override
	public List<Reimbursement> getAllReimbursement() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Project1draft.REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> accounts = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				
				Reimbursement allReimbursement = new Reimbursement();			
				allReimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
				allReimbursement.setAmount(rs.getInt("AMOUNT"));
				allReimbursement.setDescription(rs.getString("DESCRIPTION"));
				allReimbursement.setRequesterId(rs.getInt("REQUESTER_ID"));
				allReimbursement.setStatus(rs.getString("STATUS"));
				accounts.add(allReimbursement);
				
			}
			
			return accounts;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Reimbursement> getAllReimbursementByRequesterId(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REQUESTER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> accounts = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
				reimbursement.setAmount(rs.getInt("AMOUNT"));
				reimbursement.setDescription(rs.getString("DESCRIPTION"));
				reimbursement.setRequesterId(rs.getInt("REQUESTER_ID"));
				reimbursement.setStatus(rs.getString("STATUS"));
				accounts.add(reimbursement);
			}
			
			return accounts;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	
	@Override
	public List<Reimbursement> getAllReimbursementByStatus(String status) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1, status);

			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> accounts = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
				reimbursement.setAmount(rs.getInt("AMOUNT"));
				reimbursement.setDescription(rs.getString("DESCRIPTION"));
				reimbursement.setRequesterId(rs.getInt("REQUESTER_ID"));
				reimbursement.setStatus(rs.getString("STATUS"));
				accounts.add(reimbursement);
			}
			
			return accounts;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	



}
