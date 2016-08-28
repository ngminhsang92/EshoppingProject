<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <div class="item active">
                    <img class="first-slide home-image" src="<c:url value="/resources/images/back1.jpg" />" alt="First slide">
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="<c:url value="/resources/images/back2.jpg" />" alt="Second slide">
                </div>
                <div class="item">
                    <img class="third-slide home-image " src="<c:url value="/resources/images/back3.jpg" />" alt="Third slide">
                </div>
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
            <h2>Categories:</h2>
            <div class="row">
                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Television" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/television.jpg"/>" alt="Instrument Image" width="140" height="140">
                    </a>

                    <h2>Television</h2>

                </div>



                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Computers" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/notebook.jpg"/>" alt="Instrument Image" width="140" height="140">
                    </a>

                    <h2>Computers</h2>

                </div>


                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Cell Phones" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/smartphone.jpg"/>" alt="Instrument Image" width="140" height="140">
                    </a>

                    <h2>Cell Phones</h2>

                </div>
            </div>
            <hr/>
            <h2>Recent products:</h2>
            <div class="row">
            
	             <c:forEach items="${products}" var="product">
	                   <div class="col-lg-4">
		                    <a class="btn btn-default" href="<c:url value="/product/viewProduct/${product.productId}" />" role="button">
		                       <imgtag:imgTag blob="${product.imagebytes}"  id="${product.productId}" height="140" width="140"/>
		                    </a>
		
		                    <h2>${product.productName}</h2>
		                    <p>${product.productDescription}</p>
		
		                </div>
	            </c:forEach>
            </div>
		</div>


<%@ include file="/WEB-INF/views/template/footer.jsp" %>
