package dev.calapatia.Service;

import java.util.List;

import dev.calapatia.entities.Reimbursement;

public interface ReimbursementService {
	public Reimbursement getrId(int rid);
	public Reimbursement submitReimbursement(Reimbursement reimbursement);
	public Reimbursement approveReimbursement(Reimbursement reimbursement);
	public Reimbursement denyReimbursement(Reimbursement reimbursement);
	public List<Reimbursement> getAllReimbursement();
	public List<Reimbursement> getAllReimbursementByRequesterIdServ(int id);
	public List<Reimbursement> getAllReimbursementByStatus(String status);

}
