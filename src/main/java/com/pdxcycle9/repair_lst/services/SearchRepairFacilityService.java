package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.pdxcycle9.repair_lst.DAO.RepairFacilityDAO;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.util.Response;

@Component
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

	public Response retrieve() {

		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		Collection<RepairFacility> result = null;
		
		try {
			result = repairFacilityDAO.retrieveRepairFacility();

		} catch (Exception e) {
			response.setStatusCode(HttpStatus.BAD_REQUEST);
		}
		return response;

	}

}
