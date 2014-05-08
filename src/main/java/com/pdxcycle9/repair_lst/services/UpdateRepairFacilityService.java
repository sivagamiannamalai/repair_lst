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
import com.pdxcycle9.repair_lst.util.Response;
import com.pdxcycle9.repair_lst.util.Error;

@Service
public class UpdateRepairFacilityService {

	@Autowired
	RepairFacilityDAO repairFacilityDAO;

	@Autowired
	IsValidLength isValidLength;

	@Autowired
	IsNotNull isNotNull;

	/**
	 * update repair facility validation
	 * 
	 * @param repairFacility
	 * @param address
	 * @return
	 */

	public Response updateRepairFacility(RepairFacility repairFacility,
			int[] specialization) {

		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		ArrayList<Specialization> specializationList;

		repairFacility
				.setSpecializations(updateSpecializationList(specialization));

		if (
				isNotNull.isFieldNotNull(repairFacility.getName(), errors)
				&& isNotNull.isFieldNotNull(repairFacility.getPhone(), errors)
				&& isNotNull.isHourlyRateValid(repairFacility.getHourlyRate(), errors)
				&& isValidLength.between1and255(repairFacility.getName(), errors)
				&& isValidLength.isPhoneValidLength(repairFacility.getPhone(), errors))

		{

			response.setStatusCode(HttpStatus.OK);
			updateRepairFacility(repairFacility, response, errors);

		} else {

			failed(response, errors);

		}

		return response;
	}

	public void failed(Response response, List<String> errors) {

		response.setResponseObject(errors);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
	}

	/**
	 * update try/catch if validation succeeds
	 * 
	 * @param repairFacility
	 * @param response
	 * @param errors
	 */
	@Transactional
	public void updateRepairFacility(RepairFacility repairFacility,
			Response response, List<String> errors) {

		RepairFacility original = null;
        RepairFacility updated = repairFacility;


		try {
			original = repairFacilityDAO.retrieveRepairFacilityByID(repairFacility.getId());
            updateRepairFacility(original, updated);
            repairFacilityDAO.updateRepairFacility(original);
            response.setResponseObject(repairFacilityDAO.retrieveRepairFacilityByID(original.getId()));
            response.setStatusCode(HttpStatus.OK);

		} catch (IdentifierGenerationException e) {
			errors.add(Error.DUPLICATE_RECORD);
			failed(response, errors);

		} catch (Exception e) {
			errors.add(Error.CANNOT_UPDATE);
			failed(response, errors);

		}

	}
	
	private void updateRepairFacility(RepairFacility original, RepairFacility updated){
        original.setAddress(updated.getAddress());
        original.setHourlyRate(updated.getHourlyRate());
        original.setName(updated.getName());
        original.setPhone(updated.getPhone());
        original.setRating(updated.getRating());
        original.setSpecializations(updated.getSpecializations());
        
        
	}

	public ArrayList<Specialization> updateSpecializationList(
			int[] specialization) {

		ArrayList<Specialization> specializationList = new ArrayList<Specialization>();
		
		Specialization thingToUpdate = null;

		for (int i = 0; i < specialization.length; i++) {

			thingToUpdate = new Specialization(specialization[i]);

			specializationList.add(thingToUpdate);

		}

		return specializationList;
	}

	/**
	 * getters and setters for the autowired entities
	 * 
	 * @return
	 */

	public RepairFacilityDAO getRepairFacilityDAO() {
		return repairFacilityDAO;
	}

	public void setRepairFacilityDAO(RepairFacilityDAO repairFacilityDAO) {
		this.repairFacilityDAO = repairFacilityDAO;
	}

	public IsValidLength getIsValidLength() {
		return isValidLength;
	}

	public void setIsValidLength(IsValidLength isValidLength) {
		this.isValidLength = isValidLength;
	}

	public IsNotNull getIsNotNull() {
		return isNotNull;
	}

	public void setIsNotNull(IsNotNull isNotNull) {
		this.isNotNull = isNotNull;
	}

}
