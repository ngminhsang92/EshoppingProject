<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="../../favicon.ico">

	<title>Electronic Store</title>

	<!-- Angular.JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


	<!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

	<!-- MaCarouselin CSS -->
	<link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

	<!-- Main CSS -->
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


	<link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
	<script>
		var contextPath = "${pageContext.request.contextPath}";
	</script>
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-background">
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">EShopping</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="<c:url value="/" />"><spring:message code="label.header.home"/></a></li>
							<li><a href="<c:url value="/product/productList/all" />"><spring:message code="label.header.product"/></a></li>
							<li><a href="<c:url value="/about" />"><spring:message code="label.header.aboutus"/></a></li>
						</ul>
						<ul class="nav navbar-nav pull-right">
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
								<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value="/customer/cart" />"><spring:message code="label.header.cart"/></a></li>
								</c:if>

								<li><a href="<c:url value="/j_spring_security_logout" />"><spring:message code="label.logout"/></a></li>

								<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
									<li><a href="<c:url value="/admin" />"><spring:message code="label.administrator"/></a></li>
								</c:if>

							</c:if>
							<li style="margin-right: -11px;line-height: 50px;color: white;">Language :</li>
							<li style="margin-right: -14px;"><a href="?lang=en">English</a></li>
							<li style="line-height: 50px;">|</li>
							<li style="margin-left: -14px;"><a href="?lang=es">Spanish</a></li>
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<li><a href="<c:url value="/login" />"><spring:message code="label.login"/></a></li>
								<li><a href="<c:url value="/register" />"><spring:message code="label.register"/></a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<div id="nav-search" class="col-md-8 col-md-offset-2">
					<form accept-charset="utf-8" action="/product/search" class="nav-searchbar" method="GET" name="site-search" role="search">

						<div class="nav-left">
							<div class="nav-search-scope nav-sprite">
								<select id="searchDropdownBox"  class="nav-search-dropdown searchSelect" name="category" tabindex="18" title="Search in" >
									<option value="all">All Categories</option>
									<c:forEach items="${categories}" var="category">
										<option value="${category.categoryId}">${category.categoryName}</option>
									</c:forEach>
								</select>
								<select id="width_tmp_select">
									<option id="width_tmp_option"></option>
								</select>
							</div>
						</div>
						<div class="input-group">
							<input type="text" name="keyword" class="form-control" placeholder="Search..">
							<span class="input-group-btn">
			<input type="submit" class="btn btn-default" value="Search"/>
		  </span>
						</div>
						<script>
							$(document).ready(function() {
								$('#searchDropdownBox').change(function(){
									$("#width_tmp_option").html($('#searchDropdownBox option:selected').text());
									$(this).width($("#width_tmp_select").width());
								});
							});
						</script>
						<style>

							#width_tmp_select{
								display : none;
							}
						</style>
					</form>
				</div>
			</nav>

		</div>
	</div>

</div>