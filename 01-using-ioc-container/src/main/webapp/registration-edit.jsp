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

<body style="background-color: silver;">

	<div class="container mt-4">
		<h1 style="text-align: center; color: green;">REGISTRATION FORM</h1>

		<div class="row" style="margin-left: 450px; margin-top: 60px">
			<div class="col-6">
				<c:url var="save" value="/registration">
					<c:param name="classId" value="${openClass.id}"></c:param>
				</c:url>
				<form action="${save}" method="post">



					<div class="mb-4">
					   <label for="student" class="form-label">StudentName</label> 
					   <input type="text" class="form-control" name="student"
							placeholder="Enter Student Name !" required="required" />
					</div>

					<div class="mb-4">
						<label for="phone" class="form-label">Phone Number</label>
						<input type="number" class="form-control" name="phone"
							placeholder="Enter Phone Number !" required="required" />
					</div>


					<div class="mb-4">
						<label for="email" class="form-label">Email</label> 
						<input type="text" class="form-control" name="email"
							placeholder="Enter Email!" required="required" />
					</div>

					<input type="submit" value="Save Registration" class="btn btn-primary "> 
					<input type="submit" value="Clear Registration" class="btn btn-danger mx-2">
						

				</form>

			</div>
		</div>
	</div>


</body>
</html>