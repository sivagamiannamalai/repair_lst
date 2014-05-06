$(document).ready(function(){

	getAllRepairFacilitiesForUpdate ();
	$("#repairFacilityDropDown").change(getInfoOfSelectedRepairFacility);
});

function getAllRepairFacilitiesForUpdate () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairfacility",
        success: populateRepairFacilityDropDown
    });
}

function populateRepairFacilityDropDown(data){
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

	$("#repairFacilitySpecializationCheckboxes").find('input[type=checkbox]:checked').prop('checked', false);
	
	$("#streetAddressInput").val(data.address.street);
	$("#cityInput").val(data.address.city);
	$("#stateSelect").find('option[value="'+data.address.state+'"]').attr('selected', 'selected');
	$("#zipInput").val(data.address.zip);
	$("#repairFacilityName").val(data.name);
	$("#repairFacilityPhoneNumber").val(data.phone);
	$("#repairFacilityLaborRate").val(data.hourlyRate);
	
		for (var s = 0; s < data.specializations.length; s++){

			$("#repairFacilitySpecializationCheckboxes").find('input[value="'+data.specializations[s].id+'"]').prop('checked', true);
		}
	
}