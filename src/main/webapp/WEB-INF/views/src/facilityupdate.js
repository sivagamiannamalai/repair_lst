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
	 $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairfacility",
		data: { id :  selectedRepairFacilityID},
        success: populateRepairFacilityUpdateFields
    });
}

function populateRepairFacilityUpdateFields() {



}