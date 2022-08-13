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

		<h1>Add new Class For ${course.name }</h1>

		<div class="row">
			<div class="col-6">
			
			 <c:url var="save" value="/classes">
			  <c:param name="courseId" value="${course.id }"></c:param>
			 </c:url>
			 	<form action="${save }" method="post">
			 	
			 	   <div class="mb-4">
			 	   
			 	     <label for="id"  class="form-label">Course Id</label>
			 	     <input type="text" readonly="readonly" class="form-control" name="id" 
			 	     value="${course.id }" required="required" />
			 	   </div>
			 	   
			 	   <div class="mb-4">
			 	    <label for="courseName" class="form-label">Couse Name</label>
			 	    <input type="text" readonly="readonly" class="form-control" name="courseName"
			 	    value="${course.name }" required="required" />
			 	   </div>
			 	   
			 	   <div class="mb-4">
			 	    <label for="teacher" class="form-label">Teacher</label>
			 	    <input type="text" class="form-control" name="teacher"
			 	    placeholder="Enter Name" required="required"/>
			 	   </div>
			 	   
			 	   <div class="mb-4">
			 	    <label for="startDate" class="form-label">StartDate</label>
			 	    <input type="date" class="form-control" name="startDate"
			 	    placeholder="Enter Start Date" required="required" />
			 	   </div>
			 	   
			 	   <input type="submit" value="Save Class" class="btn btn-primary" />
			 	   <input type="reset" value="Clear Class" class="btn btn-danger" />
			 	</form>
			 
			 
			</div>
		</div>
		
		

	</div>

</body>
</html>