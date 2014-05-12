var attempts = 0;
$("document").ready(function() {
     login();     
});


// Prompt the user for username and password when the page loads. The user gets 3 tries to login
function login() {
	 if(attempts >= 3) {
		 alert("You have exceeded the maximum number of attempts to log in!");
		 return;
	 }
     attempts++;
	 if(attempts <= 3) {
        var userName = prompt("Enter your username");
        if(userName === null) {
	    	alert("You pressed Cancel. You will have to log in to add a repair item");
	    	return;
	    }
	    var password = prompt("Enter your password");	    
	    if(password === null) {
	    	alert("You pressed Cancel. You will have to log in to add a repair item");
	    	return;
	    }
	    if(validateUser(userName, password)) {
	       verifyUser(userName, password);
	    } else {
	    	$("#loginStatusMessage").text("Invalid username/password"); 
	    }
	}	
}


// function that validates the username and password
function validateUser(userName, password) {
	var userLength = userName.length;
	var passwordLength = password.length;
	if(userLength <= 0 || userLength > 32) {		
		   alert("Username should be between 0-32 characters");
		   var response = confirm("Do you want to try again?");
			if(response) {
				login();					
			}	
			return false;
	} 
	
	if((passwordLength <= 0 || passwordLength > 32)) {
		alert("Password should be between 0-32 characters");
		var response = confirm("Do you want to try again?");
		if(response) {
			login();
		}	
		return false;				
	}
	
	return true;
}


//function that verifies the username and password
function verifyUser(userName, password)  {
	
$.ajax( {
    type: "GET",
    url: "http://localhost:8080/repair_lst/user",
    data: {userName : userName, password : password},
    success: validationSuccess,
    error: validationFailure
});
}

// get the userId if the validation passes
function validationSuccess(data, status, jqXHR) {
    getUserId(data.id);
    //$("#username").text(data.userName);    
    $("#loginStatusMessage").text("Logged in as " + data.userName);
}

// display the error message if validation fails
function validationFailure(data)  {
   var message = data.responseJSON[0];
   $("#loginStatusMessage").text(message); 
   setTimeout(login, 2000);
}

function tryAgain() {
	var response = confirm("Do you want to try again?");
	if(response) {
		login();
		return true;
	}else {
		return false;
    }
}
 
function getUserId(id) {	
	return id;
}