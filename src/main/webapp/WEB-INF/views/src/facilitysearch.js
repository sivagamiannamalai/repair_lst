$(document).ready(function(){

	getAllRepairFacilities ();
	
});

function getAllRepairFacilities () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairfacility",
        success: populateRepairFacilities,
		failure: getAllRepairFacilitiesFailed
    });
}

function populateRepairFacilities(data){

	if (data.length > 0){
	$('#displayRepairFacilityError').html("");
	for(var i = 0; i < data.length; i++){
		var specializationsLength = data[i].specializations.length;
		
        $("#repairFacilitySearchResults").append(
			'<tr>' +
			'<th>' + data[i].name + '</th>' + 
			'<th>' + data[i].address.street + '</th>' + 
			'<th>' + data[i].address.city + '</th>' + 
			'<th>' + data[i].address.state + '</th>' + 
			'<th>' + data[i].address.zip + '</th>' + 
			'<th>' + data[i].phone + '</th>' + 
			'<th>' + data[i].hourlyRate + '</th>' +  
			'<th id = "specializations'+i+'">'
			);		
				
				for (var s = 0; s < specializationsLength; s++){
					if (s < specializationsLength - 1){
					$("#specializations"+i).append(data[i].specializations[s].type + ', ');
					}
					else {
					$("#specializations"+i).append(data[i].specializations[s].type);
					}
				}
		$("#repairFacilitySearchResults").append('</th>');
		$("#repairFacilitySearchResults").append('</tr>');
    }
	$('table').trigger('update').trigger('appendCache');
	}
	
	else {
	
	$('#displayRepairFacilityError').html("No Repair Facilities Found");
	
	}
	
}

function getAllRepairFacilitiesFailed(data, status, jqXHR){

console.log("FAIL");

}
