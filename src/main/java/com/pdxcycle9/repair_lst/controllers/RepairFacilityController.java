package com.pdxcycle9.repair_lst.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.util.Response;
import com.pdxcycle9.repair_lst.services.CreateRepairFacilityService;

@Controller
public class RepairFacilityController {
	@Autowired
	CreateRepairFacilityService createRepairFacilityService;
		
	
	/* 
	 * Controller for creating repair facility
	 * accepts name, phone, hourlyRate, specialization and addressId 
	 * returns ResponseEntity object
	 */
	@RequestMapping(value = "/repairfacility", params = { "name", "phone",
			"hourlyRate", "specialization", "addressId" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> createRepairFacility(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "hourlyRate") double hourlyRate,			
			@RequestParam(value = "specialization") List<Integer> specialization,
			@RequestParam(value = "addressId") int addressId)  {

		RepairFacility repairFacility = new RepairFacility();
		repairFacility.setName(name);
		repairFacility.setPhone(phone);
		repairFacility.setHourlyRate(hourlyRate);
		//repairFacility.setRating(rating);		
		//repairFacility.setSpecialization(specialization);
		repairFacility.setAddressId(addressId);
		
		System.out.println("Inside Repairfacility Controller " + name + ", " + phone );
		
		Response response = createRepairFacilityService.createRepairFacility(
				repairFacility);

		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());
	}

	
}
