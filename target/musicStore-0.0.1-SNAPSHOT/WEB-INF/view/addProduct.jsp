<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/view/templates/header.jsp"%>
<div class="wrapper">
	<div class="container">
		<div class="row">
			<div class="page-header">
				<h1 class="lead	">Add Product</h1>
				<p>Fill the below information to add product:</p>
			</div>
			<form:form
				action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
				method="post" commandName="product" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name">Name</label>
					<form:input path="productName" id="name" class="form-Control" />
				</div>
				<div class="form-group">
					<label for="category">Category</label> <label
						class="checkbox-inline"> <form:radiobutton
							path="productCategory" id="category" value="instrument" />
						Instrument
					</label> <label class="checkbox-inline"> <form:radiobutton
							path="productCategory" id="category" value="record" /> Record
					</label> <label class="checkbox-inline"> <form:radiobutton
							path="productCategory" id="category" value="accesory" /> Accesory
					</label>
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<form:textarea path="productDescription" id="description"
						class="form-Control" />
				</div>
				<div class="form-group">
					<label for="price">Price</label>
					<form:input path="productPrice" id="price" class="form-Control" />
				</div>
				<div class="form-group">
					<label for="condition">Condition</label> <label
						class="checkbox-inline"><form:radiobutton
							path="productCondition" id="condition" value="new" /> New</label> <label
						class="checkbox-inline"><form:radiobutton
							path="productCondition" id="condition" value="Used" /> Used</label>
				</div>
				<div class="form-group">
					<label for="unitInStock">Unit In Stock</label>
					<form:input path="unitInStock" class="form-Control" />
				</div>
				<div class="form-group">
					<label class="control-label" for="productImage">Upload
						Picture</label>
					<form:input id="productImage" path="productImage" type="file"
						class="form:input-large" />
				</div>
				<br></br>
				<input type="submit" class="btn btn-default" value="submit">
				<a href='<c:url value="/admin/productInventory"></c:url>'>Cancel</a>
			</form:form>
		</div>

		<%@include file="/WEB-INF/view/templates/footer.jsp"%>