<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="in.grocery.pojo.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 
<title>Update Product Page</title>
</head>
<body style=" background-color:  #CFD8DC;;">
<jsp:include page="header.jsp"></jsp:include>
<center>
	<%
	Product pobj = (Product) session.getAttribute("uproduct");
	%>
	<form action="ProductController" method="post" enctype="Multipart/form-data">
		<input type="hidden" name="action" value="update">
			<table class="table table-bordered" style="width:50%">
             <thead class="thead-dark">
				<tr>
					<td>Product Id</td>
					<td><input type="text" name="productid"
						value="<%=pobj.getProductId()%>" readonly></td>
				</tr>
			
				<tr>
					<td>Product Name</td>
					<td><input type="text" name="productname"
						value="<%=pobj.getProductName()%>"></td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td><input type="text" name="productprice"
						value="<%=pobj.getProductPrice()%>"></td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td><select name="producttype">
			            <option> select category </option>
			              <option name="veg"> Vegetables </option>
			                <option name="fruits"> Fruits </option>
			                 <option name="oil"> Oil </option>
			                 <option name="protein"> Protein </option>
			                  <option name="atta"> Atta </option>
			                  
			                  <option name="Peanut"> Peanut Butter </option>
			                  <option name="Curd"> Curd </option>
			                  <option name="Milk"> Milk </option>
		           </select></td>
				</tr>
				<tr>
					<td>Product Weight</td>
					<td><input type="number" name="productweight"
						value="<%=pobj.getProductWeight()%>" min=1></td>
				</tr>
				<tr>
					<td>Product Image</td>
					<td><input type="file" name="productimage" ></td>
				</tr>
				
				<tr>
					<td colspan=2 align=center><button type="submit"   value="Update Product" class="btn btn-outline-dark">Update</button></td>
				</tr>
				</thead>
			</table>

		</form>

	
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>