package in.grocery.controller;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.grocery.dao.productDaoImpl;
import in.grocery.pojo.Product;

@MultipartConfig
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	
	PrintWriter out=null;
	String action=null;
	Product prodobj=null;
	productDaoImpl pdao=new productDaoImpl();
	boolean result=false;
	RequestDispatcher rd=null;
	HttpSession session=null;
	
	
	
	
	//Delete and show
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		
		//delete & show
		if(action!=null && action.equals("delete")) {
			int productid=Integer.parseInt(request.getParameter("pid"));
			System.out.println(productid);
			result=pdao.deleteProduct(productid);
			if(result) {
				request.setAttribute("msg", "product deleted");
				List<Product> productlist=pdao.showProductList();
				session.setAttribute("plist", productlist);
				rd=request.getRequestDispatcher("showproductlist.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "product not deleted");
				List<Product> productlist=pdao.showProductList();
				session.setAttribute("plist", productlist);
				rd=request.getRequestDispatcher("showproductlist.jsp");
				rd.forward(request, response);
			}
		}
		//edit
		if (action != null && action.equals("edit")) {
				int productId = Integer.parseInt(request.getParameter("pid"));
				System.out.println(productId);
				prodobj = pdao.searchProductById(productId);
				System.out.println(prodobj);
				session.setAttribute("uproduct", prodobj);
				response.sendRedirect("updateproduct.jsp");
				
			}else {
				List<Product>productlist=pdao.showProductList();
			    System.out.println("productlist:" +productlist);
				session=request.getSession();
				if(productlist!=null) {
					session.setAttribute("plist", productlist);
					//rd=request.getRequestDispatcher("showproductlist.jsp");
					//rd.forward(request, response);
					response.sendRedirect("showproductlist.jsp");
			}
			}
	}


	//add and update
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		System.out.println("inside add product");
		//add
		if(action!=null && action.equals("addproduct") ) {
			System.out.println("inside add product post method");
			String productName=request.getParameter("productname");
			Double productPrice=Double.parseDouble(request.getParameter("productprice"));
			String productType=request.getParameter("producttype");
			Double productWeight=Double.parseDouble(request.getParameter("productweight"));
			//image 
			Part part = request.getPart("productimage");
			InputStream imagefile = part.getInputStream();
			
			prodobj=new Product(productName,productPrice,productType,productWeight,imagefile);
			System.out.println(prodobj);
			result=pdao.addProduct(prodobj);
			if(result) {
				request.setAttribute("msg", "Product  Added Successfully");
				rd=request.getRequestDispatcher("addproduct.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Product not added ");
				rd=request.getRequestDispatcher("addproduct.jsp");
				rd.forward(request, response);
			}
			
		}
		
		//update
		 System.out.println("inside update product");
		if (action!= null && action.equals("update")) {
			System.out.println("inside update product");
			int productId = Integer.parseInt(request.getParameter("productid"));
			String productName = request.getParameter("productname");
			double productPrice = Double.parseDouble(request.getParameter("productprice"));
			String productType = request.getParameter("producttype");
			double productWeight = Double.parseDouble(request.getParameter("productweight"));
			//image
			Part part = request.getPart("productimage");
			InputStream imagefile = part.getInputStream();
			
			prodobj = new Product(productId, productName, productPrice, productType, productWeight,imagefile );
			result = pdao.updateProduct(prodobj);
			if (result)
			 {
				request.setAttribute("msg", "product is  Updated");
				List<Product> productlist = pdao.showProductList();
				session.setAttribute("plist", productlist);
				rd = request.getRequestDispatcher("showproductlist.jsp");
				rd.forward(request, response);
			} 
			else 
			{
				request.setAttribute("msg", "product not Updated");
				List<Product> productlist = pdao.showProductList();
				session.setAttribute("plist", productlist);
				rd = request.getRequestDispatcher("showproductlist.jsp");
				rd.forward(request, response);
			}

		}
		
		
		
	}

}
