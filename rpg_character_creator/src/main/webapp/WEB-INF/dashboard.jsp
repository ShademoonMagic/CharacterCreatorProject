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
<nav class="navbar navbar-expand-lg bg-body-tertiary mb-3">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">RPG Character Creator</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
          				<a class="nav-link active" aria-current="page" href="#">Dashboard</a>
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
<div class="container" style="width: 60%">
		<table class="table table-striped table-hover border table-bordered">
			<thead>
				<tr>
					<th>Character Name</th>
					<th>Character Creator</th>
					<th>Class</th>
					<th>Level</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneChar" items="${allChars}">
				<tr>
					<td> <c:out value="${oneChar.name}"/></td>
					<td> <c:out value="${oneChar.user.username}"/> </td>
					<td> <c:out value="${oneChar.charaClass}"/> </td>
					<td> <c:out value="${oneChar.level}"/> </td>
					<td> <a href="/characters/${oneChar.id}">View</a> </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>