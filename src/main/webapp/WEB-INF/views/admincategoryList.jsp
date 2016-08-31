<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/adminheader.jsp"%>
<%@ include file="/WEB-INF/views/template/sidebar.jsp"%>
<%@ taglib prefix="imgtag" uri="/WEB-INF/tlds/img_tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <h1>Modify Category</h1>
        </div>
        <table class="table table-striped" >
                <tr class="bg-success">
                    <th>Category Thumb</th>
                    <th>Category Name</th>
                    <th>Description</th>
                    <th>Edit </th>
                    <th>Delete</th>
                </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td> <imgtag:imgTag blob="${category.imagebytes}"  id="category_${category.categoryId}" height="50px" width="50px"/></td>
                    <td>${category.categoryName}</td>
                    <td>${category.categoryDescription}</td>
                    <td><a href="<c:url value="/admin/category/editCategory/${category.categoryId}" />" > Edit Category <span class="glyphicon glyphicon-info-sign"></span></a></td>
                	 <td><a href="<c:url value="/admin/category/deleteCategory/${category.categoryId}" />" > Delete Category <span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
        </table>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>