package in.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.grocery.dao.ContactUsDaoImpl;
import in.grocery.pojo.ContactUs;


@WebServlet("/ContactUsController")
public class ContactUsController extends HttpServlet {
	PrintWriter out=null;
	ContactUs conobj=null;
	ContactUsDaoImpl condao=new ContactUsDaoImpl();
	boolean result=false;
	RequestDispatcher rd=null;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text,html");
		out = response.getWriter();
		String customerName = request.getParameter("name");
		String customerEmail = request.getParameter("email");
		String customerContact = request.getParameter("Contact Number");
		String customerFeedback = request.getParameter("comments");
		conobj=new ContactUs(customerName, customerEmail, customerContact, customerFeedback);
		result=condao.customerFeedback(conobj);
		if (result) {
			request.setAttribute("msg", "Message Sent");
			rd = request.getRequestDispatcher("contactus.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Message not sent");
			rd = request.getRequestDispatcher("contactus.jsp");
			rd.forward(request, response);
		}
	}

		
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
