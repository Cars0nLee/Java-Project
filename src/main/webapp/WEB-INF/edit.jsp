<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h1>Edit Vehicle Info</h1>
		<br>
		<form:form action="/update/${car.id}" method="post" modelAttribute="car">
		<form:hidden path="user" value="${userId}" />
		<input type="hidden" name="_method" value="put">
			<div>
				<form:label path="make">Make: </form:label>
				<form:select path="make">
				<form:option value="" hidden="hidden">Choose Make</form:option>
					<c:forEach var="i" items="${make}">
						<form:option value="${i.name}">
							<c:out value="${i.name}" />
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<br>
			<div>
				<form:label path="model">Model: </form:label>
				<form:input path="model" />
			</div>
			<br>
			<div>
				<form:label path="year">Year: </form:label>
				<form:select path="year">
				<form:option value="" hidden="hidden">Choose Year</form:option>
					<c:forEach var="i" items="${year}">
						<form:option value="${i.year}">
							<c:out value="${i.year}" />
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<br>
			<div>
				<form:label path="bodyType">Body Type: </form:label>
				<form:select path="bodyType">
					<form:option value="" hidden="hidden">Choose Body Type</form:option>
						<c:forEach var="i" items="${type}">
							<form:option value="${i.bodyType}">
								<c:out value="${i.bodyType}" />
							</form:option>
						</c:forEach>
				</form:select>
			</div>
			<br>
			<div>
				<form:label path="color">Exterior Color: </form:label>
				<form:input path="color" />
			</div>
			<br>
			<div>
				<form:label path="color2">Interior Color: </form:label>
				<form:input path="color2" />
			</div>
			<br>
			<div>
				<form:label path="trans">Transmission: </form:label>
				<form:select path="trans">
					<form:option value="" hidden="hidden">Choose Transmission</form:option>
					<form:option value="Automatic">Automatic</form:option>
					<form:option value="Manual">Manual</form:option>
				</form:select>
			</div>
			<br>
			<div>
				<form:label path="mileage">Mileage: </form:label>
				<form:input path="mileage" type="number"/>
			</div>
			<br>
			<div>
				<form:label path="vin">VIN number: </form:label>
				<form:input path="vin" placeholder="17 digit VIN"/>
			</div>
			<br>
			<div>
				<form:label path="price">Price: </form:label>
				<form:input path="price" type="number"/>
			</div>
			<br>
			<div>
				<form:label path="city">City: </form:label>
				<form:input path="city" />
			</div>
			<br>
			<div>
				<form:label path="state">State: </form:label>
				<form:select path="state">
					<form:option value="" hidden="hidden">Choose State</form:option>
						<c:forEach var="i" items="${state}">
							<form:option value="${i.state}">
								<c:out value="${i.state}" />
							</form:option>
						</c:forEach>
				</form:select>
			</div>
			<br>
			<div>
				<form:label path="description">Description: </form:label>
				<form:textarea path="description"  placeholder="Max 500 characters" cols="50" rows="5"/>
			</div>
			<br>
			<input type="submit" value="Update Listing">
			<br><br>
			<a href="http://localhost:8080/dash">Back to Dashboard</a>
		</form:form>
	</div>
</body>
</html>