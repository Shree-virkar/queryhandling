<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>                    
<html>
    <head>
        <title>Technical Page</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="techsearch.css" >

    </head>

	<body style = "background-color: #8585ad">

<div class="container" style = "background-color: #ffe6e6;">
    <div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar">
				<!-- SIDEBAR USERPIC -->
				<div class="profile-userpic">
					<img src="https://static.change.org/profile-img/default-user-profile.svg" class="img-responsive" alt="">
				</div>
				<!-- END SIDEBAR USERPIC -->
				<!-- SIDEBAR USER TITLE -->
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
						Student Name
					</div>
					<div class="profile-usertitle-job">
						PG-DAC
					</div>
				</div>
				<!-- END SIDEBAR USER TITLE -->
				<!-- SIDEBAR BUTTONS -->
				
				<!-- END SIDEBAR BUTTONS -->
				<!-- SIDEBAR MENU -->
				<div class="profile-usermenu">
					<ul class="nav">
                        
                        <li>
							<a href="#">
							<i class="glyphicon glyphicon-home"></i>
							Back to home </a>
						</li>
						<li>
							<a href="logout">
							<i class="glyphicon glyphicon-user"></i>
							Logout </a>
						</li>
						
					</ul>
				</div>
				<!-- END MENU -->
			</div>
        </div>
        
		<div class="col-md-9">
            <div class="profile-content">
               <p><h2>Technical Queries related to topic</h2></p>
            <p align = "left">
            	<c:forEach var="query" items="${listQuery}" varStatus="status">
                <tr>
   					<form action="techanswer" method="post">
   					
   					 <td><input type="hidden" name="q_id" value="${query.q_id}">${query.q_id}</td>
   					
                    <td><input type="hidden" name="question" value="${query.query}">${query.query}</td>
                    <td></td>
                	
                	<input type="submit" value="Response">
                      </form><br>       
                </tr>
                </c:forEach> 
				<br>
				

			</p>
            </div>

        </div>
	</div>
</div>


</body>
</html>      
