<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@include file="/WEB-INF/view/templates/header.jsp" %>
    <div class="container-wrapper">      
		<div class="container">
			<div class="page-heaader">
				<h1>Product Detail</h1>
				<p>Here the detail information of the product</p>
				<div class="container">
					<div class="row">
						<div class="col-md-5">
							<img src="#" alt="image" style="width:100%; height:300px">
						</div>
						<div class="col-md-5">
							<h3>${product.productName}</h3>
							<p>${product.productDescription}</p>
							<p><strong>Manufacturer</strong>${product.productManifacturer}</p>
							<p><strong>Category</strong>${product.productCategory}</p>
							<p>${product.productCondition}</p>
							<h4>${product.productPrice} USD</h4>
						</div>
					</div>
				</div>
				
			</div>
<%@include file="/WEB-INF/view/templates/footer.jsp" %>		
