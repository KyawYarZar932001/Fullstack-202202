<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

</head>
<body>

	<div class="container mt-4">

		<h1 style="text-align: center; color: blue;">REGISTRATION</h1>
		<div>
			<c:url var="addRe" value="/registration-edit">
				<c:param name="classId" value="${openClass.id}"></c:param>
			</c:url>
			<a href="${addRe }" class="btn btn-primary">Add
				new Registration</a>
		</div>

	</div>
	<div class="container mt-4">

		<c:choose>

			<c:when test="${ empty registration }">


				<div class="alert alert-warning">There is no registration
					.please Create New Registration.</div>
			</c:when>
			<c:otherwise>
				<table class="table table-hover table-dark">
					<thead>
						<tr>
							<th>Id</th>
							<th>Teacher</th>
							<th>Student</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Start Date</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="c" items="${re }">
						<tr>
							<td>${c.id }</td>
							<td>${c.openClass.teacher }</td>
							<td>${c.student }</td>
							<td>${c.phone}</td>
							<td>${c.email }</td>
							<td>${c.openClass.startDate}</td>

							<td>
							<c:url var="home" value="/"></c:url> 
							<a href="${home}" style="text-decoration: none">Home</a>
							</td>


						</tr>
					</c:forEach>

					</tbody>

				</table>
			</c:otherwise>
		</c:choose>
	</div>



</body>
</html>