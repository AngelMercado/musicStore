<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/view/templates/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<div class="page-heaader">
			<h1>Administrator Page</h1>
			<p class="lead">This is the administrator page</p>
		</div>
		<h3>
			<a href='<c:url value="/admin/productInventory"/>'>Product
				Inventory</a>
		</h3>
		<p>Here you can view, check and modify the product inventory</p>


		<%@include file="/WEB-INF/view/templates/footer.jsp"%>