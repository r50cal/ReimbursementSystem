package dev.calapatia.Service;

import java.util.List;

import dev.calapatia.daos.ReimbursementDAO;
import dev.calapatia.daos.ReimbursementDAOmaria;
import dev.calapatia.entities.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	private ReimbursementDAO rdao = new ReimbursementDAOmaria();

	@Override
	public Reimbursement submitReimbursement(Reimbursement reimbursement) {
	
		this.rdao.createReimbursement(reimbursement);
		return reimbursement;
	}

	@Override
	public Reimbursement approveReimbursement(Reimbursement reimbursement) {
	
		reimbursement.setStatus("APPROVED");
		reimbursement.setrId(reimbursement.getrId());
		
		this.rdao.updateStatus(reimbursement);
		return reimbursement;
	}

	@Override
	public Reimbursement denyReimbursement(Reimbursement reimbursement) {
		reimbursement.setStatus("DENIED");
		reimbursement.setrId(reimbursement.getrId());
		
		this.rdao.updateStatus(reimbursement);
		return reimbursement;
	}

	@Override
	public  List<Reimbursement> getAllReimbursement() {
		System.out.println(rdao.getAllReimbursement());
		return rdao.getAllReimbursement();
		
		
		
	}

	

	@Override
	public List<Reimbursement> getAllReimbursementByRequesterIdServ(int id) {
	
		List <Reimbursement> accounts = rdao.getAllReimbursementByRequesterId(id);
		System.out.println(accounts);
		return accounts;
	}

	@Override
	public Reimbursement getrId(int rid) {
		// TODO Auto-generated method stub
		
		System.out.println(rdao.getReimbursementId(rid));
		return rdao.getReimbursementId(rid);
	}





}
