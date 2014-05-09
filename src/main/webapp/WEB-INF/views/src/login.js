var attempts = 0;
$("document").ready(function() {
     login();     
});


// prompt the user for username and password when the page loads
function login() {
     attempts++;
	 if(attempts <= 3) {
        var userName = prompt("Enter your user name");
	    var password = prompt("Enter your password");
	    verifyUser(userName, password);
	}	
}

//function that verified the username and password
function verifyUser(userName, password)  {
$.ajax( {
    type: "GET",
    url: "http://localhost:8080/repair_lst/security",
    success: validationSuccess,
    error: validationFailure
});
}

// get the userId if the validation passes
function validationSuccess(data, status, jqXHR) {
    var userId = data.id;
}


function validationFailure(data)  {
   var message = data.responseJSON[0];
   login();

}