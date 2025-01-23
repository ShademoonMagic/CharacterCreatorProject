<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>RPG Character Creator</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary mb-3">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">RPG Character Creator</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
          				<a class="nav-link" aria-current="page" href="/dashboard">Dashboard</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" aria-current="page" href="/profile/${userID}">Profile</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" aria-current="page" href="/characters/new">Create a Character!</a>
        			</li>
        			<li class="nav-item">
          				<form action="/logout" method="POST">
							<input class="nav-link" type="submit" value="Log Out" />
						</form>
        			</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container mt-2" style="width: 50%">
		<h1>Edit your Character!</h1>
		<form:form action="/characters/${oneChar.id}/edit" method="post" modelAttribute="oneChar">
			<input type="hidden" name="_method" value="put">
			<div class="mb-2">
				<form:label class="form-label" path="name">Character Name:</form:label>
				<form:input class="form-control" path="name" type="text" value="${oneChar.name}"/>
				<form:errors class="fw-lighter fst-italic text-danger"  path="name"/>
			</div>
			<div class="mb-2">
				<form:label class="form-label" path="age">Character Age:</form:label>
				<form:input class="form-control" path="age" type="number" value="${oneChar.age}"/>
				<form:errors class="fw-lighter fst-italic text-danger"  path="age"/>
			</div>
			<div class="mb-2">
				<form:label class="form-label" path="charaClass">Character Class:</form:label>
				<form:select class="form-control" path="charaClass" value="${oneChar.charaClass}">
					<form:option value="Mage" label="Mage" />
					<form:option value="Warrior" label="Warrior" />
					<form:option value="Ranger" label="Ranger" />
				</form:select>
				<form:errors class="fw-lighter fst-italic text-danger"  path="charaClass"/>
			</div>
			<div class="mb-2">
				<form:label class="form-label" path="description">Character Description:</form:label>
				<form:textarea class="form-control" path="description" value="${oneChar.description}"/>
				<form:errors class="fw-lighter fst-italic text-danger"  path="description"/>
			</div>
			<div class="mb-2">
				<form:label class="form-label" path="backstory">Character Backstory:</form:label>
				<form:textarea class="form-control" path="backstory" value="${oneChar.backstory}" />
				<form:errors class="fw-lighter fst-italic text-danger"  path="backstory"/>
			</div>
			<form:hidden path="user" value="${userID}"/>
			<form:hidden path="level" value="${oneChar.level}"/>
			<button class="btn btn-primary btn-sm" type="submit">Submit</button>
		</form:form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>