package com.pdxcycle9.repair_lst.controllers;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.entities.RepairItem;
import com.pdxcycle9.repair_lst.services.CreateRepairItemService;
import com.pdxcycle9.repair_lst.util.Response;

@Controller
public class RepairItemController {
	
	@Autowired
	CreateRepairItemService createRepairItemService;
	
	@RequestMapping(value = "/repairitem", params = { "description", "date",
			"hourlyRate", "hoursWorked", "mileage", "rating", "userId", "repairTypeId", 
			"repairFacilityId", "vehicleId", "parts[]" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> createRepairFacility(
			@RequestParam(value = "description") String description,
			@RequestParam(value = "date") Date date,
			@RequestParam(value = "hourlyRate") BigDecimal hourlyRate,
			@RequestParam(value = "laborHours") int laborHours,
			@RequestParam(value = "mileage") int mileage,
			@RequestParam(value = "rating") int rating,
			@RequestParam(value = "userId") int userId,
			@RequestParam(value = "repairTypeId") int repairTypeId,
			@RequestParam(value = "repairFacilityId") int repairFacilityId,
			@RequestParam(value = "vehicleId") int vehicleId,
			@RequestParam(value = "parts[]") int[] parts){

		RepairItem repairItem = new RepairItem();

		repairItem.setDescription(description);
		repairItem.setDate(date);
		repairItem.setHourlyRate(hourlyRate);
		repairItem.setLaborHours(laborHours);
		repairItem.setMileage(mileage);
		repairItem.setRating(rating);
		repairItem.setUserId(userId);
		repairItem.setRepairTypeId(repairTypeId);
		repairItem.setRepairFacilityId(repairFacilityId);
		repairItem.setVehicleId(vehicleId);

		Response response = createRepairItemService.createRepairItem(repairItem, parts);

		return new ResponseEntity<Object>(response.getResponseObject(), response.getStatusCode());
	}

}
