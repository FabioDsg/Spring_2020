<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Home Page</title>
</head>
<body>
		<h2>Spring Security Company Home Page</h2>
		
		<p>
			Welcome to the basic Spring Security Home Page
		</p>
		
		<hr>
			<!-- Display user name and role -->
			<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			
			Role(s) : <security:authentication property="principal.authorities"/>
			</p>
		<hr>
		
		
		<!-- Add a logout button -->	
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
			<input type="submit" value="logout" />
			
		</form:form>
			
</body>
</html>