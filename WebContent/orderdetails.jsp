<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.grocery.pojo.Order, java.util.*, in.grocery.dao.OrderDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details Page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<center>

<%Order order = (Order) session.getAttribute("order"); %>


<table class="table table-bordered" style="width:93%">
<tr style="background-color:#d9d9d9">
      <th>ORDER ID</th>
      <th>TOTAL BILL</th>
      <th>CUSTOMER EMAIL</th>
      <th>ORDER DATE</th>
      <th>ORDER STATUS</th>

</tr>
<tr>
	<td align="center">
	 <%=order.getOrderId() %></td>
	<td><%=order.getTotalBill() %></td>
	<td><%=order.getCustomerEmail()%></td>
	<td><%=order.getOrderDate()%></td>
	<td><%=order.getOrderStatus() %></td>
	
</tr>


</table>






</center>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>