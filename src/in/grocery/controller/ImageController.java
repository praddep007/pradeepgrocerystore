package in.grocery.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.grocery.dao.productDaoImpl;
import in.grocery.pojo.Product;


@WebServlet("/ImageController")
public class ImageController extends HttpServlet {
	
	PrintWriter out=null;
	String action=null;
	Product prodobj=null;
	productDaoImpl pdao=new productDaoImpl();
	boolean result=false;
	RequestDispatcher rd=null;
	HttpSession session=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/*");
	    int productid = Integer.parseInt(request.getParameter("productid"));
	    prodobj = pdao.searchProductById(productid);  // prodobj is object of Product class
	    
	    if(prodobj!=null)
	    {
	    	InputStream is = prodobj.getProductImage();  //it will taking the image from the database and only read the data bcoz INPUTSTREAM IS ONLY used for read the data
	    	OutputStream out = response.getOutputStream(); //SERVLET RESPONSE ....to write image as response ..which means  1st we fetch the image and then show to the server side. 
	    	
	    	int i = 0;  //to read the file 
	    	while(i != -1)  //read the file till the end
	    	{
	    		i  = is.read();
	    		if(i !=-1)
	    		{
	    			out.write(i);
	    		}
	    	}
	    	is.close();
	    	out.close();
	    }
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
