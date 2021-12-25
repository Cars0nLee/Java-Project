<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!-- CSS -->	
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<br>
	<div class="container">
		<div class="nav">
			<h1>Welcome <c:out value="${loggedUser.firstName}" />!</h1>
			<div class="link">
				<a href="http://localhost:8080/sell">Create Listing</a>
				<a href="http://localhost:8080/logout">Logout</a>
			</div>
		</div>
		<br>
		<c:if test="${dash != null}">
			<p class="text-danger"><c:out value="${dash}"/></p>
		</c:if>
		<table class="table">
			<tr class="header">
				<th>Year</th>
				<th>Make</th>
				<th>Model</th>
				<th>Body Type</th>
				<th>Exterior Color</th>
				<th>Mileage</th>
				<th>VIN</th>
				<th>Price</th>
				<th>Location</th>
				<th>View</th>
			</tr>
			<c:forEach var="i" items="${cars}">
			<tr>
				<td><c:out value="${i.year}" /></td>
				<td><c:out value="${i.make}" /></td>
				<td><c:out value="${i.model}" /></td>
				<td><c:out value="${i.bodyType}" /></td>
				<td><c:out value="${i.color}" /></td>
				<td><c:out value="${i.mileage}" /></td>
				<td><c:out value="${i.vin}" /></td>
				<td>$<c:out value="${i.price}" /></td>
				<td><c:out value="${i.city}" />, <c:out value="${i.state}" /></td>
				<td><a href="http://localhost:8080/view/${i.id}">More Info</a></td>
			</tr>
			</c:forEach>	
		</table>
	</div>
</body>
</html>

