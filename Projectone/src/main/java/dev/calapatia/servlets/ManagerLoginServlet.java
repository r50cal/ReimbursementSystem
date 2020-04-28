package dev.calapatia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.calapatia.Service.LoginService;
import dev.calapatia.Service.LoginServiceImpl;
import dev.calapatia.Service.ReimbursementService;
import dev.calapatia.Service.ReimbursementServiceImpl;

/**
 * Servlet implementation class ManagerLoginServlet
 */
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private static LoginService ls = new LoginServiceImpl();
	ReimbursementService rserv = new ReimbursementServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("user");
        String pass = request.getParameter("pass");
        PrintWriter pw = response.getWriter();
        if(ls.managerAuthentication(username, pass))
        {
//        	String username = (String) request.getSession().getAttribute("user");
//        	Employee user = ls.getEmployeeByUsername(username);
//        
//        	List<Reimbursement> reimbursements = rserv.getAllReimbursementByRequesterIdServ(user.geteId());
//        	String json = gson.toJson(reimbursements);
//        	pw.append(json);
        		 
        HttpSession session = request.getSession();
        session.setAttribute("user",username);
        response.sendRedirect("ManagerHomePage.html");
        //	 RequestDispatcher rs = request.getRequestDispatcher("Homepage.html");
          //   rs.forward(request, response);
          
        }
        else
        {
           
           response.sendRedirect("ManagerLoginPage.html");
          
        }
    	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
