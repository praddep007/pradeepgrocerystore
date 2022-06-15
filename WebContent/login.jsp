<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.form-control
{
   width: 56%;
   border-radius: 1.25rem;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">



</head>
<body style=" background-color: #CFD8DC;">
<center>
<jsp:include page="header.jsp"></jsp:include>

<h4 style="text-shadow :2px 2px 5px #AFEEEE;">Login</h4>

<%
String msg=(String)request.getAttribute("msg");
if (msg!=null){%>

	<b style="color:red"><%=msg%></b>
	<%} %>

<form action="LoginController" method="post">


<section class="3">
	<div class="py-3">
			<h6 class="text-center">Select User-type : </h6>
			<input type="radio" name="usertype" value="admin" >Admin &nbsp; <input type="radio"name="usertype" value="customer" >Customer
	</div>
	
	<div class="w-50 m-auto">
	
   <div class="form-group">
	 <label>Username</label>
	 <div >
  
   <input type="text" name="username" placeholder ="  Username" autocomplete="off" class="form-control" style="margin:0px 0px -7px 0px;width: 56%;
   border-radius: 1.25rem;">
		</div>		
			</div>
			<div class="form-group">
				<label>Password</label>
				<input type="password" name="userpass" placeholder =" Password" autocomplete="off" class="form-control" style="margin:0px 0px -7px 0px;width: 56%;
   border-radius: 1.25rem;">
				
			</div>
		
			  <button type="submit" value ="login" style="margin-right: 26px;" class="btn btn-outline-dark">Login</button>
			   <p>Don't have an account? <a href="addcustomer.jsp" class="link-info">Register here</a></p>
			 <!--  
			 <button type ="reset" value="cancel" class="btn btn-outline-dark">Cancel</button>
			 -->
		</form>
	</div>
</section>






<!--  
<table border=2 width=400px height=250px cellspacing=5px cellpadding=10px>
<tr>
	<td>Select User Type</td>
	<td><input type="radio" name="usertype" value="admin" >Admin<input type="radio"name="usertype" value="customer" >Customer</td>
</tr>
<tr>
	<td>Username</td>
	<td><input type="text" placeholder =" Enter Username" name="username"></td>
</tr>
<tr>
	<td>Userpassword</td>
	<td><input type="password" placeholder="Enter Userpass" name="userpass"></td>
</tr>

<tr>
    <td></td>
	<td><input type="submit" value="login" style="margin-right: 26px;"><input type="reset" value="cancel"></td>
</tr>
</table>
-->
</form>

<jsp:include page="footer.jsp"></jsp:include>
</center>
</body>
</html>