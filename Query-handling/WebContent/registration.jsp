<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<html>
    <head>
        <title>Student Registration Form</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <style>
        *{
    margin : 0px;
    padding : 0px;
}

body{
    background-image: url("regcdac.jpg");
    background-attachment: fixed;
    background-size: cover;
    font-family: 'Times New Roman', Times, serif;
}

h1{
    font-size: 40px;
    color : whitesmoke;
    margin-top : 20px;
    margin-bottom: 30px; 
}

.label{
    font-size: 20px;
    margin-top: 20px;
    font-weight: normal;
    color: whitesmoke;
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
    height : 860px;
    box-shadow: -1px 1px 60px 10px black inset;
}
        
        </style>
    </head>
    <body>
        <div class = "container">
            <div class = "row">
                <div class = "col-md-3"></div>
                <div class = "col-md-6">
                    <h1 class = "text-center">REGISTER</h1>
				<form action="registerStudent" method="post">
                    <label class = "label col-md-3 control-label">username</label>
                    <div class = "col-md-9">
                        <input type = "text" class = "form-control" name="username" placeholder = "Enter username">
                    </div>

                    <label class = "label col-md-3 control-label">First NAME</label>
                    <div class = "col-md-9">
                        <input type = "text" class = "form-control" name="firstname" placeholder = "Enter firstname">
                    </div>

					
					  <label class = "label col-md-3 control-label">last NAME</label>
                    <div class = "col-md-9">
                        <input type = "text" class = "form-control" name="lastname" placeholder = "Enter lastname">
                    </div>
					
                    <label class = "label col-md-3 control-label">EMAIL</label>
                    <div class = "col-md-9">
                        <input type = "text" class = "form-control" name="email" placeholder = "Enter email">
                    </div>

					<label class = "label col-md-3 control-label">contact</label>
                    <div class = "col-md-9">
                        <input type = "text" class = "form-control" name="contactno" placeholder = "Enter contact number">
                    </div>
					

					<label class = "label col-md-3 control-label">PASSWORD</label>
                    <div class = "col-md-9">
                        <input type = "Password" class = "form-control" name="password" placeholder = "password">
                      
                    </div>
			
					 <div class = "col-md-9">
                                    <input type="submit" class="btn btn-primary btn-block" name="Register" value="register">
                      
                    </div>
			
                    
         


                   </form> 
                </div>
                <div class = "col-md-3"></div>
            </div>
        </div>
    </body>
</html>