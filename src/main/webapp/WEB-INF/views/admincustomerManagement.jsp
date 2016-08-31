<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/adminheader.jsp"%>
<%@ include file="/WEB-INF/views/template/sidebar.jsp"%>


        <div class="page-header">
            <h1>Customer Management</h1>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Enabled</th>
            </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.username}</td>
                    <td> <a href="<c:url value="/admin/customer/enableDisable/${customer.customerId}" />">
                    <c:if test="${customer.enabled==true}">
                        <button class="btn btn-xs btn-primary active">ON</button>
					    <button class="btn btn-xs btn-default">OFF</button>
                    </c:if>
                    <c:if test="${customer.enabled==false}">
                        <button class="btn btn-xs btn-default">ON</button>
					    <button class="btn btn-xs btn-primary active">OFF</button>
                    </c:if>
                    </a></td>
                </tr>
            </c:forEach>
        </table>

<%@ include file="/WEB-INF/views/template/footer.jsp"%>