<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="imgtag" uri="/WEB-INF/tlds/img_tag" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>


            <p class="lead">Here is the detail information of the product:</p>
        </div>

        <div class="container" ng-app = "cartApp">
            <div class="row">
                <div class="col-md-5">
					<imgtag:imgTag blob="${product.imagebytes}"  id="product_${product.productId}"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p><strong>Manufacturer</strong>: ${product.productManufacturer}</p>
                    <p><strong>Category</strong>: ${product.category.categoryName}</p>
                    <p><strong>Condition</strong>: ${product.productCondition}</p>
                    <p>${product.productPrice} USD</p>

                    <br/>

                    <c:set var = "url" scope="page" value="/product/productList/all" />
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </sec:authorize>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value = "${url}" />" class="btn btn-default">Back</a>
                       	<c:if test="${product.unitInStock > 0}">
                        	<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                        	<a href="<spring:url value="/customer/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                        </c:if>
                      	<c:if test="${product.unitInStock == 0}">
                        	<label class="outOfStock"><span class="glyphicon"></span> Out of stock</label>
                        </c:if>
                    </p>

                </div>
            </div>
        </div>


<!-- My -->
<script src="<c:url value="/resources/js/controller.js?v3" /> "></script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
