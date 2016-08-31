<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register"
                   method="post" commandName="customer">

        <h3>Basic Info:</h3>

        <div class="form-group">
            <label for="name">Name *</label>
            <form:errors path="customerName" cssStyle="color: #ff0000" />
            <form:input path="customerName" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="email">Email *</label>
            <span style="color: #ff0000">${emailMsg}</span>
            <form:errors path="customerEmail" cssStyle="color: #ff0000" />
            <form:input path="customerEmail" id="email" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="customerPhone" id="phone" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="username">Username *</label>
            <span style="color: #ff0000">${usernameMsg}</span>
            <form:errors path="username" cssStyle="color: #ff0000" />
            <form:input path="username" id="username" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="password">Password *</label>
            <form:errors path="password" cssStyle="color: #ff0000" />
            <form:password path="password" id="password" class="form-Control" />
        </div>

        <br/>

        <h3>Billing Address:</h3>

        <div class="form-group">
            <label for="billingStreet">Street Name *</label>
            <form:errors path="billingAddress.streetName" cssStyle="color: #ff0000" />
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:errors path="billingAddress.apartmentNumber" cssStyle="color: #ff0000" />
            <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCity">City *</label>
            <form:errors path="billingAddress.city" cssStyle="color: #ff0000" />
            <form:input path="billingAddress.city" id="billingCity" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingState">State *</label>
            <form:errors path="billingAddress.state" cssStyle="color: #ff0000" />
            <form:input path="billingAddress.state" id="billingState" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCountry">Country *</label>
            <form:errors path="billingAddress.country" cssStyle="color: #ff0000" />
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingZip">Zipcode *</label>
            <form:errors path="billingAddress.zipCode" cssStyle="color: #ff0000" />
            <form:input path="billingAddress.zipCode" id="billingZip" class="form-Control" />
        </div>

        <br/>

        <h3>Shipping Address:</h3>

		<div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" onclick="SetShipping(this.checked);"> same as billing</label>
        </div>
        
        <div class="form-group" id="shippingStreetField">
            <label for="shippingStreet">Street Name *</label>
            <form:errors path="shippingAddress.streetName" cssStyle="color: #ff0000" />
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control" />
        </div>

        <div class="form-group" id="shippingApartmentNumberField">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:errors path="shippingAddress.apartmentNumber" cssStyle="color: #ff0000" />
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control" />
        </div>

        <div class="form-group" id="shippingCityField">
            <label for="shippingCity">City *</label>
            <form:errors path="shippingAddress.city" cssStyle="color: #ff0000" />
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control" />
        </div>

        <div class="form-group" id="shippingStateField">
            <label for="shippingState">State *</label>
            <form:errors path="shippingAddress.state" cssStyle="color: #ff0000" />
            <form:input path="shippingAddress.state" id="shippingState" class="form-Control" />
        </div>

        <div class="form-group" id="shippingCountryField">
            <label for="shippingCountry">Country *</label>
            <form:errors path="shippingAddress.country" cssStyle="color: #ff0000" />
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-Control" />
        </div>

        <div class="form-group" id="shippingZipField">
            <label for="shippingZip">Zipcode *</label>
            <form:errors path="shippingAddress.zipCode" cssStyle="color: #ff0000" />
            <form:input path="shippingAddress.zipCode" id="shippingZip" class="form-Control" />
        </div>

        <br/><br/>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>

        </form:form>
        
<!-- My -->
<script src="<c:url value="/resources/js/registerCustomer.js?v3" /> "></script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>