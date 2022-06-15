<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.grocery.pojo.Customer,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Update Customer Page</title>
</head>
<body  style="background-color: #CFD8DC;">
<% Customer custobj=(Customer)session.getAttribute("ucustomer"); %>
<jsp:include page="header.jsp"></jsp:include>
<center>
<form action="CustomerController" method="post">

<input type="hidden" name="action" value="update">  <!-- hidden form field -->

<table  border=1 width="500px" height=200px cellspacing=5px cellpadding=10px >

<tr>
<td>Customer Id</td>
<td><input type = "text" name="customerid" value="<%=custobj.getCustomerId() %>" readonly></td>
</tr>
<tr>
<tr>
<td>Customer Name</td>
<td><input type = "text" name="customername" value="<%=custobj.getCustomerName() %>" ></td>
</tr>
<tr>
<td>Customer Email</td>
<td><input type = "text" name="customeremail" value="<%=custobj.getCustomerEmail() %>" ></td>
</tr>
<tr>
<td>Customer Password</td>
<td><input type = "password" name="customerpass" value="<%=custobj.getCustomerPassword() %>"></td>
</tr>
<tr>
<tr>
<td>Customer Contact</td>
<td><input type = "text" name="customercontact"  value="<%=custobj.getCustomerContact() %>"></td>
</tr>
<tr>
<td>Customer Address</td>
<td><input type = "text" name="customeraddress"  value="<%=custobj.getCustomerAddress() %>"></td>
</tr>

<td></td>
<td>
<button type="submit" value ="Update" style="margin-right: 26px;" class="btn btn-outline-dark">Update</button></td>

</table>
</form>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>