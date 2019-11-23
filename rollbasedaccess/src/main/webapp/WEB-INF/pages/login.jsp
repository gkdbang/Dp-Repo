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
			<h1>User Management Login Form</h1>
			<h2>
				<a href="new">Add New User</a>
				&nbsp;&nbsp;&nbsp;
				<a href="list">List of All Users</a>
			</h2>			
		</center>
		
		<div align="center">
			<c:if test="${loginMessage!=null}">
				<h2><c:out value="${loginMessage}"></c:out></h2>
			</c:if>
		</div>		
		
		<div align="center">
			<c:if test="${message!=null}">
				<h2><c:out value="${message}"></c:out></h2>
			</c:if>
		</div>
		
		<div align="center">
			<form action="login" method="post">
				<table border="1" cellpadding="10">
					<tr>
						<th>UserName : </th>
						<td>
							<input type="text" name="username" size="40"></input>
						</td>
					</tr>
					<tr>
						<th>Password : </th>
						<td>
							<input type="password" name="password" size="40"></input>
						</td>
					</tr>
					<tr>
						<td align="center">
							<input type="submit" value="Login"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
	</body>
</html>