$(document).ready(function(){

var validDate;
var validLaborHours;
var validMileage;
var validHourlyRate;
var validRating;
var loggedIn;
var selectedRepairFacility;
var selectedVehicle;
var selectedRepairType;
var errorMessage = "";
	
	// $("#createFacilitySubmit").click(postRepairFacility);
	console.log("Testing js");
	
	// getAllVehicles();
	
	
	// $("#selectVehicle").change(selectCurrentVehicle);
	getAllRepairTypes();
	getAllRepairFacilities();
	getAllRepairParts();
	$("#repairFacilityDropDown").change(selectCurrentRepairFacility);
		
	// getAllRepairTypes();
	// $("#repairTypeDropDown").change(selectCurrentRepairType);
	// $("#submitRepairItem").click(validateRepairItem);

var dateOfRepair = $("#repairItemDateOfRepairInput").val();
var mileageAtTimeOfRepair = $("#repairItemMileageInput").val();
var hourlyRateOfRepairFacility = $("#repairItemHourlyRateInput").val();
var repairItemDescription = $("#repairItemDescriptionInput").val();

function getAllVehicles() {
	$("#vehicleDropDown").empty();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/vehicle",
        success: populateVehicleDropDown
    });
}
/* This populate function relies on the user being logged in
   and having access to that specific user's vehicles. The
   back end needs to be written for a 'retrieve all vehicles
   by user id' feature.

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

function getAllRepairParts () {
	$("#repairPartsField").empty();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/parts",
        success: populateRepairPartField
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

function populateRepairPartField(data){
    
	// $("#repairPartsField").append('<option id = "-1"></option>' );
	
	for(var i = 0; i < data.length; i++){
        $("#repairPartsField").append('<input type="checkbox" id="' + data[i].id + '">' + data[i].name + '<br/>');
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
console.log("Adding repair item.");
	
	
}

/*var dateOfRepair = $("#repairItemDateOfRepairInput").val();
var mileageAtTimeOfRepair = $("#repairItemMileageInput").val();
var hourlyRateOfRepairFacility = $("#repairItemHourlyRateInput").val();
var repairItemDescription = $("#repairItemDescriptionInput").val();*/


});