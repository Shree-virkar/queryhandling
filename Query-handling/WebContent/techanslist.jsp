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
	
	<form action="anstechquery" method="post">
	<table align="center">
	
	<center>		
		
		<tr>
			<td><input type="hidden" name="q_id" value="${techQuery.q_id}">${techQuery.q_id}
           ${techQuery.query}</td>
		</tr>
		<tr>
	<td>
	
	<textarea class="form-control" rows="10" cols="80" id="comment" name ="tresponse"></textarea><br><br>
                   <center><input type="submit" value="Submit">
	</td>
              
		</tr>
	
	</table>
	</form>	
</body>
</html>