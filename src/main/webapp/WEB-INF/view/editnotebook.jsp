     <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel = "icon" href ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZzsRJn1M865Zfto6riI_hIFfdOnkwsmvcpQ&usqp=CAU" 
        type = "image/x-icon"> 
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://colorlib.com/etc/bootstrap-sidebar/sidebar-04/css/style.css">

<title>Book Vehicle</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;

}
</style>
</head>
<body  >

		<div style="padding-top:1%">
			<div class="row">
				<div class="col">
			<h2 class="mb-4"  align="center"><u>EDIT NOTEBOOK</u></h2>
		
				</div>
				<div class="col">
				<div style="padding-left:50%;">
					<button type="button" class="btn btn-primary" ><a href="${pageContext.request.contextPath}/notebook" style="color:white">Back</a></button>
				</div>
				</div>
			</div>
			</div>

		<div style="padding-top:2%">
			<div class="container">
			  <form:form action="savenotebook" modelAttribute="notebook" method="POST">
			  	<form:hidden path="id" /> 
			  	
			  	 <label for="bookname">Book Name</label>
				<form:input type="text" path="notebookName" />
				
			
				   
			    <input type="submit" value="Save Changes" />
			  </form:form>
			</div>
		</div>

</body>