<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="wrapper">
	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="#">  </a></li>
			<li><a href="<c:url value="/admin/" />"><spring:message code="label.admin.dashboard"/></a></li>

			<li><a href="<c:url value="/admin/customer" />">C<spring:message code="label.admin.customer.management"/></a></li>
			<li>
				<div>
					<a data-toggle="collapse" href="#collapse1"><spring:message code="label.admin.category.management"/></a>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body">
						<a href="<c:url value="/admin/category/addCategory" />"><spring:message code="label.admin.category.add"/></a>
					</div>
					<div class="panel-body">
						<a href="<c:url value="/admin/categoryList/all" />"><spring:message code="label.admin.category.view"/></a>
					</div>
				</div>
			</li>
			<li>
				<div>
					<a data-toggle="collapse" href="#collapse2"><spring:message code="label.admin.product.management"/></a>
				</div>
				<div id="collapse2" class="panel-collapse collapse">
					<div class="panel-body">
						<a href="<c:url value="/admin/product/addProduct" />"><spring:message code="label.admin.product.add"/></a>
					</div>
					<div class="panel-body">
						<a href="<c:url value="/admin/productList/all" />"><spring:message code="label.admin.product.view"/></a>
					</div>
				</div>
			</li>
		</ul>
	</div>


	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/" />">MUM E-Store</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/"><spring:message code="label.header.home"/></a></li>
				<li><a href="<c:url value="/admin/category/addCategory" />"><spring:message code="label.admin.category.add"/></a></li>
				<li><a href="<c:url value="/admin/categoryList/all" />"><spring:message code="label.admin.category.view"/></a></li>
				<li><a href="<c:url value="/admin/product/addProduct" />"><spring:message code="label.admin.product.add"/></a></li>
				<li><a href="<c:url value="/admin/productList/all" />"><spring:message code="label.admin.product.view"/></a></li>
				<li><a href="<c:url value="/admin/customer" />"><spring:message code="label.admin.customer.management"/></a></li>
				<li>
				</li>
			</ul>
			<div class="nav navbar-nav pull-right">
				<li>
				<a href="<c:url value="/j_spring_security_logout" />"> <spring:message code="label.logout"/></a>
				</li>
			</div>
		</div>
	</nav>

	<div class="page-content-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<br> <br>