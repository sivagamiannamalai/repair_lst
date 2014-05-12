package com.pdxcycle9.repair_lst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.services.RetrieveAllPartsService;
import com.pdxcycle9.repair_lst.util.Response;
@Controller
public class PartController {
	
	/*@Autowired
	RetrieveAllPartsService retrieveAllPartsService;*/

	
	/*@RequestMapping(value = "/parts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> retrieveParts() { 
		
			Response response = retrieveAllPartsService.retrieve();

			return new ResponseEntity<Object>(response.getResponseObject(),
					response.getStatusCode());
*/
	}

