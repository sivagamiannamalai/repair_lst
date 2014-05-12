package com.pdxcycle9.repair_lst.controllers;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.entities.RepairItem;
import com.pdxcycle9.repair_lst.services.AddPartsToRepairItemService;
import com.pdxcycle9.repair_lst.services.CreateRepairItemService;
import com.pdxcycle9.repair_lst.util.Response;

@Controller
public class RepairItemController {
	
	@Autowired
	CreateRepairItemService createRepairItemService;
	
	@Autowired 
	AddPartsToRepairItemService addParts;
	
	/**
	 * repair item controller to persist/add new repair items with the following params
	 * @param description
	 * @param date
	 * @param hourlyRate
	 * @param laborHours
	 * @param mileage
	 * @param rating
	 * @param userId
	 * @param repairTypeId
	 * @param repairFacilityId
	 * @param vehicleId
	 * @return
	 */
	@RequestMapping(value = "/repairitem", params = { "description", "date",
			"hourlyRate", "laborHours", "mileage", "rating", "userId", "repairTypeId", 
			"repairFacilityId", "vehicleId" }, method = RequestMethod.POST, produces = "application/json")
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
			@RequestParam(value = "vehicleId") int vehicleId){

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

		Response response = createRepairItemService.createRepairItem(repairItem);

		return new ResponseEntity<Object>(response.getResponseObject(), response.getStatusCode());
	}
	
	@RequestMapping(value = "/addParts", params = {"partId[]", "repairItemId" }, 
			method = RequestMethod.PUT, produces = "application/JSON")
	@ResponseBody
	public ResponseEntity<Object> addParts(
			@RequestParam(value = "partId[]") int[] part,
			@RequestParam(value = "repairItemId") int repairItemId){
		
		Response response = addParts.addPartsToRepairItem(repairItemId, part);
		
		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());
	}


}
