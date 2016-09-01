<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="imgtag" uri="/WEB-INF/tlds/img_tag" %>

        <!-- Carousel
        ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <c:set var="flag" value="active"/>
                <c:forEach items="${categories}" var="category">
                    <div class="item ${flag}">
                        <a class="btn btn-default" href="<c:url value="/product/productList?category=${category.categoryId}" />" role="button">
                        <imgtag:imgTag blob="${category.imagebytes}"  id="category_${category.categoryId}" cssClass="first-slide home-image" height="auto" width="auto"/>
                        </a>
                    </div>
                    <c:set var="flag" value=""/>
                </c:forEach>

            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->


        <!-- Marketing messaging and featurettes
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

		<div class="container marketing">
    	<div class="container">
    	<!-- Three columns of text below the carousel -->
            <h2><spring:message code="label.home.categories"/></h2>
            <div class="row">
                <c:forEach items="${categories}" var="category">
                    <div class="col-lg-4">
                        <a class="btn btn-default" href="<c:url value="/product/productList?category=${category.categoryId}" />" role="button">
                            <imgtag:imgTag blob="${category.imagebytes}"  id="category_${category.categoryId}" height="140" width="140"/>
                        </a>

                        <h2>${category.categoryName}</h2>

                    </div>
                </c:forEach>
            </div>
            <hr/>
            <h2><spring:message code="label.home.recent.product"/></h2>
            <div class="row">
            
	             <c:forEach items="${products}" var="product">
	                   <div class="col-lg-4">
		                    <a class="btn btn-default" href="<c:url value="/product/viewProduct/${product.productId}" />" role="button">
		                       <imgtag:imgTag blob="${product.imagebytes}"  id="product_${product.productId}" height="140" width="140"/>
		                    </a>
		
		                    <h2>${product.productName}</h2>
		                    <p>${product.productDescription}</p>
		
		                </div>
	            </c:forEach>
            </div>
		</div>


<%@ include file="/WEB-INF/views/template/footer.jsp" %>
