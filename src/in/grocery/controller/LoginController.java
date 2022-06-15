package in.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.grocery.dao.LoginDaoImpl;



@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	PrintWriter out=null;
	String action=null;
	
	boolean result=false;
	RequestDispatcher rd=null;
	HttpSession session=null;
	LoginDaoImpl ldao=new LoginDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(false);
		session.invalidate();
		rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		session=request.getSession();
		response.setContentType("text/html");
		String email=request.getParameter("username");
		String pass=request.getParameter("userpass");
		String usert=request.getParameter("usertype");
		if(usert!=null && usert.equals("admin")){
			result=ldao.adminLogin(email, pass);
			if (result){
				//out.print("welcome admin");
				rd=request.getRequestDispatcher("index.jsp");
				session.setAttribute("usertype", "admin");
				rd.forward(request, response);	
			}
			else{
				//out.print("invalid user");
				rd=request.getRequestDispatcher("login.jsp");
				request.setAttribute("msg", "Invalid user!!!please enter username or password correct");
				rd.forward(request, response);	
			}
				
			
		}
		if(usert!=null && usert.equals("customer")){
			result=ldao.customerLogin(email, pass);
			if (result){
				rd=request.getRequestDispatcher("index.jsp");
				session.setAttribute("customer", email);
				rd.forward(request, response);	
			}
			else
			{
				rd=request.getRequestDispatcher("login.jsp");
				request.setAttribute("msg", "Invalid user!!!please enter username or password correct");
				rd.forward(request, response);	
			}
		}
		
}

}
