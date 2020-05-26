<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Confirmed Name : ${students.firstname} with ${students.lastname }
<br><br>
Country : ${students.country }
<br><br>
Player : ${students.player }
<br><br>
Programming language : ${students.programmingLanguage }
<br><br>
Operating System : 
<ul>
	<c:forEach var="temp" items="${students.ops }">
	<li>${temp}</li>
	</c:forEach>
</ul>
</body>
</html>