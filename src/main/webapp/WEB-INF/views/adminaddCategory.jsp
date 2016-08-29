<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/adminheader.jsp"%>
<%@ include file="/WEB-INF/views/template/sidebar.jsp"%>





				<div class="page-header">
					<h1>Add Category</h1>
					<p class="lead">Fill the below information to add a Category:</p>
				</div>

				<form:form
					action="${pageContext.request.contextPath}/admin/category/addCategory"
					method="post" commandName="category" enctype="multipart/form-data">
					<div class="form-group">
						<label for="name">Name</label>
						<form:errors path="categoryName" cssStyle="color:#ff0000;" />
						<form:input path="categoryName" id="name" class="form-Control" />
					</div>

					<div class="form-group">
						<label for="description">Description</label>
						<form:textarea path="categoryDescription" id="description"
							class="form-Control" />
					</div>

					<div class="form-group">
						<label class="control-label" for="coverImage">Upload
							Picture</label>
						<form:input id="coverImage" path="coverImage" type="file"
							class="form:input-large" />
					</div>

					<br />
					<br />

					<input type="submit" value="submit" class="btn btn-default">
					<a href="<c:url value="/admin/categoryList/all" />"
						class="btn btn-default">Cancel</a>

				</form:form>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp"%>