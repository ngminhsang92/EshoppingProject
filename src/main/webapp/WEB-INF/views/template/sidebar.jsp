
<div id="wrapper">
	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="#">  </a></li>
			<li><a href="<c:url value="/admin/" />">Dashboard</a></li>

			<li><a href="<c:url value="/admin/customer" />">Customer
					Management</a></li>
			<li>
				<div>
					<a data-toggle="collapse" href="#collapse1">Product Management</a>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body">
						<a href="<c:url value="/admin/product/addProduct" />">Add
							Product</a>
					</div>
					<div class="panel-body">
						<a href="<c:url value="/admin/productList/all" />">View
							Inventory</a>
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
				<li class="active"><a href="#">Home</a></li>
				<li><a href="<c:url value="/admin/product/addProduct" />">Add
						Product</a></li>
				<li><a href="<c:url value="/admin/productList/all" />">View
						Inventory</a></li>
				<li><a href="<c:url value="/admin/customer" />">Customer
						Management</a></li>
				<li>
				</li>
			</ul>
			<div class="nav navbar-nav pull-right">
				<li>
				<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
				</li>
			</div>
		</div>
	</nav>

	<div class="page-content-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<br> <br>