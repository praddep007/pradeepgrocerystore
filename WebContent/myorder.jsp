<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.grocery.pojo.Order, java.util.*, in.grocery.dao.OrderDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Order Page</title>
</head>
<body style=" background-color: #CFD8DC;">
<jsp:include page="header.jsp"></jsp:include>
<center>
<%
List<Order> orderlist = (List)session.getAttribute("orderlist");
String msg=(String)request.getAttribute("msg");

if(msg!=null){%>
<b><% out.print(msg);} else {%></b>


<table class="table table-bordered" style="width:93%">
  
<tr style="background-color:#FFFFFF">
      <th>ORDER ID</th>
      <th>TOTAL BILL</th>
      <th>ORDER DATE</th>
      <th>ORDER STATUS</th>
      <th>Operation</th>

</tr>

<%for(Order o:orderlist){%>
<tr>
	<td align="center"><%=o.getOrderId() %></td>
	<td><%=o.getTotalBill()%></td>
	<td><%=o.getOrderDate() %></td>
	<td><%=o.getOrderStatus() %></td>
	<td><a href="OrderController?action=cancelorder&oid=<%=o.getOrderId() %>"><button type="button" class="btn btn-outline-primary">Cancel Order</button></a></td>

</tr>
<%} %>

</table>
<% }%>
</center>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>