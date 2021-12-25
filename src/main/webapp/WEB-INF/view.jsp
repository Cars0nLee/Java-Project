<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>More Info</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!-- CSS -->	
<link rel="stylesheet" type="text/css" href="/css/view.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<br>
	<div class="title">
		<div class="info">
			<h1><c:out value="${car.year}" /> <c:out value="${car.make}" /> <c:out value="${car.model}" /> - $<c:out value="${car.price}" /></h1>
			<h3><c:out value="${car.city}" />, <c:out value="${car.state}" /></h3>
		</div>
		<div>
			<a href="http://localhost:8080/dash">Back to Dashboard</a>
		</div>
		<div>
			<a href="http://localhost:8080/edit/${car.id}">Edit</a>
		</div>
		<div class="delete">
			<form action="/delete/${car.id}" method="POST" onSubmit="return confirm('Are you sure you want to delete this listing?')">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete Listing">
			</form>
		</div>
	</div>
	<br>
	<div class="container">
		<table class="table table-striped" style="width: 25%">
			<thead>
				<tr>
					<th><h4>Vehicle Info</h4></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">Price</th>
					<td>$<c:out value="${car.price}" /></td>
				</tr>
				<tr>
					<th scope="row">Mileage</th>
					<td><c:out value="${car.mileage}" /> miles</td>
				</tr>
				<tr>
					<th scope="row">Location</th>
					<td><c:out value="${car.city}" />, <c:out value="${car.state}" /></td>
				</tr>
				<tr>
					<th scope="row">Exterior Color</th>
					<td><c:out value="${car.color}" /></td>
				</tr>
				<tr>
					<th scope="row">Interior Color</th>
					<td><c:out value="${car.color2}" /></td>
				</tr>
				<tr>
					<th scope="row">Transmission</th>
					<td><c:out value="${car.trans}" /></td>
				</tr>
				<tr>
					<th scope="row">Body Style</th>
					<td><c:out value="${car.bodyType}" /></td>
				</tr>
				<tr>
					<th scope="row">VIN</th>
					<td><c:out value="${car.vin}" /></td>
				</tr>
				<tr>
					<th scope="row">Stock #</th>
					<td><c:out value="${car.id}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
	<div class="container">
		<hr class="rounded">
		<table class="table table-striped" style="width: 25%">
			<thead>
				<tr>
					<th><h4>Owner's Description</h4></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${car.description}" /> Contact, <c:out value="${car.user.phone}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>

		
