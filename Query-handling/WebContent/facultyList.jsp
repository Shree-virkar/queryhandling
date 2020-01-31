<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>


 <html>
    <head>
        <title>Non-Technical Queries</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="admin.css" >

<style>
*{
    margin : 0px;
    padding : 0px;
}

body{
    background-image: url("admin2.jpeg");
    background-attachment: fixed;
    background-size: cover;
    font-family: 'Times New Roman', Times, serif;
}

h1{
    font-size: 40px;
    color : white;
    margin-top : 20px;
    margin-bottom: 30px; 
}

.label{
    font-size: 20px;
    margin-top: 20px;
    font-weight: normal;
    color: white;
}

.form-control{
    background : rgba(255,255,255,0.2);
    border : 0px;
    border-radius : 0px;
    border-bottom: 2px solid white;
    font-size: 20px;
    color : white;
    margin-top : 20px;
}

.btn-info{
    margin-top : 30px;
    margin-left : 150px;
    width : 180px;
    font-size : 19px;
    border-radius : 1000px;
}

.col-md-6{
    background: rgba(0,0,0,0.4);
    height : 360px;
    box-shadow: -1px 1px 60px 10px black inset;
}

</style>
    </head>

<body style = "background-color: #f4dc90">
	
	<div class="container">
	<table class="table table-hover">
	
	<tr>
<th> Faculty Id</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
	
	
<c:forEach var="v" items="${requestScope.facultyList}"> 




<tr>
<td>
${v.faculty_id}
</td>
<td>${v.firstName}</td>
<td>${v.lastName}</td>
<td> <a href="<spring:url value='/admin/removeFaculty?faculty_id=${v.faculty_id}'/>">Delete</a></td>
</tr>



</c:forEach>
	
	</table>
	
	</div>
</body>
</html>