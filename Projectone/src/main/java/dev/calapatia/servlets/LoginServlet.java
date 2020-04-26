package dev.calapatia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.calapatia.Service.LoginService;
import dev.calapatia.Service.LoginServiceImpl;
import dev.calapatia.Service.ReimbursementService;
import dev.calapatia.Service.ReimbursementServiceImpl;
import dev.calapatia.daos.EmployeeDAO;
import dev.calapatia.daos.ReimbursementDAO;
import dev.calapatia.daos.ReimbursementDAOmaria;
import dev.calapatia.entities.Employee;
import dev.calapatia.entities.Reimbursement;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    private static LoginService ls = new LoginServiceImpl();
	ReimbursementService rserv = new ReimbursementServiceImpl();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Gson gson = new Gson();
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("user");
        String pass = request.getParameter("pass");
        PrintWriter pw = response.getWriter();
        if(ls.authentication(username, pass))
        {
     
        		 
        HttpSession session = request.getSession();
        session.setAttribute("user",username);
        response.sendRedirect("Homepage.html");
        //	 RequestDispatcher rs = request.getRequestDispatcher("Homepage.html");
          //   rs.forward(request, response);
          
        }
        else
        {
           
           response.sendRedirect("index.html");
          
        }
    	
	}

}
