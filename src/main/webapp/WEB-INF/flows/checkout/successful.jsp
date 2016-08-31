<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
		<section>
            <div class="jumbotron">
                <div class="container">
                    <h3><img class="img-circle " src="<c:url value="/resources/images/shopping-basket-accept-icon.png"/>">
                     Order - Successful</h3>
                </div>
                
            </div>
            <div class="successful-box">
	             <p>We have received your order and it is now being processed. 
	                We will be dispatching your order soon.</p>
				<p>If you have any additional queries or issues please contact to our assistance for more details!</p>
			</div>
        </section>
        <section class="container">
            <p><a href="<spring:url value="/" />" class="btn btn-success btnWidth100">Go Home</a></p>
        </section>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>