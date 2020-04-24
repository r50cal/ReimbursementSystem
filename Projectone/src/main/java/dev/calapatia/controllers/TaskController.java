package dev.calapatia.controllers;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.calapatia.Service.LoginService;
import dev.calapatia.Service.LoginServiceImpl;
//import dev.calapatia.Service.LoginServiceImpl;
import dev.calapatia.Service.ReimbursementService;
import dev.calapatia.Service.ReimbursementServiceImpl;
import dev.calapatia.entities.Employee;
import dev.calapatia.entities.Reimbursement;



public class TaskController {
	
LoginService lserv = new LoginServiceImpl();
	ReimbursementService rserv = new ReimbursementServiceImpl();
	
	public void getAllReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		List<Reimbursement> tasks = rserv.getAllReimbursement();	
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(tasks);
		pw.append(json);
		
	}
	
	public void getAllReimbursementByRequesterId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
PrintWriter pw;
pw = response.getWriter();
String username = (String) request.getSession().getAttribute("user");
Employee user = lserv.getEmployeeByUsername(username);

List<Reimbursement> reimbursements = rserv.getAllReimbursementByRequesterIdServ(user.geteId());
String json = gson.toJson(reimbursements);
pw.append(json);
		
	}
//	
//	// when you add information you want to send it in the body
//	// therefore it is a post request
	public void addReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
	Gson gson = new Gson();
Reimbursement task = gson.fromJson(body, Reimbursement.class);
rserv.submitReimbursement(task);
response.getWriter().append("Success!!!!");
}

//		
//	public void pendingTasks(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Gson gson = new Gson();
//		String json = gson.toJson(tserv.retrievePendingTasks());
//		response.getWriter().append(json);		
//	}
//	
//	
//	public void completedTasks(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Gson gson = new Gson();
//		String json = gson.toJson(tserv.retrieveCompletedTasks());
//		response.getWriter().append(json);
//	}
//	
	public void approveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Reimbursement reimbursement = gson.fromJson(json, Reimbursement.class);
		rserv.approveReimbursement(reimbursement);
		System.out.println(reimbursement);
		response.getWriter().append("Successfully updated Task!!!!");
	}
	
	public void denyReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Reimbursement reimbursement = gson.fromJson(json, Reimbursement.class);
		rserv.approveReimbursement(reimbursement);
		System.out.println(reimbursement);
		response.getWriter().append("Successfully updated Task!!!!");
	}
//
//	public void authenticateSession(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//	}

}