<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

</style>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 
<title>Add Customer Page</title>

</head>
<body style=" background-color: #CFD8DC;">
<center>
<jsp:include page="header.jsp"></jsp:include>

<% String msg=(String)request.getAttribute("msg");%>
<% if(msg!=null){ %>
 <h2><% out.print(msg);} %></h2>
 
<form action="CustomerController" method="post">
<input type="hidden" name="action" value="addcustomer">

<h5 style="text-shadow :2px 2px 5px SlateGray;">Create New account</h5>

<section class="3">
	<div class="w-50 m-auto">
	 <div class="form-group" class="py-3">
				<label>Customer Name</label>
				<input type="text" name="customername" placeholder ="  Name" autocomplete="off" class="form-control" style="width:56%; border-radius: 1.25rem; margin: 0px 0px -15px 0px">
				
			</div>
			<div class="form-group">
				<label>Customer Email</label>
				<input type="text" name="customeremail" placeholder =" Email" autocomplete="off" class="form-control" style="width:56%; border-radius: 1.25rem;margin: 0px 0px -15px 0px">
				
			</div>
			<div class="form-group">
				<label>Customer Password</label>
				<input type="password" name="customerpass" placeholder ="  Password" autocomplete="off" class="form-control" style="width:56%; border-radius: 1.25rem;margin: 0px 0px -15px 0px">
				
			</div>
			<div class="form-group">
				<label>Confirm Password</label>
                <input type="password" name="customerconfirmpass" placeholder ="Confirm Password" autocomplete="off" class="form-control" style="width:56%; border-radius: 1.25rem; margin: 0px 0px -15px 0px">	
			</div>
			
			<div class="form-group">
				<label>Customer Contact</label>
                <input type="text" name="customercontact" placeholder ="  Contact" autocomplete="off" class="form-control" style="width:56%; border-radius: 1.25rem;margin: 0px 0px -15px 0px">	
			</div>
			<div class="form-group">
				<label>Customer Address</label>
                <input type="text" name="customeraddress" placeholder ="  Address" autocomplete="off" class="form-control" style="width:56%; border-radius: 1.25rem;margin: 0px 0px -15px 0px" >	
			</div>
			
			 <button type="submit" value ="submit" style="margin: 6px 7px 4px 0px;" class="btn btn-outline-dark">Submit</button>
			 <button type ="reset" value="cancel" class="btn btn-outline-dark">Cancel</button>
			
	</div>
</section>









<!--  
<table style="background-color:#d9d9d9" border=2 width=400px heigth=250px cellspacing=5px cellpadding=10px >
<tr >
<td>Customer Name</td>
<td><input type = "text" name="customername" ></td>
</tr>
<tr>
<td>Customer Email</td>
<td><input type = "text" name="customeremail" ></td>
</tr>
<tr>
<td>Customer Password</td>
<td><input type = "password" name="customerpass" ></td>
</tr>
<tr>
<td>Customer Confirm Password</td>
<td><input type = "password" name="customerconfirmpass" ></td>
</tr>
<tr>
<td>Customer Contact</td>
<td><input type = "text" name="customercontact" ></td>
</tr>
<tr>
<td>Customer Address</td>
<td><input type = "text" name="customeraddress" ></td>
</tr>
<td></td>
<td><input type="submit" value="Submit"><input type="reset" value="Reset"></td>
</table>
-->

</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>