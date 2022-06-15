package in.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.grocery.dao.CartDaoImpl;
import in.grocery.dao.OrderDaoImpl;
import in.grocery.pojo.Cart;
import in.grocery.pojo.Order;
import in.grocery.pojo.Product;




@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	
	PrintWriter out=null;
	String action=null;
	Order order=new Order();
	CartDaoImpl cartdao=new CartDaoImpl();
	OrderDaoImpl orderdao=new OrderDaoImpl();
	boolean result=false;
	RequestDispatcher rd=null;
	HttpSession session=null;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		session = request.getSession();
		action = request.getParameter("action");
		//System.out.println(action)

		
		if(action!=null && action.equals("myorder"))
		{
			String customerEmail=(String)session.getAttribute("customer");
			System.out.println(customerEmail);
			if(customerEmail!=null) 
			{
				List<Order> orderlist = orderdao.getAllMyOrder(customerEmail);
			     if(orderlist.isEmpty())
			     {
			    	 request.setAttribute("msg", "Order List is Empty");
			    	 rd = request.getRequestDispatcher("myorder.jsp");
			    	 rd.forward(request, response);
			     }
			     else
			     {
			    	 session.setAttribute("orderlist", orderlist);
			    	// response.sendRedirect("myorder.jsp");
			    	 rd = request.getRequestDispatcher("myorder.jsp");
			    	 rd.forward(request, response);
			     }
			 }  
		}
			if(action!=null && action.equals("cancelorder"))
			{	
		        System.out.println(action);
				int orderid=Integer.parseInt(request.getParameter("oid"));
				System.out.println(orderid);
				result = orderdao.cancelOrder(orderid);
				if(result)
				{
					request.setAttribute("msg", "Your Order is Successfully Cancel !");
					String customerEmail=(String)session.getAttribute("customer"); 
					List<Order> orderlist=orderdao.getAllMyOrder(customerEmail);
					session.setAttribute("orderlist", orderlist);
					rd=request.getRequestDispatcher("myorder.jsp");
					rd.forward(request, response);
				}
				else 
				{
					request.setAttribute("msg", "Your Order is not Cancel");
					String customerEmail=(String)session.getAttribute("customer");
					List<Order> orderlist=orderdao.getAllMyOrder(customerEmail);
					session.setAttribute("orderlist", orderlist);
					rd=request.getRequestDispatcher("myorder.jsp");
					rd.forward(request, response);
				}
			}
			if(action!=null && action.equals("allorder")) {
				List<Order> orderlist=orderdao.getAllOrder();
				System.out.println("aaaaaaaaaaaaaaaaaaaaa");
				System.out.println(orderlist);
				if(orderlist.isEmpty()) {
					request.setAttribute("msg", "Order list id empty");
					rd=request.getRequestDispatcher("myorder.jsp");
					rd.forward(request, response);
				}
				else {
					session.setAttribute("orderlist", orderlist);
					rd=request.getRequestDispatcher("myorder.jsp");
					rd.forward(request, response);
				}
			}
	}
	  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		session = request.getSession();
		action = request.getParameter("action");
		System.out.println(action);
		
		if(action!=null && action.equalsIgnoreCase("placeorder"));
		{
			String CustomerEmail = (String) session.getAttribute("customer");
			order = orderdao.placeOrder(CustomerEmail);
			session.setAttribute("order",order);
			  //response.sendRedirect("orderdetails.jsp");
			 rd = request.getRequestDispatcher("orderdetails.jsp");
	    	 rd.forward(request, response);
		}
	
	}

}
