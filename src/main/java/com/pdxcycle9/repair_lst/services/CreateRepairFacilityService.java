package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.id.IdentifierGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
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
   
	@Transactional
	public Response createRepairFacility(RepairFacility repairFacility, int[] specialization) {
		
		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		ArrayList<Specialization> specializationList;
		boolean fieldsNotNull = false;
		boolean fieldsCorrectLength = false;		
		boolean validPhone = false;

		System.out.println("I made it to create");
		
		//repairFacility.setSpecializations(makeSpecializationList(specialization));
		
		System.out.println("I made a specialization list " );
		
		
		if(isNotNull.isFieldNotNull(repairFacility.getName(), errors) &&
		   isNotNull.isFieldNotNull(repairFacility.getPhone(), errors) && 
		   isNotNull.isHourlyRateNotEmpty(repairFacility.getHourlyRate(), errors))  {		
			fieldsNotNull = true;
		}
		
		if(isValidLength.between1and255(repairFacility.getName(), errors)) {
			  fieldsCorrectLength = true;
		}
		
		
		int phoneLength = repairFacility.getPhone().length();
		if (phoneLength > 0) {
			validPhone = true;
		}
		
		if(fieldsNotNull && fieldsCorrectLength && validPhone) {
			 persistRepairFacility(repairFacility, response, errors);
		}  else {
			failed(response, errors);
		}
		
		return response;
	}
	
	public void failed(Response response, List<String> errors) {
		System.out.println("Inside Failed method");
		response.setResponseObject(errors);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
	}
	
	
	public void persistRepairFacility(RepairFacility repairFacility, Response response,
			                             List<String> errors)  {
		
		RepairFacility result = null;
		try {
		   result = repairFacilityDAO.persistRepairFacility(repairFacility);
		   System.out.println("Result inside service " + result.getClass());
		   response.setResponseObject(result);
		   response.setStatusCode(HttpStatus.OK);
		} catch (IdentifierGenerationException e){
			errors.add(Error.DUPLICATE_RECORD);
			failed(response, errors);
			
		} catch (Exception e) {
			errors.add(Error.CANNOT_PERSIST);
			failed(response, errors);
			System.out.println(e.getMessage());
		}
		
		
		 
	}
	
	public ArrayList<Specialization> makeSpecializationList(int[] specialization){
		
		ArrayList<Specialization> specializationList = new ArrayList<Specialization>();
		
		for(int i = 0; i < specialization.length; i++) {
			
			Specialization thingToAdd = new Specialization(specialization[i]);
			
			specializationList.add(thingToAdd);
			
		}
		
		System.out.println("This should be an array of specializations " + specializationList.size());
		
		return specializationList;
	}

}
