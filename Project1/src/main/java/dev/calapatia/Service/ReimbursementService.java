package dev.calapatia.Service;

import dev.calapatia.entities.Reimbursement;

public interface ReimbursementService {
	public Reimbursement submitReimbursement(Reimbursement reimbursement);
	public Reimbursement approveReimbursement(Reimbursement reimbursement);
	public Reimbursement denyReimbursement(Reimbursement reimbursement);

}
