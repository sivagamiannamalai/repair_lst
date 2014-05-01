$(document).ready(function(){

	$("#retrieveAllButton").click(getAllRepairFacilities);
	
});

function getAllRepairFacilities () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/repair_lst/repairfacility",
        success: populateRepairFacilities
    });
}

function populateRepairFacilities(data){

	for(var i = 0; i < data.length; i++){
        $("#repairFacilitySearchResults").append(
			'<tr>' +
			'<th>' + data[i].name + '</th>' + 
			'<th>' + data[i].address + '</th>' + 
			'<th>' + data[i].city + '</th>' + 
			'<th>' + data[i].state + '</th>' + 
			'<th>' + data[i].zip + '</th>' + 
			'<th>' + data[i].phone + '</th>' + 
			'<th>' + data[i].hourly_rate + '</th>' + 
			'<th>' + data[i].rating + '</th>' + 
			'</tr>'
			);
    }

}
