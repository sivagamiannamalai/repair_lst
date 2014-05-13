package com.pdxcycle9.repair_lst.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.RepairFacilityDAO;
import com.pdxcycle9.repair_lst.DAO.RepairItemDAO;
import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.entities.RepairItem;
import com.pdxcycle9.repair_lst.entities.Specialization;
import com.pdxcycle9.repair_lst.subservices.IsNotNull;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class CreateRepairItemService {
	
	@Autowired
	private RepairItemDAO repairItemDAO;
	
	@Autowired
	private IsValidLength isValidLength;
	
	@Autowired
	private IsNotNull isNotNull;
	
	/**
	 * Sets repair item object and validates all the elements
	 * 
	 * @param description
	 * @param dateData
	 * @param hourlyRate
	 * @param laborHours
	 * @param mileage
	 * @param rating
	 * @param userId
	 * @param repairTypeId
	 * @param repairFacilityId
	 * @param vehicleId
	 * @return
	 */
	public Response createRepairItem(String description,String dateData,BigDecimal hourlyRate,int laborHours,
			int mileage,int rating,int userId,int repairTypeId,int repairFacilityId,int vehicleId) {
		
		RepairItem repairItem = new RepairItem();
		Response response = new Response();
		List<String> errors = new ArrayList<String>();

		repairItem.setDescription(description);
		repairItem.setDateData(dateData);
		repairItem.setHourlyRate(hourlyRate);
		repairItem.setLaborHours(laborHours);
		repairItem.setMileage(mileage);
		repairItem.setRating(rating);
		repairItem.setUserId(userId);
		repairItem.setRepairTypeId(repairTypeId);
		repairItem.setRepairFacilityId(repairFacilityId);
		repairItem.setVehicleId(vehicleId);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			isNotNull.isFieldNotNull(dateData, errors);
			date = formatter.parse(dateData);
			repairItem.setDate(date);
		} catch (Exception e) {
			e.printStackTrace();
			errors.add(Error.IS_NULL);
		}

		if (
				isNotNull.isFieldNotNull(repairItem.getDescription(), errors)
				&& isNotNull.isBigDecimalValid(repairItem.getHourlyRate(), errors)
				&& isNotNull.isFieldNotEmpty(repairItem.getLaborHours(), errors)
				&& isNotNull.isFieldNotEmpty(repairItem.getMileage(), errors)
				&& isNotNull.isFieldNotEmpty(repairItem.getRating(), errors)
				&& isNotNull.isFieldNotEmpty(repairItem.getUserId(), errors)
				&& isNotNull.isFieldNotEmpty(repairItem.getRepairTypeId(), errors)
				&& isNotNull.isFieldNotEmpty(repairItem.getRepairFacilityId(), errors)
				&& isNotNull.isFieldNotEmpty(repairItem.getVehicleId(), errors)
				
				&& isValidLength.between1and255(repairItem.getDescription(), errors)
//				&& isValidLength.isDateValidLength(repairItem.getDate(), errors)
				&& isValidLength.isRatingValidLength(repairItem.getRating(), errors))

		{
			System.out.println("I got past validation!");
			response.setStatusCode(HttpStatus.OK);
			persistRepairItem(repairItem, response, errors);

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
	 * try/catch to persist the repair item object if validation succeeds
	 * @param repairItem
	 * @param response
	 * @param errors
	 */
	@Transactional
	public void persistRepairItem(RepairItem repairItem,
			Response response, List<String> errors) {

        RepairItem result = null;
		try {
		   result = repairItemDAO.persistRepairItem(repairItem);
		   response.setResponseObject(result);
		   response.setStatusCode(HttpStatus.OK);
		} catch (Exception e) {
			if (e.getCause().getClass() == ConstraintViolationException.class) {
                errors.add(Error.DUPLICATE_ITEM);			
			    failed(response, errors);
			}   		
		}

	}

	/**
	 * getters and setters for autowired entities
	 * @return
	 */
	public RepairItemDAO getRepairItemDAO() {
		return repairItemDAO;
	}

	public void setRepairItemDAO(RepairItemDAO repairItemDAO) {
		this.repairItemDAO = repairItemDAO;
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
