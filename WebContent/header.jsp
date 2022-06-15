<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

#login-header
{
  margin: 0px 10px 0px 105px;
}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery Store</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<center>
<%
String utype=(String)session.getAttribute("usertype");
String customer=(String)session.getAttribute("customer");
%>

<!-- this is heder Design code -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<!--  
  <a class="navbar-brand" href="index.jsp">GreenBay Shopping</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 -->
 <nav class="navbar navbar-expand-md navbar-dark">
					   <div class="col-md-2 tb-rght">
						    <div class="logo">
								<a href="index.jsp">
									<img src="img/logo.png" alt="logo" class="logodark" style="width: 130px">
								</a>
				</div>
		</div>
 </nav>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  
    <ul class="navbar-nav ml-auto">
    
      <li class="nav-item active">
        
        <a class="nav-link"  href="index.jsp">HOME <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contactus.jsp">CONTACT US</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" style="margin:0px 0px 0px 0px " href="ProductController">GROCERY LIST</a>
      </li>
      
      <% if (utype!=null && utype.equals("admin")){ %>
      <li class="nav-item">
        <a class="nav-link" href="addproduct.jsp">ADD GROCERY</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="CustomerController">CUSTOMER LIST</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="OrderController?action=allorder">ALL ORDERS</a>
      </li>
      <%} %>
      
      
      <% if (utype==null && customer!=null){ %>
      
      <li class="nav-item">
        <a class="nav-link" href="">UPDATE PROFILE</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="CartController?action=showcart">MY CART</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="OrderController?action=myorder">MY ORDERS</a>
      </li>
      
      <%} %>
      
 <% if (utype==null && customer==null){ %>
       <a href="login.jsp"  id="login-header">
         
           
         <button type="button" class="btn btn-outline-light"  style="margin:0px 0px 0px 205px ;border-radius:1.25rem;">Log in</button> 
        </a>
        
  <!--  
       <li class="nav-item">
        <a class="nav-link"  id="login-header" href="login.jsp" class="btn btn-info btn-primary"><span class="glyphicon glyphicon-log-in"></span>LOGIN</a>
      </li>
    -->  
       <a href="addcustomer.jsp">
          <button type="button" class="btn btn-outline-light"  style="border-radius:1.25rem;">Register</button>
        </a>
        <!--  
       <li class="nav-item">
        <a class="nav-link" href="addcustomer.jsp">REGISTER</a>
      </li>
      -->
    <%} %>  
    
      
<% if ((utype!=null && (utype.equals("admin")) || customer!=null)){%>
        <li class="nav-item">
        <!--  
        <a class="nav-link" href="LoginController">LOGOUT</a>
        -->
         <a href="LoginController" >
           <button type="button" class="btn btn-outline-light"  style="margin:0px 0px 0px 169px ;border-radius:1.25rem;">Logout</button>
        </a>
      </li>  
    <%} %>  
  </ul>
  
   
    
  </div>
</nav>


</center>
</body>
</html>