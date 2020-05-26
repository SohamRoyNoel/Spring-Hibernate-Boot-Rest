<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Getter method is called from the model -->
<form:form action="processForm" modelAttribute="students">
First Name : <form:input path="firstname"/><br>
Last Name : <form:input path="lastname"/><br>
Select Country :
<form:select path="country">

	<form:option value="Brazil" label="Brazil"></form:option>
	<form:option value="Germany" label="Germany"></form:option>
	<form:option value="USA" label="USA"></form:option>
	<form:option value="UAE" label="UAE"></form:option>
	<form:option value="India" label="India"></form:option>

</form:select>
<br>
Select Player : 
<form:select path="player">
	<form:options items="${students.favPlayer }"/>
</form:select>
<br>
Select Favorite Programming Language : 
<form:radiobutton path="programmingLanguage" value="C#"/>C#
<form:radiobutton path="programmingLanguage" value="Java"/>Java
<form:radiobutton path="programmingLanguage" value="PHP"/>PHP
<form:radiobutton path="programmingLanguage" value="R"/>R
<br>
Select Second Skill Set : 
<c:forEach var="entry" items="${students.favLang }">
	<form:checkbox path="lng" value="${entry.key}"/> <c:out value="${entry.value}"/>	
</c:forEach>
<br>
Operating System :
<form:checkbox path="ops" value="MAC"/> MAC
<form:checkbox path="ops" value="Windows"/> Windows
<form:checkbox path="ops" value="Linux"/> Linux

<input type="submit" value="Submit">
</form:form>
</body>
</html>