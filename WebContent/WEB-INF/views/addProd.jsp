<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    		
        <form:form action="#" method="post" commandName="product" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name">Name</label>
					<form:input path="productName" id="name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="category">Category</label>
					<label class="checkbox-inline"><form:radiobutton path="productCategory" value="instrument" id="category" />Instrument</label>
					<label class="checkbox-inline"><form:radiobutton path="productCategory" value="record" id="category" />Record</label>
					<label class="checkbox-inline"><form:radiobutton path="productCategory" value="accesory" id="category" />Accesory</label>
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<form:input path="productDescription" id="description" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="price">Price</label>
					<form:input path="productPrice" id="price" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="condition">Condition</label>
					<label class="checkbox-inline"><form:radiobutton path="productCondition" value="new" id="condition"/>New</label>
					<label class="checkbox-inline"><form:radiobutton path="productCondition" value="used" id="condition"/>Used</label>
				</div>
				<div class="form-group">
					<label for="status">Status</label>
					<label class="checkbox-inline"><form:radiobutton path="productStatus" value="active" id="status"/>Active</label>
					<label class="checkbox-inline"><form:radiobutton path="productStatus" value="inactive" id="status"/>Inactive</label>
				</div>
				<div class="form-group">
					<label for="unitStack">UnitStack</label>
					<form:input path="unitStack" id="unitStack" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="manufacture">Manufacture</label>
					<form:input path="productManufacture" id="manufacture" class="form-control"/>
				</div>				
                 <div class="form-group">
                     <label class="control-label" for="productImage">Upload Picture</label>
                     <form:input path="productImage" type="file" id="productImage" class="form-control"></form:input>
                 </div>
                 <div class="form-group">
                 	<input type="submit" name="submit" class="btn btn-default">
                 </div>
			</form:form>
	
		<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
    	</div>
   	
    </div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src='<c:url value = "/res/js/jquery-1.11.3.minjs"/>'><\/script>')</script>
    <script src='<c:url value="/res/js/bootstrap.min.js"/>'></script></script>

  </body>
</html>
