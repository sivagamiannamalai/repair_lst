package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.RepairTypeDAO;
import com.pdxcycle9.repair_lst.entities.RepairType;
import com.pdxcycle9.repair_lst.subservices.ValidateResults;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class RetrieveAllRepairTypesService {

	@Autowired
	private RepairTypeDAO repairTypeDAO;

	@Autowired
	private ValidateResults validateResults;

	/***
	 * 
	 * @param repairTypeDAO
	 */

	public void setRepairTypeDAO(RepairTypeDAO repairTypeDAO) {
		this.repairTypeDAO = repairTypeDAO;
	}

	public void setValidateResults(ValidateResults validateResults) {
		this.validateResults = validateResults;
	}

	/***
	 * Attempts to contact the repair type DAO in order to retrieve all
	 * repair types.
	 * 
	 * @return
	 */
	@Transactional
	public Response retrieve() {

		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		List<RepairType> result = null;

		try {
			result = repairTypeDAO.retrieveAllRepairTypes();
			response.setStatusCode(HttpStatus.OK);
			response.setResponseObject(result);

		} catch (Exception e) {
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			response.setResponseObject(errors);
		}
		validateResults.isNotEmpty(errors, result, response);
		return response;

	}

}
