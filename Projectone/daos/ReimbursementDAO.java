package dev.calapatia.daos;

import java.util.List;

import dev.calapatia.entities.Reimbursement;


// int rId, int amount, String description, int requesterId, String status
public interface ReimbursementDAO {

	Reimbursement createReimbursement(Reimbursement reimbursement);
	Reimbursement getReimbursementId(int rId);
	Reimbursement getAmount(int amount);
	Reimbursement getDescription(String description);
	Reimbursement getRequesterId(int requesterId);
	Reimbursement getStatus(String status);
	Reimbursement updateStatus(Reimbursement updateStatus);
	List<Reimbursement> getAllReimbursement();
	List<Reimbursement> getAllReimbursementByRequesterId(int id);
	
}
