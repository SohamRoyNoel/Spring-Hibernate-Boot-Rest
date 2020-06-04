<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script>
    $(document).ready(function() {
        $('#example').DataTable();
    } );
    </script>
</head>
<body>
See All Customers Here
<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="t" items="${customers }">
            <tr>
                <td>${t.id }</td>
                <td>${t.firstName }</td>
                <td>${t.lastName }</td>
                <td>${t.email }</td>
            </tr>
         </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
        </tfoot>
    </table>
    
    <h1>Add Customer To The List</h1>
    <input type="button" onclick="window.location.href='showFormToAddCustomer'; return false;" value="ADD Customers">
</body>
</html>