<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">

*{ margin: 0; padding: 0; box-sizing: border-box;
font-family: 'josefin Sans', sans-serif; }


.carousel-inner img {
    width: 100%;
    height: 90%;
  }
  
  .aboutimg{
	
	width: 90%;
	height: 250px !important;
}  
  
 body {
    background: #eee
}

.wrapper {
    margin-top: 30px
}

.card {
    border: 1px solid #eee;
    cursor: pointer
}

.weight {
    margin-top: -65px;
    transition: all 0.5s
}

.weight small {
    color: #e2dede
}

.buttons {
    padding: 10px;
    background-color: #d6d4d44f;
    border-radius: 4px;
    position: relative;
    margin-top: 7px;
    opacity: 0;
    transition: all 0.8s
}

.dot {
    height: 14px;
    width: 14px;
    background-color: green;
    border-radius: 50%;
    position: absolute;
    left: 27%;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 8px;
    color: #fff;
    opacity: 0
}

.cart-button {
    height: 48px
}

.cart-button:focus {
    box-shadow: none
}

.cart {
    position: relative;
    height: 48px !important;
    width: 50px;
    margin-right: 8px;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #fff;
    padding: 11px;
    border-radius: 5px;
    font-size: 14px;
    transition: 1s ease-in-out;
    overflow: hidden
}

.cart-button.clicked span.dot {
    animation: item 0.3s ease-in forwards
}

@keyframes item {
    0% {
        opacity: 1;
        top: 30%;
        left: 30%
    }

    25% {
        opacity: 1;
        left: 26%;
        top: 0%
    }

    50% {
        opacity: 1;
        left: 23%;
        top: -22%
    }

    75% {
        opacity: 1;
        left: 19%;
        top: -18%
    }

    100% {
        opacity: 1;
        left: 14%;
        top: 28%
    }
}

.card:hover .buttons {
    opacity: 1
}

.card:hover .weight {
    margin-top: 10px
}

.card:hover {
    transform: scale(1.04);
    z-index: 2;
    overflow: hidden
}

</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

 
<title>Online Grocery Store</title>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<%
String utype=(String)session.getAttribute("usertype");
String customer=(String)session.getAttribute("customer");

if (utype!=null && customer==null){%>
<marquee style="text-shadow :2px 2px 5px #33ccff;">welcome <%=utype %></marquee>
<%} %>

<%if(utype==null && customer!=null) {%>
<marquee style="text-shadow :2px 2px 5px #33ccff;">welcome <%=customer %></marquee>
<%} %>


<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img\g2.jpg" alt="GroceryStore" width="1100px" height="500px">
    </div>
    <div class="carousel-item">
      <img src="img/g3.jpg" alt="GroceryStore" width="1100" height="500">
    </div>
    <div class="carousel-item">
      <img src="img/g6.jpg" alt="GroceryStore" width="1100" height="500">
    </div>
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>

<div class="py-2"></div>

<div class="wrapper">
<div class="py-4">
		<h2 class="text-center">Our Products </h2>
	</div>
    <div class="container">
        <div class="row g-1">
        
            <div class="col-md-3">
                <div class="card p-3">
                    <div class="text-center"> <img src="https://i.imgur.com/w2rCsEw.jpg" width="200"> </div>
                    <div class="product-details"> <span class="font-weight-bold d-block">Rs 70.00</span> <span>Onion</span>
                        <div class="buttons d-flex flex-row">
                              <a href="ProductController" class="btn btn-success cart-button btn-block">Shop Now</a>
                        </div>
                        <div class="weight"> <small> 2.5kg</small> </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="card p-3">
                    <div class="text-center"> <img src="https://i.imgur.com/ZRUetRF.jpg" width="200"> </div>
                    <div class="product-details"> <span class="font-weight-bold d-block">Rs 15.00</span> <span>Corn</span>
                        <div class="buttons d-flex flex-row">
                              <a href="ProductController" class="btn btn-success cart-button btn-block">Shop Now</a>
                        </div>
                        <div class="weight"> <small>1 piece</small> </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="card p-3">
                    <div class="text-center"> <img src="https://i.imgur.com/0M7pldG.jpg" width="200"> </div>
                    <div class="product-details"> <span class="font-weight-bold d-block">Rs 35.00</span> <span>Pine Apple</span>
                        <div class="buttons d-flex flex-row">
                              <a href="ProductController" class="btn btn-success cart-button btn-block">Shop Now</a>
                        </div>
                        <div class="weight"> <small>1 piece 1.0kg</small> </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="card p-3">
                    <div class="text-center"> <img src="https://i.imgur.com/emb60L5.jpg" width="200"> </div>
                    <div class="product-details"> <span class="font-weight-bold d-block">Rs 20.00</span> <span>Bitter Gourd</span>
                        <div class="buttons d-flex flex-row">
                             
                              <a href="ProductController" class="btn btn-success cart-button btn-block">Shop Now</a>
                             
                        </div>
                        <div class="weight"> <small>1kg</small> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="py-2"></div> 

<section class="2">
	<div class="py-4">
		<h2 class="text-center">About Us</h2>
	</div>
<div class="container-fluid">
	   <div class="row">
		<div class="col-lg-6 col-md-6 col 12">
		 <img src="img/g7.png" class="img-fluid aboutimg ">
        </div>
        <div class="col-lg-6 col-md-6 col 12">
		<h1 class="display-7">FRESH MARKET </h1>
		  
           <h3 class="py-3">
             WE'LL DELIVER EVERYTHING YOU NEED
           </h3>
           
           <a href="https://www.facebook.com/profile.php?id=100005785631357" class="btn btn-outline-success">Pradeep Yadav</a> 
           
        </div>
	 </div>
  </div>	
</section>

<!--  
<section class="5">
	<div class="py-5">
		<h3 class="text-center">Shop By Category </h3>
	</div>
	
     <div class="container-fluid">
    	<div class="row">
    	
    		<div class="col-lg-3 col-md-4 col-12">
    			<div class="card" >
                   <img class="card-img-top" src="img/amul.jpg" alt="Card image"  width=60px height=160px>
                      <div class="card-body">
                        <h4 class="card-title">Milk</h4>
                           <p class="card-text">Exclusive Offers </p>
                            <a href="login.jsp" class="btn btn-outline-success">Shop Now</a>
                       </div>
                    </div>
    			</div>
    			
    		<div class="col-lg-3 col-md-4 col-12">
    			<div class="card" >
                  <img class="card-img-top" src="img/ata.jpg" alt="Card image"  width=60px height=160px>
                     <div class="card-body">
                        <h4 class="card-title">Atta</h4>
                            
                               <p class="card-text">Exclusive Offers </p>
                               <a href="login.jsp" class="btn btn-outline-success" >Shop Now</a>
                       </div>
                    </div>
    			</div>
    			
    	<div class="col-lg-3 col-md-4 col-12">
    			<div class="card" >
                  <img class="card-img-top" src="img/banana.jpg" alt="Card image"  width=60px height=160px>
                    <div class="card-body">
                      <h4 class="card-title">Fruits</h4>
                         
                             <p class="card-text">Exclusive Offers </p>
                           <a href="login.jsp" class="btn btn-outline-success">Shop Now</a>
                       </div>
                    </div>
    			</div>
    			
    			<div class="col-lg-3 col-md-4 col-12">
    			<div class="card" >
                  <img class="card-img-top" src="img/oats.jpg" alt="Card image"  width=60px height=160px>
                    <div class="card-body">
                      <h4 class="card-title">Protein</h4>
                          <p class="card-text">Exclusive Offers </p>
                           <a href="login.jsp" class="btn btn-outline-success">Shop Now</a>
                       </div>
                    </div>
    			</div>
    			
    			
    		</div>
    	</div>
</section>

-->
 
<div class="py-2"></div>


<jsp:include page="footer.jsp"></jsp:include>

 <script type="text/javascript">
 
 document.addEventListener("DOMContentLoaded", function(event) {


	 const cartButtons = document.querySelectorAll('.cart-button');

	 cartButtons.forEach(button => {

	 button.addEventListener('click',cartClick);

	 });

	 function cartClick(){
	 let button =this;
	 button.classList.add('clicked');
	 }



	 });
 
 </script>


 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  

</body>
</html>