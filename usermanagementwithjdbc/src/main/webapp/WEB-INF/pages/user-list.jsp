<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page errorPage="../../error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Management Application</title>
	</head>
	<body>
		<center>
			<h1>User Management</h1>
			<h2>
				<a href="new">Add New User</a>
				&nbsp;&nbsp;&nbsp;
				<a href="list">List All Users</a>
			</h2>
		</center>
		
		<div align="center">
			<table border="1" cellpadding="5">
				<caption>List Of Users</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Country</th>
					<th>Actions</th>
				</tr>
				
				<c:forEach  items="${users}" var="user">
					<tr>
						<td><c:out value="${user.id}"/></td>
						<td><c:out value="${user.name}"/></td>
						<td><c:out value="${user.email}"/></td>
						<td><c:out value="${user.country}"/></td>
						
						<td>
						<a href="edit?id=<c:out value='${user.id}'></c:out>">Edit</a>
						&nbsp;&nbsp;&nbsp; 
						<a href="delete?id=<c:out value='${user.id}'></c:out>">Delete</a>
						</td>					
					</tr>
				</c:forEach>
				
			</table>
		</div>
		
	</body>
</html>