<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h3><img class="img-circle floatLeft" src="<c:url value="/resources/images/shop-cart-icon.png"/>">
                    Checkout - Customer Details</h3>
                    <p>Your public information will be visible on your profile page.</p>
                </div>
            </div>
        </section>
        <form:form commandName="order" class="form-horizontal">
			<fieldset>
				<legend>Basic Info:</legend>
				  <div class="form-group">
			            <label for="name">Name</label>
			            <form:errors path="cart.customer.customerName" cssStyle="color: #ff0000" />
			            <form:input path="cart.customer.customerName" id="name" class="form-Control" />
			        </div>
			
			        <div class="form-group">
			            <label for="email">Email</label>
			            <form:errors path="cart.customer.customerEmail" cssStyle="color: #ff0000" />
			            <form:input path="cart.customer.customerEmail" id="email" class="form-Control" />
			        </div>
			
			        <div class="form-group">
			            <label for="phone">Phone</label>
			            <form:input path="cart.customer.customerPhone" id="phone" class="form-Control" />
			        </div>
			</fieldset>
      		<fieldset>
				<legend>Billing Address:</legend>
				<div class="form-group">
		            <label for="billingStreet">Street Name</label>
		            <form:errors path="cart.customer.billingAddress.streetName" cssStyle="color: #ff0000" />
		            <form:input path="cart.customer.billingAddress.streetName" id="billingStreet" class="form-Control" />
		        </div>
		
		        <div class="form-group">
		            <label for="billingApartmentNumber">Apartment Number</label>
		            <form:input path="cart.customer.billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control" />
		        </div>
		
		        <div class="form-group">
		            <label for="billingCity">City</label>
		             <form:errors path="cart.customer.billingAddress.city" cssStyle="color: #ff0000" />
		            <form:input path="cart.customer.billingAddress.city" id="billingCity" class="form-Control" />
		        </div>
		
		        <div class="form-group">
		            <label for="billingState">State</label>
		            <form:errors path="cart.customer.billingAddress.state" cssStyle="color: #ff0000" />
		            <form:input path="cart.customer.billingAddress.state" id="billingState" class="form-Control" />
		        </div>
		
		        <div class="form-group">
		            <label for="billingCountry">Country</label>
		            <form:errors path="cart.customer.billingAddress.country" cssStyle="color: #ff0000" />
		            <form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-Control" />
		        </div>
		
		        <div class="form-group">
		            <label for="billingZip">Zipcode</label>
		             <form:errors path="cart.customer.billingAddress.zipCode" cssStyle="color: #ff0000" />
		            <form:input path="cart.customer.billingAddress.zipCode" id="billingZip" class="form-Control" />
		        </div>
		
		        <input type="hidden" name="_flowExecutionKey" />
			</fieldset>

        <input type="submit" value="Next" class="btn btn-success btnWidth100" name="_eventId_itemsCollected" />

        <button class="btn btn-danger pull-left btnWidth100" name="_eventId_cancel">Cancel</button>

        </form:form>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>