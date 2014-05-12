package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.PartDAO;
import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.subservices.ValidateResults;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class RetrieveAllPartsService {

	@Autowired
	private PartDAO partDAO;

	@Autowired
	private ValidateResults validateResults;

	/***
	 * 
	 * @param partDAO
	 */
	
	public void setPartDAO(PartDAO partDAO) {
		this.partDAO = partDAO;
	}

	public void setValidateResults(ValidateResults validateResults) {
		this.validateResults = validateResults;
	}

	/***
	 * Attempts to contact the part DAO in order to retrieve all
	 * parts.
	 * 
	 * @return
	 */
		@Transactional
	public Response retrieve() {

		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		List<Part> result = null;

		try {
			result = partDAO.retrieveAllParts();
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
