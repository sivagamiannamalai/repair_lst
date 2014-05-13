package com.pdxcycle9.repair_lst.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pdxcycle9.repair_lst.DAO.RatingDAO;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.entities.RepairItem;
import com.pdxcycle9.repair_lst.subservices.IsNotNull;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class RepairFacilityRatingService {

	@Autowired
	IsValidLength isValidLength;

	@Autowired
	IsNotNull isNotNull;
	
	@Autowired
	RatingDAO ratingDAO;
	
	public Response getRatingByName(String repairFacilityNameToSearch){
		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();		
		boolean fieldsNotNull = false;
		boolean fieldsCorrectLength = false;				
		
		
		if(isNotNull.isFieldNotNull(repairFacilityNameToSearch, errors)){
			fieldsNotNull = true;
		}
		
		if(isValidLength.between1and255(repairFacilityNameToSearch, errors)){
			fieldsCorrectLength = true;
		}
		
		if(fieldsNotNull && fieldsCorrectLength) {
			findRepairFacilityRatings(repairFacilityNameToSearch, response, errors);
		}  else {
			failed(response, errors);
		}
		
		return response;
	}
		
	public void failed(Response response, List<String> errors) {
		response.setResponseObject(errors);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
	}
	
	public Response findRepairFacilityRatings(String repairFacilityNameToSearch, Response response,List<String> errors){
		RepairFacility rating = null;
		
		try {
			rating = ratingDAO.getRepairFacilityRating(repairFacilityNameToSearch);
			response.setStatusCode(HttpStatus.OK);
			response.setResponseObject(rating);
		} catch (Exception e) {

			response.setStatusCode(HttpStatus.BAD_REQUEST);
			response.setResponseObject(errors);
		}
		return response;
	}
	
	
}
