<html>
    <head>
        <title>Login FORM</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
       
        <style>
          .bg{
  
  background-image: url("https://p4.wallpaperbetter.com/wallpaper/341/65/160/coffee-laptop-notes-5k-uhd-wallpaper-57aff2b4ef052f6a5ff284c1a1915735.jpg");
  height: 100%; 
  background-attachment: fixed;
  background-position: 50% 50%;
  background-repeat: no-repeat; 
  background-size: cover;

}


.form-container{
  position: absolute;
  top: 15vh;
  background : ghostwhite;
  padding : 30px;
  border-radius : 10px;
  box-shadow: 0px 0px 10px 0px black;
}

.a{

  text-align: center;
  
}
        </style>
        <script>
          function formValidate(){
            var usern = document.forms["myForm"]["userName"];
          	var userp = document.forms["myForm"]["passWord"];

	   if(usern.value == "")
		{
			window.alert("Please enter your username.");
			usern.focus();
			return false;
		}

		if(userp.value == "")
		{
			window.alert("Please enter password.");
			userp.focus();
			return false;
		}
		return true;
          }
        
        </script>
    </head>
    
     <body class="bg">
      
            <section class = "container-fluid ">
              <div style="font-style: normal ; color: whitesmoke ; justify-content: center; text-align: center; ">
               
            
                <h2>Login Page</h2>
             
              
              </div>
                <section class = "row justify-content-center"> 
                    <section class = "col-12 col-sm-6 col-md-3">

                            <form  action = "student" class = "form-container" name="myForm" onsubmit="return formValidate()" method = "POST">
                                    <div class="form-group">

                                      <label for="exampleInputUsername1">Username</label>
                                      <input type="text" class="form-control" id="Username" aria-describedby="nameHelp" placeholder="Enter username" name="userName">
                                      <small id="nameHelp" class="form-text text-muted">We'll never share your details with anyone else.</small>
                                    </div>

                                    <div class="form-group">
                                      <label for="exampleInputPassword1">Password</label>
                                      <input type="password" class="form-control" id="Password1" placeholder="Enter Password" name="passWord">
                                    
                                    </div> 

                                    <button type="submit" class="btn btn-primary btn-block">Login</button>
                                    <div>
                                      <a href="registration.jsp">Click here to register.</a>
                                    </div>

                           </form>
                    </section>
                </section>
            </section>
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>