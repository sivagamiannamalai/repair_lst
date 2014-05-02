$(document).ready(function(){

	$("#createFacilitySubmit").click(postRepairFacility);

});


var errorMessage = "";

function postRepairFacility(){

	errorMessage = "";

	// Address vars
	var street = $("#streetAddressInput").val();
	var city = $("#cityInput").val();
	var state = $("#stateSelect").val();
	var zip = $("#zipInput").val();

	$("#facilityMessage").html("");

	if(validateAddress(street, city, state, zip)){

		$.ajax({
			type: "POST",
			url: "http://localhost:8080/repair_lst/address/",
			data: { street : street, city : city, state : state, zip : zip },
			success: createAddressSuccess, 
			error: createAddressFailure
		});

	} else {

		$("#facilityMessage").html("Fields that need to be filled out are highlighted in red. <br>" 
			+ errorMessage);
		$('html, body').animate({ scrollTop: 0 }, 'slow');

	} 
	
}

function createAddressFailure(data, status, jqXHR){

	$("#facilityMessage").text("An error occured: " + data.responseJSON[0]);
	$('html, body').animate({ scrollTop: 0 }, 'slow');

}

function createAddressSuccess(data, status, jqXHR){

	// Repair facility vars
	var name = $("#repairFacilityName").val();
	var phoneNumber = $("#repairFacilityPhoneNumber").val();
	var laborRate = $("#repairFacilityLaborRate").val();
	var specialty = [];
	var facilityAddress = data.id;

	$(':checkbox:checked').each(function(i){
          specialty[i] = $(this).val();
        });
	if(validateFacility(name, phoneNumber, laborRate, specialty)) {

		$.ajax({
			type: "POST",
			url: "http://localhost:8080/repair_lst/repairfacility/",
			data: {
				name : name, phone : phoneNumber, hourlyRate : laborRate,
				specialization : specialty, addressId : facilityAddress
				},
			success: createFacilitySuccess, 
			error: createFacilityFailure
		});

	} else {

		$("#facilityMessage").html("Fields that need to be filled out are highlighted in red. <br>" 
			+ errorMessage);
		$('html, body').animate({ scrollTop: 0 }, 'slow');

	}
}

function createFacilitySuccess(data, status, jqXHR){

	var successMessage = "Repair facility: " + data.name + "<br> Successfully created.";
	$('html, body').animate({ scrollTop: 0 }, 'slow');

	$("#facilityMessage").html(successMessage);

}

function createFacilityFailure(data, status, jqXHR){

	$("#facilityMessage").html("An error occured: " + data.responseJSON[0]);
	$('html, body').animate({ scrollTop: 0 }, 'slow');
	
}

/*
	Form information validation function
*/

// provides "is it filled" validation for the facility formBox
function validateFacility(name, phoneNumber, laborRate, specialty){

	var nameBool = false;
	var phoneBool = false;
	var laborBool = false;
	var specialtyBool = false;
	var allChecksBool = false;

	if(name == ""){
		$("#repName").addClass("errorText");
		$("#repName").removeClass("validText");
		errorMessage += "Must enter a facility name <br>";
	} else {
		$("#repName").addClass("validText");
		$("#repName").removeClass("errorText");
		nameBool = true;
	}

	if(phoneNumber == ""){
		$("#repPhone").addClass("errorText");
		$("#repPhone").removeClass("validText");
		errorMessage += "Must enter a facility phone number <br>";
	} else {
		$("#repPhone").addClass("validText");
		$("#repPhone").removeClass("errorText");
		phoneBool = true;
	}

	if(laborRate == ""){
		$("#repRate").addClass("errorText");
		$("#repRate").removeClass("validText");
		errorMessage += "Must enter a labor rate (can be 0.00) <br>";
	} 
	else if(isNaN(laborRate)) {
		$("#repRate").addClass("errorText");
		$("#repRate").removeClass("validText");
		errorMessage += "Labor rate must be a number <br>";
	}else {
		$("#repRate").addClass("validText");
		$("#repRate").removeClass("errorText");
		laborBool = true;
	}

	if(specialty.length < 1){
		$("#repSpec").addClass("errorText");
		$("#repSpec").removeClass("validText");
		errorMessage += "Must select at least one specialty <br>";
	} else {
		$("#repSpec").addClass("validText");
		$("#repSpec").removeClass("errorText");
		specialtyBool = true;
	}

	if(nameBool && phoneBool && laborBool && specialtyBool) {

		allChecksBool = true;
	}

	return allChecksBool;
};

function validateAddress(street, city, state, zip){

	var streetBool = false;
	var cityBool = false;
	var zipBool = false;
	var allChecksBool = false;

	if(street == ""){
		$("#street").removeClass("validText");
		$("#street").addClass("errorText");
		errorMessage += "Must enter a street address <br>";
	} else {
		$("#street").removeClass("errorText");
		$("#street").addClass("validText");
		streetBool = true;
	}

	if(city == ""){
		$("#city").addClass("errorText");
		$("#city").removeClass("validText");
		errorMessage += "Must enter a city <br>";
	} else {
		$("#city").addClass("validText");
		$("#city").removeClass("errorText");
		cityBool = true;
	}

	if(state == ""){
		$("#state").addClass("errorText");
		$("#state").removeClass("validText");
	} else {
		$("#state").addClass("validText");
		$("#state").removeClass("errorText");
	}

	if(zip == ""){
		$("#zip").addClass("errorText");
		$("#zip").removeClass("validText");
		errorMessage += "Must enter a 5 digit zip code <br>";
	} 
	else if(isNaN(zip)){
		$("#zip").addClass("errorText");
		$("#zip").removeClass("validText");
		errorMessage += "Zip code must be a number <br>";
	}
	else if(zip.length > 5){
		$("#zip").addClass("errorText");
		$("#zip").removeClass("validText");
		errorMessage += "Must enter a 5 digit zip code <br>";
	} else {
		$("#zip").addClass("validText");
		$("#zip").removeClass("errorText");
		zipBool = true;
	}

	if(streetBool && cityBool && zipBool) {

		allChecksBool = true;
	}

	return allChecksBool;
};
