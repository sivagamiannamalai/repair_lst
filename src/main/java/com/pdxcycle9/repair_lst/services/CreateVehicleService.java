package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.VehicleDAO;
import com.pdxcycle9.repair_lst.entities.Vehicle;
import com.pdxcycle9.repair_lst.subservices.IsValidMileage;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

@Transactional
@Service
public class CreateVehicleService {
	@Autowired
	private VehicleDAO vehicleDAO;

	@Autowired
	private IsValidMileage isValidMileage;

	public Response createVehicle(Vehicle vehicle) {

		Response response = new Response();
		List<String> errors = new ArrayList<String>();

		if (isValidMileage.between0and999999(vehicle.getMileage())) {

			persistVehicle(vehicle, response, errors);

		} else {
			errors.add(Error.MILEAGE_IS_OUT_OF_RANGE);
			failed(response, errors);

		}

		return response;
		
	}

	public void failed(Response response, List<String> errors) {
		System.out.println("Validation failed");
		response.setResponseObject(errors);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
	}

	public void persistVehicle(Vehicle vehicle, Response response,
			List<String> errors) {

		Vehicle result = null;
		try {
			result = vehicleDAO.persistVehicle(vehicle);
			response.setResponseObject(result);
			response.setStatusCode(HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			errors.add(Error.DUPLICATE_RECORD);
			failed(response, errors);
		} catch (Exception e) {
			errors.add(Error.CANNOT_PERSIST);
			failed(response, errors);
		}

	}

}