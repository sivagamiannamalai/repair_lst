package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.VehicleDAO;
import com.pdxcycle9.repair_lst.entities.Vehicle;
import com.pdxcycle9.repair_lst.subservices.ValidateResults;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class RetrieveVehicleByUserIdService {

	@Autowired
	private VehicleDAO vehicleDAO;
	
	@Autowired
	private ValidateResults validateResults;

	@Transactional
	public Response retrieveByUserId(int vehicleUserId) {

		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		List<Vehicle> result = null;

		try {
			result = vehicleDAO.retrieveVehicleByUserID(vehicleUserId);
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
