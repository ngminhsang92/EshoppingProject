<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
         <section>
            <div class="jumbotron">
                <div class="container">
                    <h3><img class="img-circle floatLeft" src="<c:url value="/resources/images/shop-cart-icon.png"/>">
                    Checkout - Shipping Address</h3>
                    <p>Future mailing labels will appear exactly as you enter them below.</p>
                </div>
            </div>
        </section>
        <form:form commandName="order" class="form-horizontal">

        <h3>Shipping Address:</h3>

        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:errors path="cart.customer.shippingAddress.streetName" cssStyle="color: #ff0000" />
            <form:input path="cart.customer.shippingAddress.streetName" id="shippingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:errors path="cart.customer.shippingAddress.city" cssStyle="color: #ff0000" />
            <form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:errors path="cart.customer.shippingAddress.state" cssStyle="color: #ff0000" />
            <form:input path="cart.customer.shippingAddress.state" id="shippingState" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:errors path="cart.customer.shippingAddress.country" cssStyle="color: #ff0000" />
            <form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingZip">Zipcode</label>
            <form:errors path="cart.customer.shippingAddress.zipCode" cssStyle="color: #ff0000" />
            <form:input path="cart.customer.shippingAddress.zipCode" id="shippingZip" class="form-Control" />
        </div>

        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>

        <button class="btn btn-primary btnWidth100" name="_eventId_backToItemsInfoPage">Back</button>

        <input type="submit" value="Next" class="btn btn-success btnWidth100" name="_eventId_shippingCollected" />

        <button class="btn btn-danger btnWidth100 " name="_eventId_cancel">Cancel</button>

        </form:form>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>