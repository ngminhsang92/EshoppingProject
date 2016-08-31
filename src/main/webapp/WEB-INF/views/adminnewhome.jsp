<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/adminheader.jsp"%>
<%@ include file="/WEB-INF/views/template/sidebar.jsp"%>
<%@ page import="java.io.*,java.util.*"%>

<body>
	<br>
	<br>
	<br>


	<div class="row four-grids">
		<div class="col-md-3 ticket-grid">
			<div class="tickets">
				<div class="grid-left">
					<div class="book-icon">
						<i class="fa fa-rocket"></i>
					</div>
				</div>
				<div class="grid-right">
					<h3>
						Total <span>Orders</span>
					</h3>
					<p>${noofproducts}</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="col-md-3 ticket-grid">
			<div class="tickets">
				<div class="grid-left">
					<div class="book-icon">
						<i class="fa fa-bar-chart"></i>
					</div>
				</div>
				<div class="grid-right">
					<h3>
						Total <span>Customers</span>
					</h3>
					<p>${totalcustomers}</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="clearfix"></div>
	</div>

	<table class="table table-striped table-hover">
		<thead>
			<tr class="bg-success">
				<th>Customer Name</th>
				<th>Phone No.</th>
				<th>Shipping Address</th>
			</tr>
		</thead>
		<c:forEach items="${top5order}" var="order">
			<tr>
				<td>${order.customer.customerName}</td>
				<td>${order.customer.customerPhone}</td>
				<td>${order.shippingAddress.streetName},
					${order.shippingAddress.apartmentNumber},
					${order.shippingAddress.city}, ${order.shippingAddress.state}</td>
				</td>

			</tr>
		</c:forEach>
	</table>



</body>

</html>
