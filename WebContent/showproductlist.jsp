<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="in.grocery.pojo.Product,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
*{ margin: 0; padding: 0; box-sizing: border-box;
font-family: 'josefin Sans', sans-serif; }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title> Product List Page</title>
</head>

<body style=" background-color: #FFFFFF;">

<%
String utype =(String) session.getAttribute("usertype");  
%>
<center>
<jsp:include page="header.jsp"></jsp:include>
<%
List<Product> prodlist=(List)session.getAttribute("plist");

String msg=(String)request.getAttribute("msg");
if(msg!=null){%>
<b><% out.print(msg); }%></b>
	
<h4 style="text-shadow :2px 2px 5px #AFEEEE;" >Product list !!!</h4>


<table class="table table-bordered" style="width:100%">
  <thead class="thead-dark">
  <tr>
	<th>PRODUCT ID</th>
	<th>PRODUCT IMAGE</th>
	<th>PRODUCT NAME</th>
	<th>PRODUCT PRICE</th>
	<th>PRODUCT TYPE</th>
	<th>PRODUCT WEIGHT</th>
	<th colspan=2 style=" padding: 0px 44px 8px 21px;">Operations</th>
</tr>
</thead>

<% for(Product p:prodlist){ %>
<tr>
	<td><%=p.getProductId() %></td>
	<td><img alt="productimage" src="ImageController?productid=<%=p.getProductId() %>"  width=140px height=100px ></td>
	<td><%=p.getProductName() %></td>
	<td><%=p.getProductPrice() %></td>
	<td><%=p.getProductType() %></td>
	<td><%=p.getProductWeight() %></td>
	
 <%if (utype!=null && utype.equals("admin")){ %>
     <td><a href="ProductController?action=edit&pid=<%=p.getProductId()%>"><button type="button" class="btn btn-outline-dark" style="border-radius:1.25rem;">Update</button></a></td>
	<td><a href="ProductController?action=delete&pid=<%=p.getProductId()%>"><button type="button" class="btn btn-outline-primary" style="border-radius:1.25rem;">Delete</button></a></td>
	
	<%} %>
	<%if (utype==null || utype.equals("customer")){ %>
	<td>
	<a href="CartController?action=addtocart&pid=<%=p.getProductId()%>"><button type="button" class="btn btn-outline-warning" style="border-radius:1.25rem;">Add to Cart</button></a>
	
	</td>
	
	<%} %>
	</tr>
<%} %>

</table>

 


<jsp:include page="footer.jsp"></jsp:include>
</center>

</body>
</html>