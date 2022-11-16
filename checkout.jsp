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
    <title>Cart | MH CATERING</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link href="css/loginheader.css" rel="stylesheet">
	<link href="css/image.css" rel="stylesheet">
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
								<li><a href="/Catering/OrderController?action=listCustomerOrder"><i class="fa fa-shopping-cart"></i> Orders</a></li>
								<li><a href="/Catering/CheckoutController?action=view" class="active"><i class="fa fa-crosshairs"></i> Checkout</a></li>
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
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Check out</li>
				</ol>
			</div><!--/breadcrums-->

			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info">
						<form method="POST" action="CheckoutController">
						<p>Name</p>
							<input type="text" id="name" name="name" value="<%= request.getAttribute("name")%>" readonly>
							<p>Email</p>
							<input type="text" id="name" name="email" value="<%= request.getAttribute("email")%>" readonly>
						<p>Date</p>
							<input type="date" id="date" name="date" required>
						
						</div>
					</div>
					<div class="col-sm-5 clearfix">
						<div class="bill-to">
							<p>Address</p>
							<div class="form-one">
									<textarea id="address" name="address" placeholder="Home Address" rows="10"></textarea>
									<input type="hidden" name="orderTotal" value="<c:out value="${cart.orderTotal}" />">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
					<jsp:useBean id="cart" scope="session" class="catering.dao.CartDAO" />
  						<c:if test="${cart.lineItemCount==0}">
  						  <tr>
						  <td colspan="4" style="border:none">- Cart is currently empty -<br/>
						  </tr>
						  </c:if>
 					 <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
 					
						<tr>
								<input type="hidden" name="itemIndex" value="<c:out value="${counter.count}"/>">
								<input type="hidden" name="product_id" value="<c:out value="${cartItem.product_id}" />">
							
							<td class="cart_description">
							
								<p class="cart_total_price"><c:out value="${cartItem.product_name}" /></p>
							</td>
							<td class="cart_price">
	
								<p><fmt:formatNumber minFractionDigits="2" value="${cartItem.unitPrice}" /></p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
								<input type="hidden" name="quantity" value="<c:out value="${cartItem.orderQtty}" />">
									<input class="cart_quantity_input" type="text" name="quantity" id="quantity" placeholder="${cartItem.orderQtty}" size="2" readonly>
									
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">RM <fmt:formatNumber minFractionDigits="2" value="${cartItem.totalamount}" /></p>
							</td>
							 <td class="cart_delete">
							</td>
						</tr>
						</c:forEach>
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Total</td>
										
										<td><span>RM <fmt:formatNumber minFractionDigits="2" value="${cart.orderTotal}" /></span></td>
									</tr>
									<tr>
										<td><button class="btn btn-primary pull-left">Confirm</button></td>
									</tr>
								</table>
							</td>
							</form>
						</tr>
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