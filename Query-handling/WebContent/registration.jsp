<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>  
<html>
    <head>
        <title>Student Registration Form</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <!--  <link rel="stylesheet" type="text/css" href="reg.css">-->
        
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
        

        <style>
            *{
    margin : 0px;
    padding : 0px;
}

body{
    background-image: url("https://images.unsplash.com/photo-1497633762265-9d179a990aa6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
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
    font-size: 15px;
    margin-top: 20px;
    font-weight: normal;
    color: black;
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
    background: rgba(167, 180, 117, 0.4);
    height : 975px;
    box-shadow: -1px 1px 60px 10px rgb(134, 217, 223) inset;
}
        </style>

        <script>
        function formValidate(){
            var f_name = document.forms["myForm"]["firstname"];
            var l_name = document.forms["myForm"]["lastname"];
            var contnum = document.forms["myForm"]["contactno"];
            var emailaddr = document.forms["myForm"]["email"];
            var u_name = document.forms["myForm"]["username"];
            var u_pass = document.forms["myForm"]["password"];
            var cu_pass = document.forms["myForm"]["cpassword"];

            if(f_name.value == "")
		{
			window.alert("Please enter your first name.");
			f_name.focus();
			return false;
		}

        if(l_name.value == "")
		{
			window.alert("Please enter your last name.");
			l_name.focus();
			return false;
		}

        if(contnum.value == "")
		{
			window.alert("Please enter your contact number.");
			contnum.focus();
			return false;
		}

        if(emailaddr.value == "")
		{
			window.alert("Please enter your email address.");
			emailaddr.focus();
			return false;
		}

        if(u_name.value == "")
		{
			window.alert("Please enter user name.");
			u_name.focus();
			return false;
		}

        if(cu_pass.value == "")
		{
			window.alert("Please fill  the confirm password field.");
			cu_pass.focus();
			return false;
		}

        if(u_pass.value == "")
		{
			window.alert("Please enter user password.");
			u_pass.focus();
			return false;
		}

        if(cu_pass.value != u_pass.value )
		{
			window.alert("Entered password does not match");
			cu_pass.focus();
			return false;
		}

        return true;
        }    
        </script>
        
       
    </head>
    <body>
        
        <div class = "container">
            
            <div class = "row">
                <div class = "col-md-3"></div>
                <div class = "col-md-6">
                    <h1 class = "text-center">Student Registration</h1>
                    <form  action="registerStudent"  name="myForm" onsubmit="return formValidate()" method="post"> 
                    <label class = "label col-md-3 control-label">First Name</label>
                    <div class = "col-md-9">
                        <input type = "text" id="id1" class = "form-control" name="firstname" placeholder = "Enter first name">
                    </div>

                    <label class = "label col-md-3 control-label">Last Name</label>
                    <div class = "col-md-9">
                        <input type = "text" class = "form-control" name="lastname" placeholder = "Enter last name">
                    </div>

                    <label class = "label col-md-3 control-label">Contact</label>
                    <div class = "col-md-9">
                        <input type = "text"  minlength=10 maxlength=10 pattern="\d{3}\d{3}\d{4}" title="Enter valid 10 digit mobile number" class = "form-control" name="contactno" placeholder = "Enter contact number">
                    </div>

                    <label class = "label col-md-3 control-label">Email address</label>
                    <div class = "col-md-9">
                        <input type = "text" class = "form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Enter valid email" name="email" placeholder = "Enter email address">
                    </div>

                    <label class = "label col-md-3 control-label">User Name</label>
                    <div class = "col-md-9">
                        <input type = "text" class = "form-control" name="username" id="uid" placeholder = "Enter user name">
                        <span id="ures" class="text-success"></span>
                    </div>
					
                    <label class = "label col-md-3 control-label">Password</label>
                    <div class = "col-md-9">
                        <input type = "Password" minlength=6 id = "pass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters"  class = "form-control" name="password" placeholder = "Enter password">
                      	<span id="pres" class="text-danger"></span>
                    </div>

                    <label class = "label col-md-3 control-label">Renter Password</label>
                    <div class = "col-md-9">
                        <input type = "Password" class = "form-control" name="cpassword" placeholder = "Confirm password">
                      
                    </div>
               
                    
                        <div><input type="submit" class = "btn btn-info" name="Register">
                        		<a href="login.jsp">Back to login</a>
                        </div>
                    </form>
                </div>
            
                <div class = "col-md-3"></div>
            </div>
        </div>
    
		<!-- 		 <script type = "text/javascript">
				   function preventBack(){window.history.forward();}
				    setTimeout("preventBack()", 0);
				    window.onunload=function(){null};
				</script> -->
    
    </body>

<script type="text/javascript">
$(document).ready(function(){
	$("#uid").change(function(){
		$.ajax({
			url : 'check_username',
			data : {username : $("#uid").val()},
			success : function(data){
				$("#ures").html(data);
			}
		});
		
	});
});
</script>
				
</html>