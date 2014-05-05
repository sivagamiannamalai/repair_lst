package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.RepairFacilityDAO;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.entities.Specialization;
import com.pdxcycle9.repair_lst.subservices.IsNotNull;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class CreateRepairFacilityService {
	@Autowired
	RepairFacilityDAO repairFacilityDAO;
	
	@Autowired
	IsValidLength isValidLength;
	
	@Autowired
	IsNotNull isNotNull;
   
	
	public Response createRepairFacility(RepairFacility repairFacility, int[] specialization) {
		
		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();		
		boolean fieldsNotNull = false;
		boolean fieldsCorrectLength = false;				
		
		repairFacility.setSpecializations(makeSpecializationList(specialization));	
		
		
		if(isNotNull.isFieldNotNull(repairFacility.getName(), errors) &&
		   isNotNull.isFieldNotNull(repairFacility.getPhone(), errors) && 
		   isNotNull.isHourlyRateValid(repairFacility.getHourlyRate(), errors))  {		
			fieldsNotNull = true;
		}
		
		if(isValidLength.between1and255(repairFacility.getName(), errors) &&
				isValidLength.isPhoneValidLength(repairFacility.getPhone(), errors)) {
			  fieldsCorrectLength = true;
		}
				
				
		if(fieldsNotNull && fieldsCorrectLength) {
			 persistRepairFacility(repairFacility, response, errors);
		}  else {
			failed(response, errors);
		}
		
		return response;
	}
	
	public void failed(Response response, List<String> errors) {
		response.setResponseObject(errors);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
	}
	
	@Transactional
	public void persistRepairFacility(RepairFacility repairFacility, Response response,
			                             List<String> errors)  {
		
		RepairFacility result = null;
		try {
		   result = repairFacilityDAO.persistRepairFacility(repairFacility);
		   response.setResponseObject(result);
		   response.setStatusCode(HttpStatus.OK);
		} catch (Exception e) {
			if (e.getCause().getClass() == ConstraintViolationException.class) {
                errors.add(Error.DUPLICATE_RECORD);			
			    failed(response, errors);
			}   		
		}			
		 
	}
	
	
	public ArrayList<Specialization> makeSpecializationList(int[] specialization){
		
		ArrayList<Specialization> specializationList = new ArrayList<Specialization>();
		
		for(int i = 0; i < specialization.length; i++) {
			
			Specialization thingToAdd = new Specialization(specialization[i]);
			
			specializationList.add(thingToAdd);
			
		}
		
		return specializationList;
	}

}
