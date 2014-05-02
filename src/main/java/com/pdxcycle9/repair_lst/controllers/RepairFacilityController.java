package com.pdxcycle9.repair_lst.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.services.CreateRepairFacilityService;
import com.pdxcycle9.repair_lst.services.SearchRepairFacilityService;
import com.pdxcycle9.repair_lst.services.UpdateRepairFacilityService;
import com.pdxcycle9.repair_lst.util.Response;

@Controller
public class RepairFacilityController {
	@Autowired
	CreateRepairFacilityService createRepairFacilityService;
	@Autowired
	SearchRepairFacilityService searchRepairFacilityService;
	@Autowired
	UpdateRepairFacilityService updateRepairFacilityService;

	/*
	 * Controller for creating repair facility accepts name, phone, hourlyRate,
	 * specialization and addressId returns ResponseEntity object
	 */
	@RequestMapping(value = "/repairfacility", params = { "name", "phone",
			"hourlyRate", "specialization[]", "addressId" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> createRepairFacility(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "specialization[]") int[] specialization,
			@RequestParam(value = "hourlyRate") BigDecimal hourlyRate,
			@RequestParam(value = "addressId") int addressId) {

		RepairFacility repairFacility = new RepairFacility();
		Address address = new Address(addressId);
		repairFacility.setName(name);
		repairFacility.setPhone(phone);
		repairFacility.setHourlyRate(hourlyRate);
		repairFacility.setAddress(address);

		Response response = createRepairFacilityService.createRepairFacility(
				repairFacility, specialization);

		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());
	}

	@RequestMapping(value = "/repairfacility", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> retrieveRepairFacility() {
		ResponseEntity<Object> returnObject = null;
		try {
			Response response = searchRepairFacilityService.retrieveAll();
			returnObject = new ResponseEntity<Object>(
					response.getResponseObject(), response.getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnObject;
	}
	
	@RequestMapping(value = "/repairfacility", params = { "id", "name", "phone", "specialization[]", "hourlyRate", "addressId" }, method = RequestMethod.PUT, produces = "application/json")

	@ResponseBody
	public ResponseEntity<Object> updateRepairFacility(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "specialization[]") int[] specialization,
			@RequestParam(value = "hourlyRate") BigDecimal hourlyRate,
			@RequestParam(value = "addressId") int addressId) {

		RepairFacility repairFacility = new RepairFacility();
		Address address = new Address(addressId);

		repairFacility.setName(name);
		repairFacility.setPhone(phone);
		repairFacility.setHourlyRate(hourlyRate);
		repairFacility.setAddress(address);

		Response response = updateRepairFacilityService.updateRepairFacility(
				repairFacility, specialization);

		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());
	}
}
