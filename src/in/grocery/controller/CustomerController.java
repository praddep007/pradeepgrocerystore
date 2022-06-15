package in.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.grocery.dao.CustomerDaoImpl;
import in.grocery.pojo.Customer;
import in.grocery.pojo.Product;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {

	PrintWriter out = null;
	boolean result = false;
	String action = null;
	Customer custobj=null;
	CustomerDaoImpl cdao = new CustomerDaoImpl();
	RequestDispatcher rd = null;
	HttpSession session=null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		if(action!=null && action.equals("delete")) {
			
			int customerid=Integer.parseInt(request.getParameter("cid"));
			System.out.println(customerid);
			result=cdao.deleteCustomer(customerid);
			if(result) {
				request.setAttribute("msg", "customer deleted");
				List<Customer> customerlist=cdao.showCustomerList();
				session.setAttribute("clist", customerlist);
				rd=request.getRequestDispatcher("showcustomerlist.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "customer not deleted");
				List<Customer> customerlist=cdao.showCustomerList();
				session.setAttribute("clist", customerlist);
				rd=request.getRequestDispatcher("showcustomerlist.jsp");
				rd.forward(request, response);
			}
		}
		if(action!=null && action.equals("edit")) {
			int custId = Integer.parseInt(request.getParameter("cid"));
			custobj=cdao.searchCustomerById(custId);
			System.out.println(custobj);
			session.setAttribute("ucustomer", custobj);
			response.sendRedirect("updatecustomer.jsp");
			
		}
		else {
		List<Customer>customerlist=cdao.showCustomerList();
	    System.out.println("customerlist:" +customerlist);
		session=request.getSession();
		if(customerlist!=null) {
			session.setAttribute("clist", customerlist);
			rd=request.getRequestDispatcher("showcustomerlist.jsp");
			rd.forward(request, response);
			//response.sendRedirect("showproductlist.jsp");

	  }
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// add
		response.setContentType("text/html");
		out = response.getWriter();
		action = request.getParameter("action");
		if (action != null && action.equals("addcustomer")) {
			String customerName = request.getParameter("customername");
			String customerEmail = request.getParameter("customeremail");
			String customerPassword = request.getParameter("customerpass");
			String customerConfirmPassword = request.getParameter("customerconfirmpass");
			String customerContact = request.getParameter("customercontact");
			String customerAddress = request.getParameter("customeraddress");
			if(customerPassword!=null && customerPassword.equals(customerConfirmPassword)) {
			custobj = new  Customer(customerName, customerEmail, customerPassword, customerContact, customerAddress);
			System.out.println(custobj);
			result = cdao.addCustomer(custobj);
			if (result) {
				request.setAttribute("msg", "Customer  Added Successfully");
				rd = request.getRequestDispatcher("addcustomer.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", "Customer not added ");
				rd = request.getRequestDispatcher("addcustomer.jsp");
				rd.forward(request, response);
			}
			}
		}
		//update
		if (action != null && action.equals("update")) {
			int customerId =Integer.parseInt( request.getParameter("customerid"));
			System.out.println(customerId);
			String customerName = request.getParameter("customername");
			System.out.println(customerName);
			String customerEmail = request.getParameter("customeremail");
			String customerPassword = request.getParameter("customerpass");
			String customerContact = request.getParameter("customercontact");
			String customerAddress = request.getParameter("customeraddress");
				custobj = new Customer(customerId, customerName, customerEmail, customerPassword, customerContact, customerAddress);
				System.out.println(custobj);
				result = cdao.updateCustomer(custobj);
				if (result) {
					request.setAttribute("msg","Customer updated");
					List<Customer> customerlist=cdao.showCustomerList();
					session.setAttribute("clist", customerlist);
					rd=request.getRequestDispatcher("showcustomerlist.jsp");
					rd.forward(request, response);	
				} else {
					request.setAttribute("msg","Customer not updated");
					List<Customer> customerlist=cdao.showCustomerList();
					session.setAttribute("clist", customerlist);
					rd=request.getRequestDispatcher("showcustomerlist.jsp");
					rd.forward(request, response);	
				
			}
			
		  }	
		}
	}


