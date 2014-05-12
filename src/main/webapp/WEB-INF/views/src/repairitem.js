$(document).ready(function(){

	//$("#createFacilitySubmit").click(postRepairFacility);
	console.log("Testing js");
	
	/*getAllVehicles();
	
	
	$("#selectVehicle").change(selectCurrentVehicle);*/
	getAllRepairTypes();
	getAllRepairFacilities();
	$("#repairFacilityDropDown").change(selectCurrentRepairFacility);
		
	/*getAllRepairTypes();*/
	/*$("#repairTypeDropDown").change(selectCurrentRepairType);	*/
	$("#submitRepairItem").click(validateRepairItem);


var errorMessage = "";

var dateOfRepair = $("#repairItemDateOfRepairInput").val();
var mileageAtTimeOfRepair = $("#repairItemMileageInput").val();
var hourlyRateOfRepairFacility = $("#repairItemHourlyRateInput").val();
var repairItemDescription = $("#repairItemDescriptionInput").val();

	var validDate;
	var validLaborHours;
	var validMileage;
	var validHourlyRate;
	var validRating;
	var loggedIn;
	var selectedRepairFacility;
	var selectedVehicle;
	var selectedRepairType;

function getAllVehicles() {
	$("#vehicleDropDown").empty();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/vehicle",
        success: populateVehicleDropDown
    });
}
/*
function populateVehicleDropDown(data){
    
	$("vehicleDropDown").append('<option id = "-1"></option>' );
	
	for(var i = 0; i < data.length; i++){
        $("#vehicleDropDown").append(
		'<option id="' + 
		data[i].id +'">'+ 
		data[i].make + ': ' + 
		data[i].model + ', ' + 
		data[i].vin + ', ' + 
		data[i].mileage +
		data[i].year
		'</option>');
    }
}
*/

function getAllRepairFacilities () {
	$("#repairFacilityDropDown").empty();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairfacility",
        success: populateRepairFacilityDropDown
    });
}

function selectCurrentRepairFacility (){
	var selectedRepairFacilityID = $("#repairFacilityDropDown").children(":selected").attr("id");
	 
	 if (selectedRepairFacilityID > 0){
	 
	 $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairfacility/"+ selectedRepairFacilityID,
        success: populateRepairFacilityUpdateFields
    });
	}
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

function getAllRepairTypes () {
	$("#typeofRepairDropDown").empty();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairtype",
        success: populateRepairTypeDropDown
    });
}

function populateRepairTypeDropDown(data){
    
	$("#typeofRepairDropDown").append('<option id = "-1"></option>' );
	
	for(var i = 0; i < data.length; i++){
        $("#typeofRepairDropDown").append(
		'<option id="' + 
		data[i].id +'">'+ 
		data[i].type + '</option>');
    }
}

function validateRepairItem () {
	var validDate = false;
	var validLaborHours = false;
	var validMileage = false;
	var validHourlyRate = false;
	var validRating = false;
	var loggedIn = false;
	var selectedRepairFacility = false;
	var selectedVehicle = false;
	var selectedRepairType = false;
	
	if (!isNaN(dateOfRepair) && dateOfRepair.length == 6) {
		validDate = true;
		console.log("Date is valid.");
	} /*
	$("#repairItemMessage").html("Fields that need to be filled out are highlighted in red. <br>" 
			+ errorMessage);
		$('html, body').animate({ scrollTop: 0 }, 'slow');*/
}

function addRepairItem() {
	
	
}

/*var dateOfRepair = $("#repairItemDateOfRepairInput").val();
var mileageAtTimeOfRepair = $("#repairItemMileageInput").val();
var hourlyRateOfRepairFacility = $("#repairItemHourlyRateInput").val();
var repairItemDescription = $("#repairItemDescriptionInput").val();*/


});