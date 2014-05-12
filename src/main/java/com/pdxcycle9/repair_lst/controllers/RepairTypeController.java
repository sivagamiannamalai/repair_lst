package com.pdxcycle9.repair_lst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.services.RetrieveAllRepairTypesService;
import com.pdxcycle9.repair_lst.util.Response;

@Controller
public class RepairTypeController {

	@Autowired
	RetrieveAllRepairTypesService retrieveAllRepairTypesService;

	@RequestMapping(value = "/repairtype", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> retrieveRepairTypes() {

		Response response = retrieveAllRepairTypesService.retrieve();

		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());

	}

}
