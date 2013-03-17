<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/bootstrap.min.css"/>" />
<title>Home Page</title>
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

					<form:form class="navbar-form pull-right" commandName="login">
						<form:input class="span2" type="text" placeholder="Username" path="username"/>
						<form:input class="span2" type="password" placeholder="Password" path="password"/>
						<button class="btn" value="Register" type="submit">Sign in</button>
						<form:errors class="invalid" path="username"/>
						<form:errors class="invalid" path="password"/>
					</form:form>
				</div>
			</div>
		</div>
	</div>



	<div class="container">
		<div class="row">
			<div class="span2">
				<p>
					<small>This line of text is meant to be treated as fine
						print. & ${area2}</small>
				</p>
			</div>
			<div class="span8">
				<p class="text-right">Right aligned text.</p>
				<dl>
					<dt>Description1</dt>
					<dd>Description2</dd>
				</dl>


				<table class="tablestriped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Email</th>
							<th>Phone #</th>
							<th>REST URL</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${members}" var="member">
							<tr>
								<td>${member.id}</td>
								<td>${member.name}</td>
								<td>${member.email}</td>
								<td>${member.phoneNumber}</td>
								<td><a href="<c:url value="/rest/members/${member.id}"/>">/rest/members/${member.id}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<h1>This is the message : ${area1}</h1>
</body>
</html>