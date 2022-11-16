<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>MH CATERING</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/prettyPhoto.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/price-range.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginheader.css"/>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	
		
		<header id="header"><!--header-->
	
		
		<div class="header-middle"><!--top header-->
			<div class="container">
				<div class="row">
					<div class="col-md-4 clearfix">
						<div class="logo pull-left">
							<a href="customerindex.jsp"><img src="images/home/MHCateringLogo.jfif" width="50%" height="50%" alt="" /></a>
						</div>
					</div>
					<div class="col-md-8 clearfix">
						<div class="shop-menu clearfix pull-right">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><p></p></li>
								<li><a href="/Catering/AccountController?action=viewAccount"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="OrderController?action=listCustomerOrder"><i class="fa fa-shopping-cart"></i> Orders</a></li>
								<li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i> Checkout</a></li>
								<li><a href="cart.jsp"  ><i class="fa fa-shopping-cart" ></i> Cart</a></li>
								<li class="dropdown"><a href="LogoutController"><i class="fa fa-lock"></i> Logout</a>
                            </ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="customerindex.jsp">Home</a></li>
								<li class="dropdown"><a href="/Catering/ProductController?action=listCustomerProduct">Menu</a></li>
                                   <!-- <ul role="menu" class="sub-menu">
                                        <li><a href="shop.html" class="active">Food Menu/Services</a></li>
								
                                    </ul>
                                </li> -->
								<li><a href="/Catering/ProductController?action=listOrderProduct">Order now</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
				</div>
		</div>
	</header>
	
	
	
	<section>
		<div class="container">
			<div class="row">
				
				
					<div class="col-sm-9 padding-right">
				<div class="login-form">
				<form method="post" action="AccountController">
				<p>Name : 
				<br><input type="text" name="name" id="name" placeholder="<%= request.getAttribute("name") %>" value="<%= request.getAttribute("name") %>"></p><br>
				<p>Home Address : 
				<br>
				<input type="text" name="address" id="address" placeholder="<%= request.getAttribute("address") %>" value="<%= request.getAttribute("address") %>"> </p><br>
				<p>Email (Available for read only):
				<br>
				<input type="email" name="email" id="email" placeholder="<%= request.getAttribute("email") %>" readonly value="<%= request.getAttribute("email") %>">  </p><br>
				<p>Phone number : 
				<br><input type="text" name="phone" id="phone" placeholder="<%= request.getAttribute("phone") %>" value="<%= request.getAttribute("phone") %>"> </p><br>
				<p>Password : 
				<br><input type="password" name="password" id="password" placeholder="<%= request.getAttribute("password") %>" value="<%= request.getAttribute("password") %>"> </p><br>
				
				<button class="btn btn-primary pull-left">Confirm</button>
				</form>	
				
			</div>
		</div>
		</div>
		</div>
	</section>
	

	

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>