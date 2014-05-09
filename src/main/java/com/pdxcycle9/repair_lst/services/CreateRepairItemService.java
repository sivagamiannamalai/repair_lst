package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.RepairFacilityDAO;
import com.pdxcycle9.repair_lst.DAO.RepairItemDAO;
import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
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
	
	
	public Response createRepairItem(RepairItem repairItem, int[] parts) {
		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		ArrayList<Part> partsList;

//		repairItem.setParts(updatePartsList(parts));
//
//		if (
//				isNotNull.isFieldNotNull(repairItem.getDescription(), errors)
//				&& isNotNull.isFieldNotEmpty(repairItem.getDate(), errors)
//				&& isNotNull.isHourlyRateValid(repairItem.getHourlyRate(), errors)
//				&& isNotNull.isFieldNotEmpty(repairItem.getLaborHours(), errors)
//				
//				&& isValidLength.between1and255(repairItem, errors)
//				&& isValidLength.isPhoneValidLength(repairItem, errors))
//
//		{
//
//			response.setStatusCode(HttpStatus.OK);
//			updateRepairItem(repairItem, response, errors);
//
//		} else {
//
//			failed(response, errors);
//
//		}

		return response;
		
	}

}
