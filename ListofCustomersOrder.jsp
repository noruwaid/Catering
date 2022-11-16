<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		h4#h41 {text-align: center;}
		}
	</style>
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
                                        <li><a href="shop.html" >Food Menu/Services</a></li>
								
                                    </ul>
                                </li> -->
								<li><a href="/Catering/StaffOrderController?action=ListofCustomersOrder" class="active">Order List</a></li>
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
                            <td class="total">Update Order</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${pending}" var="order">
						<tr>
						
							<td class="cart_product">
								<h4 id="h41" ><a href="/Catering/OrderController?action=adminCustomer&orderid=<c:out value="${order.orderid}"/>"><c:out value="${order.orderid}"/></a></h4>
							</td>
							<td class="cart_description">
								<h4><a href="vieweachorder.html"></a></h4>
									<h4><c:out value="${order.date}" /></h4>
							</td>
							<td class="cart_price">
									<c:out value="${order.orderstatus}" />
							</td>
							<td class="cart_quantity">
								<div>
								<a class="btn btn-primary" href="">View</a>
								</div>
							</td>
							<td class="cart_delete">
								<form method="POST" action="StaffOrderController">
								<input type="hidden" name="orderid" value="<c:out value="${order.orderid}" />"/>
								<input type="submit" class="btn btn-primary" name="action" value="Update"></input>
								</form>
							</td>		
						</tr>
					</c:forEach>
					</tbody>
				</table>
					
			</div>
			
			
			<h4>Customer's Request Cancellation Orders</h4>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Order ID</td>
							<td class="description">Date</td>
							<td class="price">Status Order</td>
							<td class="quantity">Invoice</td>
                            <td class="total">Delete Order</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${cancellations}" var="order">
						<tr>
						
							<td class="cart_product">
								<h4 id="h41"><c:out value="${order.orderid}"/></h4>
							</td>
							<td class="cart_description">
								<h4><a href="vieweachorder.html"></a></h4>
									<h4><c:out value="${order.date}" /></h4>
							</td>
							<td class="cart_price">
									<c:out value="${order.orderstatus}" />
							</td>
							<td class="cart_quantity">
								<div>
								<a class="btn btn-primary" href="">View</a>
								</div>
							</td>		
							<td class="cart_delete">
								<form method="POST" action="StaffOrderController">
								<input type="hidden" name="orderid" value="<c:out value="${order.orderid}" />"/>
								<input type="submit" class="btn btn-primary" name="action" value="Delete"></input>
								</form>
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
							<td class="description">Date </td>
							<td class="price">Status Order</td>
							<td class="price">Invoice</td>
							
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${confirmed}" var="order">
						<tr>
							<td class="cart_product">
								<h4 id="h41"><c:out value="${order.orderid}"/></h4>
							</td>
							<td class="cart_description">
								<h4><a href="vieweachorder.html"></a></h4>
									<h4><c:out value="${order.date}" /></h4>
							</td>
							<td class="cart_price">
								<h4><c:out value="${order.orderstatus}" /></h4>
							</td>
							<td class="cart_quantity">
								<div>
								<a class="btn btn-primary" href="">View</a>
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