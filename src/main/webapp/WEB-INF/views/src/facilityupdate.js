$(document).ready(function(){

	getAllRepairFacilitiesForUpdate ();
	$("#repairFacilityDropDown").change(getInfoOfSelectedRepairFacility);
	$("#updateFacilitySubmit").click(updateRepairFacility);
	
});

var errorMessage = "";
var selectedRepairfacilityAddressID = "";

function getAllRepairFacilitiesForUpdate () {
	$("#repairFacilityDropDown").empty();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairfacility",
        success: populateRepairFacilityDropDown
    });
}

function populateRepairFacilityDropDown(data){
    
	$("#repairFacilityDropDown").append('<option id = "-1"></option>' );
	
	for(var i = 0; i < data.length; i++){
        $("#repairFacilityDropDown").append(
		'<option id="' + 
		data[i].id +'">'+ 
		data[i].name + ': ' + 
		data[i].address.street + ', ' + 
		data[i].address.city + ', ' + 
		data[i].address.state +
		'</option>');
    }
}

function getInfoOfSelectedRepairFacility (){
	var selectedRepairFacilityID = $("#repairFacilityDropDown").children(":selected").attr("id");
	 
	 if (selectedRepairFacilityID > 0){
	 
	 $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairfacility/"+ selectedRepairFacilityID,
        success: populateRepairFacilityUpdateFields
    });
	}
}

function populateRepairFacilityUpdateFields(data) {
	selectedRepairfacilityAddressID = data.address.id;

	$("#repairFacilitySpecializationCheckboxes").find('input[type=checkbox]:checked').prop('checked', false);
	
	$("#repairFacilityName").val(data.name);
	$("#repairFacilityPhoneNumber").val(data.phone);
	$("#repairFacilityLaborRate").val(data.hourlyRate);
	
		for (var s = 0; s < data.specializations.length; s++){

			$("#repairFacilitySpecializationCheckboxes").find('input[value="'+data.specializations[s].id+'"]').prop('checked', true);
		}
	
}

function updateRepairFacility(){

	errorMessage = "";

	// Address vars
	var id = $("#repairFacilityDropDown").children(":selected").attr("id");
	var addressId = selectedRepairfacilityAddressID;
	var name = $("#repairFacilityName").val();
	var phoneNumber = $("#repairFacilityPhoneNumber").val();
	var laborRate = $("#repairFacilityLaborRate").val();
	var specialty = [];

	$(':checkbox:checked').each(function(i){
          specialty[i] = $(this).val();
        });
		
	if(validateFacility(name, phoneNumber, laborRate, specialty)) {

		$.ajax({
			type: "PUT",
			url: "http://localhost:8080/repair_lst/repairfacility/",
			data: { 
				id : id, name : name, phone : phoneNumber, hourlyRate : laborRate,
				specialization : specialty, addressId : addressId
				},
			success: updateFacilitySuccess, 
			error: updateFacilityFailure
		});

	} else {

		$("#facilityMessage").html("Fields that need to be filled out are highlighted in red. <br>" 
			+ errorMessage);
		$('html, body').animate({ scrollTop: 0 }, 'slow');

	}
}

function updateFacilitySuccess(data, status, jqXHR){

	var successMessage = "Repair facility: " + data.name + "<br> Successfully Updated.";
	getAllRepairFacilitiesForUpdate ();
	$('html, body').animate({ scrollTop: 0 }, 'slow');

	$("#facilityMessage").html(successMessage);

}

function updateFacilityFailure(data, status, jqXHR){

	$("#facilityMessage").html("An error occurred: " + data.responseJSON[0]);
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
		$("#repairFacilityName").addClass("errorText");
		$("#repairFacilityName").removeClass("validText");
		errorMessage += "Must enter a facility name <br>";
	} else {
		$("#repairFacilityName").addClass("validText");
		$("#repairFacilityName").removeClass("errorText");
		nameBool = true;
	}

	if(phoneNumber == ""){
		$("#repairFacilityPhoneNumber").addClass("errorText");
		$("#repairFacilityPhoneNumber").removeClass("validText");
		errorMessage += "Must enter a 10-digit facility phone number <br>";
	} 
	else if(isNaN(phoneNumber)) {
		$("#repairFacilityPhoneNumber").addClass("errorText");
		$("#repairFacilityPhoneNumber").removeClass("validText");
		errorMessage += "Phone number may contain only numeric characters <br>";
	}
	else if(phoneNumber.length !== 10) {
		$("#repairFacilityPhoneNumber").addClass("errorText");
		$("#repairFacilityPhoneNumber").removeClass("validText");
		errorMessage += "Phone number may be only 10 digits long <br>";
	} else {
		$("#repairFacilityPhoneNumber").addClass("validText");
		$("#repairFacilityPhoneNumber").removeClass("errorText");
		phoneBool = true;
	}

	if(laborRate == ""){
		$("#repairFacilityLaborRate").addClass("errorText");
		$("#repairFacilityLaborRate").removeClass("validText");
		errorMessage += "Must enter a labor rate (can be 0.00) <br>";
	} 
	else if(isNaN(laborRate)) {
		$("#repairFacilityLaborRate").addClass("errorText");
		$("#repairFacilityLaborRate").removeClass("validText");
		errorMessage += "Labor rate must be a number <br>";
	}
	else if(laborRate.length > 5) {
		$("#repairFacilityLaborRate").addClass("errorText");
		$("#repairFacilityLaborRate").removeClass("validText");
		errorMessage += "Labor rate cannot be longer than 5 characters <br>";
	} else {
		$("#repairFacilityLaborRate").addClass("validText");
		$("#repairFacilityLaborRate").removeClass("errorText");
		laborBool = true;
	}

	if(specialty.length < 1){
		$("#repairFacilitySpecializationCheckboxes").addClass("errorText");
		$("#repairFacilitySpecializationCheckboxes").removeClass("validText");
		errorMessage += "Must select at least one specialty <br>";
	} else {
		$("#repairFacilitySpecializationCheckboxes").addClass("validText");
		$("#repairFacilitySpecializationCheckboxes").removeClass("errorText");
		specialtyBool = true;
	}

	if(nameBool && phoneBool && laborBool && specialtyBool) {

		allChecksBool = true;
	}

	return allChecksBool;
};

