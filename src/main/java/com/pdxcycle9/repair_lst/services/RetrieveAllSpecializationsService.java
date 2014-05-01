package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.SpecializationDAO;
import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.entities.Specialization;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class RetrieveAllSpecializationsService {

	@Autowired
	private SpecializationDAO specializationDAO;
	
	/***
	 * 
	 * @param specializationDAO
	 */

	public void setSpecializationDAO(SpecializationDAO specializationDAO) {
		this.specializationDAO = specializationDAO;
	}
	@Transactional
	public Response retrieve() {

		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		List<Specialization> result = null;
		
		try {
			result = specializationDAO.retrieveAllSpecializations();
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
