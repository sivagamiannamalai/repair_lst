package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	 * function to call DAO to retrieve all repair facilities
	 * @return response
	 */
	@Transactional
	public Response retrieveAll() {

		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		List<RepairFacility> result = null;
		
		try {

			result = repairFacilityDAO.retrieveAllRepairFacility();
			response.setStatusCode(HttpStatus.OK);
			response.setResponseObject(result);
			
		} catch (Exception e) {

			response.setStatusCode(HttpStatus.BAD_REQUEST);
			response.setResponseObject(errors);
		}
		return response;

	}
/**
 * Calls DAO to get information of one repair facility, located by the ID given by
 * @param repairFacilityId
 * @return a repair facility object with the information needed
 */
	
	@Transactional
	public Response retrieveByID(int repairFacilityId) {



		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		RepairFacility result = null;
		
		try {

			result = repairFacilityDAO.retrieveRepairFacilityByID(repairFacilityId);
			response.setStatusCode(HttpStatus.OK);
			response.setResponseObject(result);
			
		} catch (Exception e) {

			response.setStatusCode(HttpStatus.BAD_REQUEST);
			response.setResponseObject(errors);

		}
		return response;

	}
	
}
