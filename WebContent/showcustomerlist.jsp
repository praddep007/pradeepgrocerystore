<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="in.grocery.pojo.Customer,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 
<title>Customer List Page</title>
</head>
<body style=" background-color: #FFFFFF;">
<jsp:include page="header.jsp"></jsp:include>
<center>

<%
List<Customer> custlist=(List)session.getAttribute("clist");
String msg=(String)request.getAttribute("msg");

if(msg!=null){%>

<h2><% out.print(msg);} %></h2>

<h3>Customer list !!!</h3>
<table class="table table-bordered" style="width:100%">
  <thead class="thead-dark">
<tr >
	<th>CUSTOMER ID</th>
	<th>CUSTOMER NAME</th>
	<th>CUSTOMER EMAIL</th>
	<th>CUSTOMER PASSWORD</th>
	<th>CUSTOMER CONTACT</th>
	<th>CUSTOMER ADDRESS</th>
	<th colspan=2>Operation</th>
</tr>
</thead>
<% for(Customer c:custlist){ %>
<tr>
	<td><%=c.getCustomerId() %></td>
	<td><%=c.getCustomerName() %></td>
	<td><%=c.getCustomerEmail() %></td>
	<td><%=c.getCustomerPassword() %></td>
	<td><%=c.getCustomerContact() %></td>
    <td><%= c.getCustomerAddress() %> </td>
	<td><a href="CustomerController?action=edit&cid=<%=c.getCustomerId()%>"><button type="button" class="btn btn-outline-secondary" style="border-radius:1.25rem;">Update</button></td>
	<td><a href="CustomerController?action=delete&cid=<%=c.getCustomerId()%>"><button type="button" class="btn btn-outline-danger" style="border-radius:1.25rem;">Delete</button></td>
            
	</tr>
<%} %>

</table>
</center>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>