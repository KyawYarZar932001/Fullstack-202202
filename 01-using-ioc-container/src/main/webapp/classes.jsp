
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using IoC Container</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

</head>
<body>




	<div class="container mt-4">

		<h1>Using Ioc Container</h1>
		<h3>Classes for ${course.name}</h3>
		<div>
			<c:url var="addNew" value="/class-edit">
				<c:param name="courseId" value="${ course.id }"></c:param>
			</c:url>
			<a class="btn btn-primary " href="${addNew}">Add new Class</a>
		</div>


		<c:choose>

			<c:when test="${ empty classes }">


				<div class="alert alert-warning">There is no class for
					${course.name }.please create class.</div>
			</c:when>
			<c:otherwise>

				<table class="table table-striped">

					<thead>
						<tr>
							<th>Id</th>
							<th>Course</th>
							<th>Teacher</th>
							<th>Start Date</th>
							<th>Fees</th>
							<th>Duration</th>
							<th>Description</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${ classes }">

							<tr>
								<td>${ c.id }</td>
								<td>${ c.course.name }</td>
								<td>${ c.teacher }</td>
								<td>${ c.startDate }</td>
								<td>${ c.course.fees }</td>
								<td>${ c.course.duration }</td>
								<td>${ c.course.description }</td>
								<td>
								 <c:url var="re" value="/registration">
								  <c:param name="classId" value="${c.id }"></c:param>
								 </c:url>
								 
								 <a href="${re }" style="text-decoration: none">Registration</a>
								</td>
				           </tr>
							
							
						</c:forEach>
					</tbody>


				</table>
			</c:otherwise>
		</c:choose>



		<div class="row">

			<div class="col-4"></div>

		</div>

	</div>

</body>
</html>