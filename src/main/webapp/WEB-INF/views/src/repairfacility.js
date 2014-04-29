$(document).ready(function(){

	$("#createFacilitySubmit").click(postRepairFacility);

});

function postRepairFacility(){

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

		$("#facilityMessage").text("Fields that need to be filled out are highlighted in red.");
		$('html, body').animate({ scrollTop: 0 }, 'slow');

	} 
	
}

function createAddressFailure(data, status, jqXHR){

	$("#facilityMessage").text("Some part of creating an address failed.");
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

		$("#facilityMessage").text("All fields are required to submit a new repair facility.");

	}
}

function createFacilitySuccess(data, status, jqXHR){

	var successMessage = "Repair facility: " + data.name + "<br> Successfully created.";
	$('html, body').animate({ scrollTop: 0 }, 'slow');

	$("#facilityMessage").html(successMessage);

}

function createFacilityFailure(data, status, jqXHR){

	$("#facilityMessage").html("Repair facility failed to persist to the database.");
	$('html, body').animate({ scrollTop: 0 }, 'slow');
	
}

/*
	Form information validation function
*/

// provides "is it filled" validation for the facility formBox
function validateFacility(name, phoneNumber, laborRate, specialty){

	var bool = false;

	if(name == ""){
		$("#repName").addClass("errorText");
		$("#repName").removeClass("validText");
	} else {
		$("#repName").addClass("validText");
		$("#repName").removeClass("errorText");
	}

	if(phoneNumber == ""){
		$("#repPhone").addClass("errorText");
		$("#repPhone").removeClass("validText");
	} else {
		$("#repPhone").addClass("validText");
		$("#repPhone").removeClass("errorText");
	}

	if(laborRate == ""){
		$("#repRate").addClass("errorText");
		$("#repRate").removeClass("validText");
	} else {
		$("#repRate").addClass("validText");
		$("#repRate").removeClass("errorText");
	}

	if(specialty.length < 1){
		$("#repSpec").addClass("errorText");
		$("#repSpec").removeClass("validText");
	} else {
		$("#repSpec").addClass("validText");
		$("#repSpec").removeClass("errorText");
	}

	if(name != "" && phoneNumber != "" && laborRate != "" && 
		specialty.length > 0) {

		bool = true;
	}

	return bool;
};

function validateAddress(street, city, state, zip){

	var bool = false;

	if(street == ""){
		$("#street").removeClass("validText");
		$("#street").addClass("errorText");
	} else {
		$("#street").removeClass("errorText");
		$("#street").addClass("validText");
	}

	if(city == ""){
		$("#city").addClass("errorText");
		$("#city").removeClass("validText");
	} else {
		$("#city").addClass("validText");
		$("#city").removeClass("errorText");
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
	} else {
		$("#zip").addClass("validText");
		$("#zip").removeClass("errorText");
	}

	if(street != "" && city != "" && zip != "") {

		bool = true;
	}

	return bool;
};
