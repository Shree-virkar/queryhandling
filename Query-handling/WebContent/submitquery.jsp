<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Query submitted successfully....</h3>
	
	<div align="center">
            <h1>Query List</h1>
            <table border="1">
                <th>No</th>
                <th>Id</th>
                <th>Query</th>
                <th>Answer</th>
                <c:forEach var="query" items="${listQuery}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${query.q_id}</td>
                    <td>${query.subject}</td>
                    <td>${query.query}</td>
                    
                
                             
                </tr>
                </c:forEach>   
	</table></div>
	Enter another <a href="home.jsp">query?</a>

</body>
</html>