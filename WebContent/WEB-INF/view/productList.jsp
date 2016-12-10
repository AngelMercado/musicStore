<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/view/templates/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Products</h1>
			<p>Checkout All awesome products avaible now</p>

			<table class="table table-striped table-hover">
				<thead>
					<tr class="bg-success">
						<th>Photo Thumb</th>
						<th>ProductName</th>
						<th>Category</th>
						<th>Condition</th>
						<th>Price</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><img src='<c:url value="/resources/images/${product.productId}.png"/>' alt="image" style="width: 100%;"></td>
						<td>${product.productName}</td>
						<td>${product.productCategory}</td>
						<td>${product.productCondition}</td>
						<td>${product.productPrice}</td>
						<td><a
							href='<c:url value="/productList/viewProduct/${product.productId}"></c:url>'><span
								class="glyphicon glyphicon-info-sign"></span></a></td>

					</tr>
				</c:forEach>




			</table>
		</div>
		<%@include file="/WEB-INF/view/templates/footer.jsp"%>