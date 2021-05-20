<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">
<head>
<title>Notifier</title>
 <link rel = "icon" href ="https://thumbs.dreamstime.com/b/vector-alarm-bell-logo-icon-template-illustration-design-push-element-website-background-school-monochrome-set-phone-app-mute-156137324.jpg" 
        type = "image/x-icon"> 
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
<link rel="stylesheet" href="https://colorlib.com/etc/bootstrap-sidebar/sidebar-04/css/style.css">
<!-- icons -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

			<h2 class="mb-4"  align="center"><u>NOTE</u></h2>
			<div style="padding-left:80%;">
				<button type="button" class="btn btn-primary" ><a href="${pageContext.request.contextPath}/" style="color:white">Back</a></button>
			</div>
		
	<div class="container">
	<section>
				<div style="padding-top: 30px;">
				<table id="example"
					class="table table-striped table-bordered dt-responsive nowrap"
					style="width: 100%">
					<thead>
						<tr>
							<th>Attribute</th>
							<th>Value</th>
							
							
						</tr>
					</thead>
					<tbody>
							<tr >
								<td>Name</td>
								<td>${note.title}</td>
							</tr>
							<tr>
								<td>StartDate</td>
								<td>${note.startDate}</td>
							</tr>
							<tr>
								<td>EndDate</td>
								<td>${note.endDate}</td>
							</tr>
							<tr>
								<td>Remainder Date</td>
								<td>${note.remainderDate}</td>
							</tr>
							<tr>
								<td>Status</td>
								<td>${note.status}</td>
							</tr>
							<tr>
								<td>Tag</td>
								<td>${note.notebook}</td>
							</tr>
							<tr>
								<td>Description</td>
								<td>${note.description}</td>
							</tr>
					</tbody>
				</table>
			</div>
			</section>


</div>

	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src=" https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>





















