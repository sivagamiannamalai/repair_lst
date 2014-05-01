package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.RepairFacilityDAO;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class SearchRepairFacilityService {

	@Autowired
	private RepairFacilityDAO repairFacilityDAO;

	/**
	 * @param transactionDAO
	 *            the transactionDAO to set
	 */
	
	
	public void setRepairFacilityDAO(RepairFacilityDAO repairFacilityDAO) {
		this.repairFacilityDAO = repairFacilityDAO;
	}
	@Transactional
	public Response retrieve() {

		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		List<RepairFacility> result = null;
		
		try {
			result = repairFacilityDAO.retrieveRepairFacility();
			response.setStatusCode(HttpStatus.OK);
			response.setResponseObject(result);
			
		} catch (Exception e) {
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			response.setResponseObject(errors);
			System.out.println(e.getMessage());
		}
		return response;

	}

}
