package dev.calapatia.servicetests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.calapatia.Service.ReimbursementService;
import dev.calapatia.Service.ReimbursementServiceImpl;
import dev.calapatia.daos.ReimbursementDAO;
import dev.calapatia.daos.ReimbursementDAOmaria;
import dev.calapatia.entities.Reimbursement;


public class ReimbursementSerivcetests {

	private static ReimbursementService rs = new ReimbursementServiceImpl();
	
	@Test
	public void submitReimbursement1() {
		Reimbursement submit = new Reimbursement();
		submit.setrId(15);
		submit.setAmount(90);
		submit.setDescription("sql error");
		submit.setRequesterId(2);
		submit.setStatus("Nah");
		rs.submitReimbursement(submit);
		rs.getAllReimbursement();
	}
	
	@Test
	public void approvedReimbursement1() {
		Reimbursement submit = new Reimbursement();
		submit.setStatus("MEOW");
		submit.setrId(5);
		rs.approveReimbursement(submit);
		
		
	}
	@Test
	public void denyReimbursement() {
		Reimbursement submit = new Reimbursement();
		submit.setStatus("MEOW");
		submit.setrId(14);
		rs.denyReimbursement(submit);
		
		
	}
	
	@Test
	public void getAllReimbursementsbyreqId() {
	//	Reimbursement ciao = new Reimbursement();
		//ciao.setRequesterId(3);
	rs.getAllReimbursementByRequesterIdServ(3);
//		
	}
	@Test
	public void getAllReimbursements() {
		
	rs.getAllReimbursement();
//		
//		
	}
	
	@Test
	public void meh() {
		
	rs.getrId(3);
//		
//		


}
}
