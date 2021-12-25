<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Lot</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<br>
	<div class="container">
		<h1>Welcome to The Lot</h1>
		<br>
		<c:if test="${login != null}">
			<p class="text-danger"><c:out value="${login}"/></p>
		</c:if>
		<div class="row">
			<div class="col">
			<h3>Register</h3>
			<br>
				<form:form action="/register" method="post" modelAttribute="newUser">
			        <div class="form-group">
			            <form:input path="firstName" class="form-control" placeholder="First Name" />
			            <form:errors path="firstName" class="text-danger" />
			        </div>
			        <br>
			        <div class="form-group">
			            <form:input path="lastName" class="form-control" placeholder="Last Name" />
			            <form:errors path="lastName" class="text-danger" />
			        </div>
			        <br>
			        <div class="form-group">
			            <form:input path="email" class="form-control" placeholder="Email Address" />
			            <form:errors path="email" class="text-danger" />
			        </div>
			        <br>
			       	<div class="form-group">
			            <form:input path="phone" class="form-control" placeholder="Phone Number (123-456-7891)" type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"/>
			            <form:errors path="phone" class="text-danger" />
			        </div>
			        <br>
			        <div class="form-group">
			            <form:password path="password" class="form-control" placeholder="Password" />
			            <form:errors path="password" class="text-danger" />
			        </div>
			        <br>
			        <div class="form-group">
			            <form:password path="confirmPassword" class="form-control" placeholder="Confirm Password" />
			            <form:errors path="confirmPassword" class="text-danger" />
			        </div>
			        <input type="submit" value="Register" class="btn btn-primary mt-3" />
		    	</form:form>
			</div>
			<div class="col">
			<h3>Login</h3>
			<br>
				<form:form action="/login" method="post" modelAttribute="newLogin">
			        <div class="form-group">
			            <form:input path="email" class="form-control" placeholder="Email Address" />
			            <form:errors path="email" class="text-danger" />
			        </div>
			        <br>
			        <div class="form-group">
			            <form:password path="password" class="form-control" placeholder="Password" />
			            <form:errors path="password" class="text-danger" />
			        </div>
			        <input type="submit" value="Login" class="btn btn-success mt-3" />
    			</form:form>
			</div>
		</div>
	</div>
</body>
</html>