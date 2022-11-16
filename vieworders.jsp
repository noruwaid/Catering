<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
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
								<li><a href="/Catering/OrderController?action=listCustomerOrder" class="active"><i class="fa fa-shopping-cart"></i> Orders</a></li>
								<li><a href="/Catering/CheckoutController?action=view"><i class="fa fa-crosshairs"></i> Checkout</a></li>
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
								<li class="dropdown"><a href="/Catering/ProductController?action=listCustomerProduct" >Menu</a></li>
                                   <!-- <ul role="menu" class="sub-menu">
                                        <li><a href="shop.jsp" class="active">Food Menu/Services</a></li>
								
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
		</div><!--/header-bottom-->
	</header><!--/header-->

	<section id="cart_items">
		<div>
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Orders</li>
				</ol>
			</div><!--/breadcrums-->
			
			<h4>Pending Orders</h4>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Order ID</td>
							<td class="description">Date</td>
							<td class="price">Status Order</td>
							<td class="quantity">Invoice</td>
                            <td class="total">Cancellation <br>Request</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${pending}" var="order">
						<tr>
						
							<td class="cart_product">
							<h4><a href="/Catering/OrderController?action=customer&orderid=<c:out value="${order.orderid}"/>"><c:out value="${order.orderid}"/></a></h4>	
							</td>
							<td class="cart_description">
					
								<h4><c:out value="${order.date}" /></h4>
							</td>
							<td class="cart_price">
									<c:out value="${order.orderstatus}" />
							</td>
							<td class="cart_quantity">
								<div>
								<a class="btn btn-primary" href="/Catering/OrderController?action=invoice&orderid=<c:out value="${order.orderid}"/>">View</a>
								</div>
							</td>
							<td class="cart_delete">
								<form method="POST" action="OrderController">
								<input type="hidden" name="orderid" value="<c:out value="${order.orderid}" />"/>
								<input type="submit" class="btn btn-primary" name="action" value="Cancel"></input>
								</form>
							</td>		
						</tr>
					</c:forEach>
					</tbody>
				</table>
					
			</div>
			
			
			<h4>Request Cancellation Orders</h4>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Order ID</td>
							<td class="description">Date</td>
							<td class="price">Status Order</td>
							<td class="quantity">Invoice</td>
                           
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${cancellations}" var="order">
						<tr>
						
							<td class="cart_product">
							<h4><a href="/Catering/OrderController?action=customer&orderid=<c:out value="${order.orderid}"/>"><c:out value="${order.orderid}"/></a></h4>
							</td>
							<td class="cart_description">
								
									<h4><c:out value="${order.date}" /></h4>
							</td>
							<td class="cart_price">
									<c:out value="${order.orderstatus}" />
							</td>
							<td class="cart_quantity">
								<div>
								<a class="btn btn-primary" href="/Catering/OrderController?action=invoice&orderid=<c:out value="${order.orderid}"/>">View</a>
								</div>
							</td>	
						</tr>
					</c:forEach>
					</tbody>
				</table>
					
			</div>
			
			
			<h4>Confirmed and completed Order</h4>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Order ID</td>
							<td class="description">Date</td>
							<td class="price">Status Order</td>
							<td class="price">Invoice</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${confirmed}" var="order">
						<tr>
							<td class="cart_product">
							<h4><a href="vieweachorder.html"></a></h4>
								<h4><center><c:out value="${order.orderid}"/></center></h4>
							</td>
							<td class="cart_description">
								
									<h4><c:out value="${order.date}" /></h4>
							</td>
							<td class="cart_price">
								<h4><c:out value="${order.orderstatus}" /></h4>
							</td>
							<td class="cart_quantity">
								<div>
								<a class="btn btn-primary" href="/Catering/OrderController?action=invoice&orderid=<c:out value="${order.orderid}"/>">View</a>
								</div>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
					
			</div>
							
			</div>
			
		</div>
	</section> <!--/#cart_items-->

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>