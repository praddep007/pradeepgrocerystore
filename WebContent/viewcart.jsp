<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.grocery.pojo.Cart,java.util.*, in.grocery.dao.OrderDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Cart Page</title>
</head>
<body style=" background-color: #CFD8DC;">
<center>
<jsp:include page="header.jsp"></jsp:include>

<%
List<Cart>cartlist=(List<Cart>)session.getAttribute("cartlist");
String CustomerEmail = (String) session.getAttribute("customer");


OrderDaoImpl orderdao = new OrderDaoImpl();
double totalbill = orderdao.getTotalBill(CustomerEmail);

%>

<% String msg=(String)request.getAttribute("msg");
if(msg!=null){%>
<b><% out.print(msg); } else {%></b>


<form action="OrderController" method="post">
<input type ="hidden" name="action"  value="placeorder">

 <table class="table table-bordered" style="width:93%">
  <thead>
<tr style="background-color:#FFFFFF">
	<th>PRODUCT ID</th>
	<th>PRODUCT NAME</th>
	<th>PRODUCT PRICE</th>
	<th>PRODUCT QUANTITY</th>
	<th>CUSTOMER EMAIL ID</th>
	<th><a href="CartController?action=emptycart" style="color:#1a8cff"><button type="button" class="btn btn-outline-danger" style="border-radius:1.25rem;">Empty Cart</button></a></th>
	
</tr>

<%for(Cart c:cartlist){%>
<tr>
	<td align="center"><%=c.getProductId() %></td>
	<td><%=c.getProductName()%></td>
	<td><%=c.getProductPrice() %></td>
	<td><%=c.getProductQuantity() %></td>
	<td><%=c.getCustomerEmail() %></td>
	<td><a href="CartController?action=removefromcart&cid=<%=c.getCartId() %>"><button type="button" class="btn btn-outline-primary" style="border-radius:1.25rem;">Remove</button></a></td>
</tr>
<%} %>
<tr>
     <td colspan=4 align="right"> Total Bill  </td>
     <td><%= totalbill  %></td>
     <td>
      <button type ="submit" value="Place Order" class="btn btn-outline-dark" style="border-radius:1.25rem;">Place Order</button>
      </td>
    
</tr>
</table>
</form>
<%} %>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>