$(document).ready(function(){

	$("#searchForRepairFacility").click(getRepairFacilityRating);
	
});

function getRepairFacilityRating(){
	var name = $("#requestedRepairFacility").val();
	
		if(name == ""){
			$("#repairFacilityName").html("You need to at least enter something into the text box");
			$("#repairFacilityRating").html("");
		}
		
		else if(name.length > 255){
			$("#repairFacilityName").html("Search parameters must not be any more than 255 characters in length");
			$("#repairFacilityRating").html("");
		}
		
		else {
			 $.ajax({
				type: "GET",
				url: "http://localhost:8080/repair_lst/repairfacilityrating/"+ name,
				success: displayRepairFacilityRating,
				error: failedToGetRatings
			});		
		}
}

function displayRepairFacilityRating(data){
	console.log(data.rating);
	var ratingCountdown = +data.rating;
	var emptyStarCount = 5 - data.rating;
	$("#repairFacilityName").html("<h4>Repair Facility Name:</h4>");
	$("#repairFacilityName").append("<h2>"+data.name+"</h2>");
	$("#repairFacilityRating").html("<h4>Repair Facility Rating:</h4>");

	if (ratingCountdown >= 1 && ratingCountdown < 1.5){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
		}
	else if(ratingCountdown >= 1.5 && ratingCountdown < 2){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/halfwrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");					
		}
	else if(ratingCountdown >= 2 && ratingCountdown < 2.5){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");					
		}
	else if(ratingCountdown >= 2.5 && ratingCountdown < 3){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/halfwrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");				
		}
	else if(ratingCountdown >= 3 && ratingCountdown < 3.5){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");				
		}
	else if(ratingCountdown >= 3.5 && ratingCountdown < 4){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/halfwrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");			
		}
	else if(ratingCountdown >= 4 && ratingCountdown < 4.5){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/nowrench.png></img>");			
		}
	else if(ratingCountdown >= 4.5 && ratingCountdown < 5){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/halfwrench.png></img>");			
		}
	else if(ratingCountdown = 5){
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");
			$("#repairFacilityRating").append("<img src=../../img/wholewrench.png></img>");			
		}
}

function failedToGetRatings(data, status, jqXHR){

$("#repairFacilityName").html(data.responseJSON);

$("#repairFacilityRating").html("");

}