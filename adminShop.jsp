<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>MH CATERING</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link href="css/loginheader.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<header id="header"><!--header-->
	
		
		<div class="header-middle"><!--top header-->
			<div class="container">
				<div class="row">
					<div class="col-md-4 clearfix">
						<div class="logo pull-left">
							<a href="adminIndex.html"><img src="images/home/MHCateringLogo.jfif" width="50%" height="50%" alt="" /></a>
						</div>
					</div>
					<div class="col-md-8 clearfix">
						<div class="shop-menu clearfix pull-right">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="adminAccount.html"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="adminLogin.html"><i class="fa fa-lock"></i> Logout </a>
                                </li>
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
								<li><a href="adminIndex.html">Home</a></li>
								<li class="dropdown"><a href="/Catering/ProductController?action=listAdminProduct">Menu</a></li>
                                   <!-- <ul role="menu" class="sub-menu">
                                        <li><a href="shop.html" class="active">Food Menu/Services</a></li>
								
                                    </ul>
                                </li> -->
								<li><a href="/Catering/StaffOrderController?action=ListofCustomersOrder">Order List</a></li>
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
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#food_menu">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Food menu
										</a>
									</h4>
								</div>
								<div id="food_menu" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#nasi">Masakan Nasi</a></li>
											<li><a href="#daging">Masakan daging</a></li>
											<li><a href="#ayam">Masakan ayam </a></li>
											<li><a href="#sayur">Sayur-sayuran</a></li>
											<li><a href="#minuman">Minuman</a></li>
						
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#service">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Service
										</a>
									</h4>
								</div>
								<div id="service" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#Service">Service</a></li>
											
										</ul>
									</div>
								</div>
							</div>
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"></span>
											
										</a>
									</h4>
								</div>
								<div id="womens" class="panel-collapse collapse">
									
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#nasi"></a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#daging"></a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#ayam"></a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#sayur"></a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#minuman"></a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#service"></a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#"></a></h4>
								</div>
							</div>
						</div><!--/category-productsr-->
					
						
						<div class="price-range">
							<h2></h2>
							<!--<div class="well">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b>$ 0</b> <b class="pull-right">$ 600</b>
							</div>-->
						</div><!--/price-range-->
						
						
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items">
					<!--masakan nasi -->
					<h2 class="title text-center">Per 10 pax</h2>
					
					<div class="features_items">
						<h2 id="nasi" class="title text-center">Masakan Nasi</h2>
						<c:forEach items="${nasi}" var="product">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="data:image/jpg;base64,${product.base64Image}"/>
											<h2>RM <fmt:formatNumber minFractionDigits="2" value="${product.product_unitPrice}" /></h2>
											<c:out value="${product.product_name}" /><br>
											<a class="btn btn-primary" href="/Catering/ProductController?action=updateProduct&product_id=<c:out value="${product.product_id}" />">Update</a>
											<a class="btn btn-primary" href="/Catering/ProductController?action=deleteProduct&product_id=<c:out value="${product.product_id}" />">Delete</a>
										</div>
									</div>			
								</div>
							</div>
						</c:forEach>
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<a class="btn btn-primary" href="addNasi.html">Add</a>
									</div>
								</div>
							</div>
						</div>
					</div>
						
						<div class="features_items">
						<h2 id="daging" class="title text-center">Masakan Daging</h2>
						<c:forEach items="${daging}" var="product">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="data:image/jpg;base64,${product.base64Image}"/>
											<h2>RM <fmt:formatNumber minFractionDigits="2" value="${product.product_unitPrice}" /></h2>
											<c:out value="${product.product_name}" /><br>
											<a class="btn btn-primary" href="/Catering/ProductController?action=updateProduct&product_id=<c:out value="${product.product_id}" />">Update</a>
											<a class="btn btn-primary" href="/Catering/ProductController?action=deleteProduct&product_id=<c:out value="${product.product_id}" />">Delete</a>
										</div>
									</div>			
								</div>
							</div>
						</c:forEach>
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<a class="btn btn-primary" href="addDaging.html">Add</a>
									</div>
								</div>
							</div>
						</div>
					</div>
						
					<div class="features_items">
						<h2 id="ayam" class="title text-center">Masakan Ayam</h2>
						<c:forEach items="${ayam}" var="product">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="data:image/jpg;base64,${product.base64Image}"/>
											<h2>RM <fmt:formatNumber minFractionDigits="2" value="${product.product_unitPrice}" /></h2>
											<c:out value="${product.product_name}" /><br>
											<a class="btn btn-primary" href="/Catering/ProductController?action=updateProduct&product_id=<c:out value="${product.product_id}" />">Update</a>
											<a class="btn btn-primary" href="/Catering/ProductController?action=deleteProduct&product_id=<c:out value="${product.product_id}" />">Delete</a>
										</div>
									</div>			
								</div>
							</div>
						</c:forEach>
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<a class="btn btn-primary" href="addAyam.html">Add</a>
									</div>
								</div>
							</div>
						</div>
					</div>
						
					
						
					<div class="features_items">
						<h2 id="sayur" class="title text-center">Sayur-sayuran</h2>	
						<c:forEach items="${sayur}" var="product">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="data:image/jpg;base64,${product.base64Image}"/>
											<h2>RM <fmt:formatNumber minFractionDigits="2" value="${product.product_unitPrice}" /></h2>
											<c:out value="${product.product_name}" /><br>
											<a class="btn btn-primary" href="/Catering/ProductController?action=updateProduct&product_id=<c:out value="${product.product_id}" />">Update</a>
											<a class="btn btn-primary" href="/Catering/ProductController?action=deleteProduct&product_id=<c:out value="${product.product_id}" />">Delete</a>
										</div>
									</div>			
								</div>
							</div>
						</c:forEach>
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<a class="btn btn-primary" href="addSayur.html">Add</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
					
					<div class="features_items">
					<h2 id="minuman" class="title text-center">Minuman</h2>
					<c:forEach items="${minuman}" var="product">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="data:image/jpg;base64,${product.base64Image}"/>
											<h2>RM <fmt:formatNumber minFractionDigits="2" value="${product.product_unitPrice}" /></h2>
											<c:out value="${product.product_name}" /><br>
											<a class="btn btn-primary" href="/Catering/ProductController?action=updateProduct&product_id=<c:out value="${product.product_id}" />">Update</a>
											<a class="btn btn-primary" href="/Catering/ProductController?action=deleteProduct&product_id=<c:out value="${product.product_id}" />">Delete</a>
										</div>
									</div>			
								</div>
							</div>
						</c:forEach>
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<a class="btn btn-primary" href="addMinuman.html">Add</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
				
					<div class="features_items">
						<h2 id="Service" class="title text-center">Service</h2>
							<h2 class="title text-center">1 each</h2>
							<c:forEach items="${services}" var="product">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="data:image/jpg;base64,${product.base64Image}"/>
											<h2>RM <fmt:formatNumber minFractionDigits="2" value="${product.product_unitPrice}" /></h2>
											<c:out value="${product.product_name}" /><br>
											<a class="btn btn-primary" href="/Catering/ProductController?action=updateProduct&product_id=<c:out value="${product.product_id}" />">Update</a>
											<a class="btn btn-primary" href="/Catering/ProductController?action=deleteService&product_id=<c:out value="${product.product_id}" />">Delete</a>
										</div>
									</div>			
								</div>
							</div>
						</c:forEach>
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<a class="btn btn-primary" href="addService.html">Add</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					
						</div>
					</div><!--features_items-->
				
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