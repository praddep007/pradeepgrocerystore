<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 
<title>Add Product </title>
</head>
<body style=" background-color: #CFD8DC;">
<center>
<jsp:include page="header.jsp"></jsp:include>
<h3> Add Product Here!!! </h3>
<form action="ProductController" method="post"  enctype="multipart/form-data" >
<input type="hidden" name="action" value="addproduct">
<table class="table table-bordered" style="width:50%">
  <thead class="thead-dark">
<tr>
	<td> Product Category </td>
	<td>
		<select name="producttype">
			<option> Select Category </option>
			<option name="veg"> Vegetables </option>
			<option name="fruits"> Fruits </option>
			<option name="oil"> Oil </option>
			<option name="protein"> Protein </option>
			<option name="Eggs"> Eggs </option>
			<option name="Peanut"> Peanut Butter </option>
			<option name="Curd"> Curd </option>
			<option name="Milk"> Milk </option>
		</select>
	</td>
</tr>
</thead>
<tr>
	<td> Product Name </td>
	<td> <input type="text" name="productname"> </td>
</tr>
<tr>
	<td> Product Price </td>
	<td> <input type="text" name="productprice"> </td>
</tr>
<tr>
	<td> Product Weight </td>
	<td> <input type="number" name="productweight" min=1> </td>
</tr>
<tr>
	<td> Product Image </td>
	<td> <input type="file" name="productimage" > </td>
</tr>
<tr>
	<td> </td>  
	<td> 
			  <button type="submit" value ="add product" style="margin-right: 26px;" class="btn btn-outline-dark">Add Product</button>
	 
			  <button type="reset" value ="clear"  class="btn btn-outline-danger">Clear</button> </td>
</tr>
</table>
<b style="color:#29B6F6">
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
out.print(msg);
}
%>
</b>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>