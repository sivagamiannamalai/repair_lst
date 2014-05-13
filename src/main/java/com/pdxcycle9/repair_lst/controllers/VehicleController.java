package com.pdxcycle9.repair_lst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.entities.Vehicle;
import com.pdxcycle9.repair_lst.services.CreateVehicleService;
import com.pdxcycle9.repair_lst.services.RetrieveVehicleByUserIdService;
import com.pdxcycle9.repair_lst.util.Response;

@Controller
public class VehicleController {

	@Autowired
	private CreateVehicleService createVehicleService;
	
	@Autowired
	private RetrieveVehicleByUserIdService retrieveVehicleByUserIdService;
	
	@RequestMapping(value = "/vehicle", params = { "year", "make", "model",
	"vin", "mileage" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> createVehicle(
			@RequestParam(value = "year") String year,
			@RequestParam(value = "make") String make,
			@RequestParam(value = "model") String model,
			@RequestParam(value = "vin") String vin,
			@RequestParam(value = "mileage") int mileage)
			{

		Vehicle vehicle = new Vehicle();

		vehicle.setYear(year);
		vehicle.setMake(make);
		vehicle.setModel(model);
		vehicle.setVin(vin);
		vehicle.setMileage(mileage);

		Response response = getCreateVehicleService().createVehicle(vehicle);
		
		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());

	}
	
	/*
	 * Controller for retrieving a vehicle by user ID
	 */
	@RequestMapping(value = "/vehicle", params = {"userId" }, 
			method = RequestMethod.GET, produces = "application/JSON")
	@ResponseBody
	public ResponseEntity<Object> retrieveVehiclesByUserId(
			@RequestParam(value = "userId") int userId) {
		
		Response response = retrieveVehicleByUserIdService.retrieveByUserId(userId);
		
		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());
	}

	public CreateVehicleService getCreateVehicleService() {
		return createVehicleService;
	}

	public void setCreateVehicleService(
			CreateVehicleService createVehicleService) {
		this.createVehicleService = createVehicleService;
	}
}
