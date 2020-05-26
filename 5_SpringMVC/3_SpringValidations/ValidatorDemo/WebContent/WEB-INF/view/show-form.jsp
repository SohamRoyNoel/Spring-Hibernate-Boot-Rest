<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error {color: red;}
</style>
</head>
<body>
<!-- Getter method is called from the model -->
<form:form action="processForm" modelAttribute="students">
First Name : <form:input path="firstname"/><br>
Last Name : <form:input path="lastname"/><form:errors path="lastname" cssClass="error" /><br>
Credit : <form:input path="credit"/><form:errors path="credit" cssClass="error" /><br>
Pincode : <form:input path="pincode"/><form:errors path="pincode" cssClass="error" /><br>
<input type="submit" value="Submit">
</form:form>
</body>
</html>