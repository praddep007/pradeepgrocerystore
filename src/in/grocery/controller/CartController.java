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

import in.grocery.dao.CartDaoImpl;
import in.grocery.dao.productDaoImpl;
import in.grocery.pojo.Cart;
import in.grocery.pojo.Product;


@WebServlet("/CartController")
public class CartController extends HttpServlet {
	PrintWriter out=null;
	String action=null;
	Cart cart=null;
	CartDaoImpl cartdao=new CartDaoImpl();
	boolean result=false;
	RequestDispatcher rd=null;
	HttpSession session=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		action=request.getParameter("action");
		
			if(action!=null && action.equals("addtocart")) {
				int productId=Integer.parseInt(request.getParameter("pid"));
				System.out.println(productId);
				String customerEmail=(String)session.getAttribute("customer");
				System.out.println(customerEmail);
				if(customerEmail!=null) 
				{
					Cart cart=new Cart();
					cart.setProductId(productId);
					cart.setCustomerEmail(customerEmail);
					cart.setProductQuantity(1);
					
					result=cartdao.addToCart(cart);
					if(result) 
					{
						request.setAttribute("msg", "Product is Added to the cart");
						rd = request.getRequestDispatcher("showproductlist.jsp");
						rd.forward(request, response);
					}
					else 
					{
						request.setAttribute("msg", "Product Not Added");
						rd = request.getRequestDispatcher("showproductlist.jsp");
						rd.forward(request, response);
					}
				}
				else 
				{
					request.setAttribute("msg", "Please login first");
					rd=request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			}
			else if(action!= null && action.equals("showcart"))
			{
				String customerEmail=(String)session.getAttribute("customer");
				List<Cart> cartlist=cartdao.showCart(customerEmail);
				if(cartlist.isEmpty())
				{
					request.setAttribute("msg", "Your Cart is Empty Add your Items Here !!!");
					rd = request.getRequestDispatcher("viewcart.jsp");
					rd.forward(request, response);
				}
				else
				{
					System.out.println(cartlist);
					session.setAttribute("cartlist", cartlist);
					response.sendRedirect("viewcart.jsp");	
				}

			}
			else if(action!=null && action.equals("removefromcart"))
			{
				int cid = Integer.parseInt(request.getParameter("cid"));
				result = cartdao.removeFromCart(cid);
				if(result)
				{
					String customerEmail=(String)session.getAttribute("customer");
					List<Cart> cartlist=cartdao.showCart(customerEmail);
					System.out.println(cartlist);
					request.setAttribute("msg", "Items  Removed!!");
					session.setAttribute("cartlist", cartlist);
					rd = request.getRequestDispatcher("viewcart.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Items not Removed!!");
					rd=request.getRequestDispatcher("viewcart.jsp");
					rd.forward(request, response);
				}
			}
			else if(action!=null && action.equals("emptycart"))
			{
				String customerEmail = (String) session.getAttribute("customer");
				result = cartdao.clearCart(customerEmail);
				if(result)
				{
					request.setAttribute("msg", "Your Cart is Empty ");
					String customerEmail1=(String)session.getAttribute("customer");
					List<Cart> cartlist=cartdao.showCart(customerEmail1);
					session.setAttribute("cartlist", cartlist);
					rd = request.getRequestDispatcher("viewcart.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Please Try Again to Remove the cart");
					String customerEmail1=(String)session.getAttribute("customer");
					List<Cart> cartlist=cartdao.showCart(customerEmail1);
					session.setAttribute("cartlist", cartlist);
					rd = request.getRequestDispatcher("viewcart.jsp");
					rd.forward(request, response);
				}
			}
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
