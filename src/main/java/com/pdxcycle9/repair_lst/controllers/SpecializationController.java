package com.pdxcycle9.repair_lst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.services.RetrieveAllSpecializationsService;
import com.pdxcycle9.repair_lst.util.Response;
@Controller
public class SpecializationController {
	@Autowired
	RetrieveAllSpecializationsService retrieveAllSpecializationsService;

	
	@RequestMapping(value = "/specialization", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> retrieveSpecializations() { 
		System.out.println("Echo: Inside specialization controller -- GET");
		Response response = retrieveAllSpecializationsService.retrieve();
		return new ResponseEntity<Object>(response.getResponseObject(), response.getStatusCode());

	}
}
