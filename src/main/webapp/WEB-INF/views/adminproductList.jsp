<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/adminheader.jsp"%>
<%@ include file="/WEB-INF/views/template/sidebar.jsp"%>
<%@ taglib prefix="imgtag" uri="/WEB-INF/tlds/img_tag" %>

<script>

    $(document).ready(function(){
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu": [[1,2,3,5,10, -1], [1,2,3,5,10, "All"]],
            "oSearch" : {"sSearch": searchCondition}
        });
    });
</script>
        <div class="page-header">
            <h1>Modify Inventory</h1>
        </div>
        <table class="table table-striped" >
                <tr class="bg-success">
                    <th>Product Thumb</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th>Edit </th>
                    <th>Delete</th>
                </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td> <imgtag:imgTag blob="${product.imagebytes}"  id="product_${product.productId}" height="50px" width="50px"/></td>
                    <td>${product.productName}</td>
                    <td>${product.category.categoryName}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD </td>
                    <td><a href="<c:url value="/admin/product/editProduct/${product.productId}" />" > Edit Product <span class="glyphicon glyphicon-info-sign"></span></a></td>
                	 <td><a href="<c:url value="/admin/product/deleteProduct/${product.productId}" />" > Delete Product <span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
        </table>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>