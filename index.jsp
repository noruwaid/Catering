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
							<a href="index.jsp"><img src="images/home/MHCateringLogo.jfif" width="50%" height="50%" alt="" /></a>
						</div>
					</div>
					<div class="col-md-8 clearfix">
						<div class="shop-menu clearfix pull-right">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li class="dropdown"><a href="#"><i class="fa fa-lock"></i> Login <i class="fa fa-angle-down"></i></a>
                                    <ul role="login" class="sub-login">
										<li><a href="customerlogin.jsp"> Customer</a></li> 
										<li><a href="adminLogin.html"> Admin</a></li> 
                                    </ul>
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
								<li><a href="index.jsp" class="active">Home</a></li>
								<li class="dropdown"><a href="/Catering/ProductController?action=listProduct" >Menu</a></li>
                                   <!-- <ul role="menu" class="sub-menu">
                                        <li><a href="shop.jsp" class="active">Food Menu/Services</a></li>
								
                                    </ul>
                                </li> -->
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
		</div><!--/header-bottom-->
	</header><!--/header-->
	
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>MH</span>CATERING</h1>
									<h2></h2>
									<p>We provide the best catering services to you. Our catering is founded in 2006 with best knowledge to provide services that may suits your prefererences.
									<br>Order Now.
									</p>
								</div>
								<div class="col-sm-6">
									<img src="images/shop 2/ayam-merah.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							
				
							
						</div>
					
					
				</div>
			</div>
		</div>
		</div>
	</section><!--/slider-->
	

</body>
</html>