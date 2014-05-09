package com.pdxcycle9.repair_lst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.services.AddPartsToRepairItemService;
import com.pdxcycle9.repair_lst.util.Response;

@Controller
public class PartController {
	
	@Autowired 
	private AddPartsToRepairItemService addParts;
	
	
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
