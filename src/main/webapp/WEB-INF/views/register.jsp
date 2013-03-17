<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register User</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/bootstrap.min.css"/>" />
</head>
<body>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="<c:url value="/static/resources/js/bootstrap.min.js"/>"></script>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">Project Name</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Contact</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle=:dropdown " href="#">Dropdown<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action1</a></li>
								<li><a href="#">Action2</a></li>

								<li><a href="#">Action3</a></li>
								<li><a href="#">Action4</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="hero-unit">
			<form:form commandName="newUser" id="reg">
				<h2>Member Registration</h2>
				<p>Enforces annotation-based constraints defined on the model
					class.</p>
				<table>
					<tbody>
						<tr>
							<td><form:label path="name">Name:</form:label></td>
							<td><form:input path="name" /></td>
							<td><form:errors class="invalid" path="name" /></td>
						</tr>
						<tr>
							<td><form:label path="email">Email:</form:label></td>
							<td><form:input path="email" /></td>
							<td><form:errors class="invalid" path="email" /></td>
						</tr>
						<tr>
							<td><form:label path="phoneNumber">Phone #:</form:label>
							<td><form:input path="phoneNumber" /></td>
							<td><form:errors class="invalid" path="phoneNumber" /></td>
						</tr>
						<tr>
							<td><form:label path="username">UserName:</form:label></td>
							<td><form:input path="username" /></td>
							<td><form:errors class="invalid" path="username" /></td>
						</tr>
						<tr>
							<td><form:label path="password">Password:</form:label></td>
							<td><form:input path="password" /></td>
							<td><form:errors class="invalid" path="password" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td><input type="submit" value="Register" class="register" />
						</td>
					</tr>
				</table>
			</form:form>
			<br>

		</div>
		<div class="span8 pull-center">
					<table class="tablestriped">
				<thead>
					<tr>
						<th class="span1">Id</th>
						<th class="span1">Name</th>
						<th class="span1">Email</th>
						<th class="span1">Phone #</th>
						<th class="span1">Username</th>
						<th class="span1">Password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${user.email}</td>
							<td>${user.phoneNumber}</td>
							<td>${user.username}</td>
							<td>${user.password}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table> 
		</div>
	</div>

</body>
</html>