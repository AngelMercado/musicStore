<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Carousel Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href='<spring:url value="/res/css/bootstrap.min.css"></spring:url>' rel="stylesheet">

    
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  <c:import url="/WEB-INF/views/templates/header.jsp"></c:import>
    <div class="container-wrapper" style="margin-top:3rem;">
    	<div class="container">
    		<div class="page-header">
    			<h1>Admin Page</h1>
    			<p class="lead">This administrator page</p>
    		</div>
    		
			<table class="table">
				<thead>
					<tr>
					<th>ProductName</th>
					<th>Product Category</th>
					<th>Product Condition</th>
					<th>Product Price</th>
					<th>Product Detail</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items='${products}' var="product">
					<tr>
						<th>${product.productName}</th>			
						<th>${product.productCategory}</th>
						<th>${product.productCondition}</th>
						<th>${product.productPrice}</th>
						<th><a href='<spring:url value="productList/productDetail/${product.idProduct}"></spring:url>'><span class=" glyphicon glyphicon-info-sign"/></a></th>						
					</tr>
					</c:forEach>
				</tbody>
				
			</table>
	
		<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
    	</div>
   	
    </div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src='<c:url value = "res/js/jquery-1.11.3.minjs"/>'><\/script>')</script>
    <script src='<c:url value="/res/js/bootstrap.min.js"/>'></script></script>

  </body>
</html>
