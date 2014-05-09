$(document).ready(function(){

	$("#searchForRepairFacility").click(getRepairFacilityRating);
	
});

function getRepairFacilityRating(){

	var name = $("#requestedRepairFacility").val();
	
		if(name == ""){
		
		}
		
		else {		
			 $.ajax({
				type: "GET",
				url: "http://localhost:8080/repair_lst/repairfacilityrating/"+ name,
				success: displayRepairFacilityRating,
				failure: failedToGetRatings
			});		
		}
}

function displayRepairFacilityRating(data){

	

}