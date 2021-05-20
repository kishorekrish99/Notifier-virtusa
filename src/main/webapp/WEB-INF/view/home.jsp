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

	<div class="wrapper d-flex align-items-stretch">
		<nav id="sidebar">
			<h1>
				<a href="${pageContext.request.contextPath}/" class="logo">NOTIFIER</a>
			</h1>
			<ul class="list-unstyled components mb-5">
				<li class="active"><a href=""> Hai <security:authentication property="principal.username" /> </a></li>
				<li class="active"><a data-toggle="modal" data-target="#notification" ><span
						class="fa fa-sticky-note-o mr-3"></span>Notifications (${totalNotifications})</a>
						
						<div class="modal fade" id="notification" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel" align="center">Remainder</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						     <div class="modal-body" style="color:black">
						       <!-- Body of the drop down -->
						       		<div style="text-align:center">
										<c:forEach var="notification" items="${notification}">
						       			<h3>${notification.title }</h3>
						       			<h4>${notification.remainderDate}</h4>
						       			<hr>
						       			</c:forEach>
						       		</div>
							</div>
						    </div>
						  </div>
						</div>
				
				</li>
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				<li class="active"><a href="${pageContext.request.contextPath}/notebook"><span
						class="fa fa-book mr-3"></span> NoteBooks</a></li>
				<li class="active"><a data-toggle="modal" data-target="#exampleModal"><span
						class="fa fa-user mr-3"></span >Edit User</a>
				
				
				<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLabel" align="center">EDIT USER</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body" style="color:black">
				       <!-- Body of the drop down -->
				       			<div class="container">
									  <form:form action="edituser" modelAttribute="user" method="POST">
									  	
									  	 <label for="username">Username : </label>
										<form:input type="text" path="username"   name="username" placeholder="Username" style=" border: 1px solid black;color:black"/>
										<br>
									    <label for="mobile">Mobile &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
									    <form:input type="text" path="mobile" name="mobile" placeholder="mobile"/>
										<br>
										<label for="email">Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
									    <form:input type="text" path="email"  name="email" placeholder="abc@gmail.com" />
									    <br>
									    <label for="password">Password &nbsp;:</label>
									    <form:input type="text" path="password"  name="password" placeholder="password" />
									    
											<br><br>
											<div align="center">
											<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									    <input type="submit" class="btn btn-primary" value="Save"  />
									    </div>
									  </form:form>
									</div>
				      </div>
				    </div>
				  </div>
				</div>
				
				</li>
				
				<form:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					<li>
					<div style="padding-top:0px;" >
					<input type="submit" value="logout" style="padding-left:70px;padding-right:125px;background-color:black;color:white;height:50px;"></div>
					</li>
				</form:form>
			</ul>

		</nav>

		<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5 pt-5">
			
			
			<!-- Page Content -->
			<h2 class="mb-4"  align="center"><u>NOTES</u></h2>
			<div style="padding-left:80%;">
				<button type="button" class="btn btn-primary" ><a href="${pageContext.request.contextPath}/addnotes" style="color:white">Add Notes</a></button>
			</div>
		
			<section>
				<div style="padding-top: 30px;">
				<table id="example"
					class="table table-striped table-bordered dt-responsive nowrap"
					style="width: 100%">
					<thead>
						<tr>
							<th>Note Name</th>
							<th>Status</th>
							<th>Operations</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="notes" items="${notes}">
							<c:url var="open" value="open">
									<c:param name="id" value="${notes.id}" />
							</c:url>
							<c:url var="editing" value="editnote">
									<c:param name="id" value="${notes.id}" />
							</c:url>
							<c:url var="deleting" value="deletenote">
									<c:param name="id" value="${notes.id}" />
							</c:url>
							<c:if test="${notes.username==user.username}">
							<tr>	
								<td>${notes.title}</td>
								<td>${notes.status}</td>
								<td><a href="${editing}">EDIT</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${deleting}">DELETE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${open}">OPEN</a></td>
							</tr>
							</c:if>		
							</c:forEach>
					</tbody>
				</table>
			</div>
			
	
			</section>
		
			
			</div>
		</div>
	
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src=" https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>