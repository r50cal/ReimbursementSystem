package dev.calapatia.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.calapatia.Service.LoginService;
//import dev.calapatia.Service.LoginServiceImpl;
import dev.calapatia.controllers.TaskController;
import dev.calapatia.entities.Employee;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DispatcherServlet() {
        // TODO Auto-generated constructor stub
    }
    
    TaskController tcontroller = new TaskController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String user = request.getParameter("username");
//		String pass = request.getParameter("password");

//		Employee employee = new Employee();
//		employee.setUsername(user);
//		employee.setPassword(pass);
//		HttpSession sess = request.getSession();
//		sess.setAttribute("username", user);
//		sess.setAttribute("password", pass);
//		LoginService ls = new LoginServiceImpl();
//		
//			RequestDispatcher rd = request.getRequestDispatcher("Homepage.html");
//			rd.forward(request,response);
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		switch(uri) {
		
		// API application program interface does not usuallay do not return HTML pages/css/js
		// They are end points that you can send and get information from (usually in JSON)
		case "/Projectone/api/reimbursements" : tcontroller.getAllReimbursement(request, response); break;
		case "/Projectone/api/addreimbursement" : tcontroller.addReimbursement(request, response); break;
		case "/Projectone/api/emreimbursement" : tcontroller.getAllReimbursementByRequesterId(request, response); break;
		case "/Projectone/api/approvereimbursement" : tcontroller.approveReimbursement(request, response); break;
		case "/Projectone/api/denyreimbursement" : tcontroller.denyReimbursement(request, response); break;

		
		default : response.getWriter().append("your request uri did not match anything");break;
		}
		
		
		
//	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
