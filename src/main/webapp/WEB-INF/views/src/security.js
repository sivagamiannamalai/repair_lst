$(document).ready(function(){

	$.ajax({
			type: "GET",
			url: "http://localhost:8080/repair_localsportsteam/security",
			success: securitySuccess, 
			error: securityFailure
		});

});


function securityFailure(data, status, jqXHR){

console.log("Failed!"+ jqXHR.responseText);

}

function securitySuccess(data, status, jqXHR){

console.log("Success!"+ jqXHR.responseText);

};
