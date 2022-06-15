<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Grocery Store</title>
</head>
<body style=" background-color: #CFD8DC;" >
<center>

<jsp:include page="header.jsp"></jsp:include>

 <%String msg=(String)request.getAttribute("msg");
          if(msg!=null){%>
            <h4 align="center"><% out.print(msg);
          }
          %></h4>

<section class="3">
	<div class="py-3">
		<h2 class="text-center">Contact Us</h2>
	</div>
	<div class="w-50 m-auto">
		<form action="ContactUsController" method="get">
		
			<div class="form-group" style="margin:-35px ​0px 14px 0px">
				<label>Username</label>
				<input type="text" name="name" placeholder="Username" autocomplete="off" class="form-control" style="width:56%; border-radius: 1.25rem; margin: 0px 0px -15px 0px">
				
			</div>
			<div class="form-group">
				<label>Email</label>
				<input type="text" name="email" placeholder="Useremail" autocomplete="off" class="form-control" style="width:56%; border-radius: 1.25rem; margin: 0px 0px -15px 0px">
				
			</div>
			<div class="form-group">
				<label>Contact Number</label>
				<input type="text" name="Contact Number" placeholder="Contact Nmuber" autocomplete="off" class="form-control"style="width:56%; border-radius: 1.25rem; margin: 0px 0px -15px 0px">
				
			</div>
			<div class="form-group">
				<label>Comments</label>
                 <textarea class="form-control" name="comments" placeholder="write something here ..." style="width:56%; border-radius: 1.25rem; margin: 0px 0px -15px 0px">
                 </textarea>				
			</div>
			  <button type="submit" style="margin: 6px 7px 55px 0px;" class="btn btn-outline-dark">Submit</button>
		
		</form>
	</div>
	</section>
<jsp:include page="footer.jsp"></jsp:include>

</center>
</body>
</html>