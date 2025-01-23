<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>RPG Character Creator</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">RPG Character Creator</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
          				<a class="nav-link active" aria-current="page" href="#">Login</a>
        			</li>
				</ul>
			</div>
		</div>
	</nav>
<div class="container" style="width: 60%">
	<div class="my-2">
		<h5 class="fw-lighter fst-italic text-secondary-emphasis">Come create a character and join the fun!</h5>
	</div>
	<div class="d-flex justify-content-evenly mt-4">
		<div class="me-3" style="width: 50%">
			<h2>Register</h2>
			<form:form action="/register-user" method="post" modelAttribute="newUser">
				<div class="mb-2">
					<form:label class="form-label" path="username">Username:</form:label>
					<form:input class="form-control" path="username" type="text"/>
					<form:errors class="fw-lighter fst-italic text-danger" path="username"/>
				</div>
				<div class="mb-2">
					<form:label class="form-label" path="email">Email:</form:label>
					<form:input class="form-control" path="email" type="email"/>
					<form:errors class="fw-lighter fst-italic text-danger" path="email"/>
				</div>
				<div class="mb-2">
					<form:label class="form-label" path="password">Password:</form:label>
					<form:password class="form-control" path="password"/>
					<form:errors class="fw-lighter fst-italic text-danger" path="password"/>
				</div>
				<div class="mb-2">
					<form:label class="form-label" path="confirmPassword">Confirm Password:</form:label>
					<form:password class="form-control" path="confirmPassword"/>
					<form:errors class="fw-lighter fst-italic text-danger" path="confirmPassword"/>
				</div>
				<button class="btn btn-primary" type="submit">Submit</button>
			</form:form>
		</div>
		<div class="ms-3" style="width: 50%">
			<h2>Login</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<div class="mb-2">
					<form:label class="form-label" path="email">Email:</form:label>
					<form:input class="form-control" path="email" type="email" id="email"/>
					<form:errors class="fw-lighter fst-italic text-danger" path="email"/>
				</div>
				<div class="mb-2">
					<form:label class="form-label" path="password">Password:</form:label>
					<form:password class="form-control" path="password" id="password"/>
					<form:errors class="fw-lighter fst-italic text-danger" path="password"/>
				</div>
				<button class="btn btn-primary" type="submit">Login</button>
			</form:form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>