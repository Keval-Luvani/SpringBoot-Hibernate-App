<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert Data</title>
	</head>
	<body>	
		<form:form action="submit" method="post" modelAttribute="employee">
			<form:input path="employeeId" type="hidden" />
			<form:label path="name">Name</form:label>
			<form:input path="name" required="required"/><br>
			
			<form:label path="age" >age</form:label>
			<form:input path="age" type="number" required="required"/><br>
			
			<form:label path="salary">salary</form:label>
			<form:input path="salary" type="number" step="0.01" required="required"/><br>
			
			<form:label path="joiningDate">Joining Date</form:label>
			<form:input path="joiningDate" type="date" required="required" max="${todayDate}"/><br>
			
			<form:button>Submit</form:button>
		</form:form>
	</body>
</html>