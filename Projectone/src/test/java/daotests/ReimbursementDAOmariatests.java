package daotests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.calapatia.daos.ReimbursementDAO;
import dev.calapatia.daos.ReimbursementDAOmaria;
import dev.calapatia.entities.Reimbursement;



public class ReimbursementDAOmariatests {

	public static ReimbursementDAO rdao = new ReimbursementDAOmaria();
	
	@Test
	public void createReimbursement() {
		Reimbursement newReimbursement = new Reimbursement();
		newReimbursement.setrId(1);
		newReimbursement.setAmount(1);
		newReimbursement.setDescription("Samurai HEart");
		newReimbursement.setRequesterId(3);
		newReimbursement.setStatus("sleepy");
		rdao.createReimbursement(newReimbursement);
		System.out.println(newReimbursement);
	}
	
	
	@Test
	public void getReimbursementId() {
		Reimbursement reimbursement = rdao.getReimbursementId(1);
		System.out.println(reimbursement);
	}
	
	@Test
	public void getAmount() {
		Reimbursement reimbursement = rdao.getAmount(245);
		System.out.println(reimbursement);
	}
	
	@Test
	public void getDescription() {
		Reimbursement reimbursement = rdao.getDescription("Java SE 8 Programmer I");
		System.out.println(reimbursement);
	}
	
	@Test
	public void getrequesterId() {
		Reimbursement reimbursement = rdao.getRequesterId(3);
		System.out.println(reimbursement);
	}
	
	@Test
	public void getStatus() {
		Reimbursement reimbursements =  rdao.getStatus("NOWI");		
		System.out.println(reimbursements);
	}
	
	@Test
	public void getUpdateByReimbursement() {
		Reimbursement test = rdao.getReimbursementId(4);
		test.setStatus("jikan");
		rdao.updateStatus(test);
		System.out.println(test);
	}
	
	@Test
	public void getAllReimbursementById() {
		List<Reimbursement> reimbursement = rdao.getAllReimbursementByRequesterId(1);
		System.out.println(reimbursement);
	}
	@Test
	public void getAllReimbursement() {
		List<Reimbursement> accounts = rdao.getAllReimbursement();
		System.out.println(accounts);
	}

}
