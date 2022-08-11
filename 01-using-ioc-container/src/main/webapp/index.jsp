<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using IoC Container</title>


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
		<h1>Using IoC Container</h1>
		<h3>Courses</h3>
		<div>
			<a class="btn btn-primary " href="course-edit">Add new Course</a>
		</div>


		<div class="mt-4">

			<c:choose>
				<c:when test="${empty courses}">

					<div class="alert alert-warning">There is no courses.please
						create courses.</div>
				</c:when>

				<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Duration</th>
								<th>Fees</th>
								<th>Description</th>
								<th></th>

							</tr>

						</thead>

						<tbody>
							<c:forEach var="c" items="${ courses }">

								<tr>
									<td>${c.id }</td>
									<td>${c.name }</td>
									<td>${c.duration}Months</td>
									<td>${c.fees }</td>
									<td>${c.description}</td>
									<td>
									    <c:url var="classes" value="/classes">

											<c:param name="courseId" value="${c.id }"></c:param>
										</c:url> 
										<a href="${classes }">Open Classes</a>
									</td>
									
									
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</c:otherwise>

			</c:choose>


		</div>

	</div>


</body>
</html>