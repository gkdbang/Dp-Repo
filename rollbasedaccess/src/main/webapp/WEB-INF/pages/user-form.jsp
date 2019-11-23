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
				<a href="list">List of All Users</a>
				&nbsp;&nbsp;&nbsp;
				<c:if test='<%= session.getAttribute("username")==null%>'>
					<a href="login">Login</a>
				</c:if>				
				&nbsp;&nbsp;&nbsp;
				<c:if test='<%= session.getAttribute("username")!=null%>'>
					<a href="logout">Logout</a>
				</c:if>
			</h2>	
		</center>
		
		<div align="center">
				<form action="insert" method="post">
			
				<table border="1" cellpadding="10">
				
					<caption>
						<h2>
							<c:if test="${user==null}">
								Add New User
							</c:if>
						</h2>	
					</caption>
					
					<c:if test="${user!=null }">
						<input type="hidden" name="id"></input>
					</c:if>
					
					<tr>
						<th>User Name : </th>
						<td>
							<input type="text" name="username" size="45"></input>
						</td>
					</tr>
					
					<tr>
						<th>Password : </th>
						<td>
							<input type="password" name="password" size="45"></input>
						</td>
					</tr>					
					
					<tr>
						<th>User Email : </th>
						<td>
							<input type="text" name="email" size="45"></input>
						</td>
					</tr>
					
					<tr>
						<th>Country : </th>
						<td>
							<input type="text" name="country" size="20"></input>
						</td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="Save"></input>
						</td>
					</tr>
					
				</table>		
			</form>
		</div>
		
	</body>
</html>