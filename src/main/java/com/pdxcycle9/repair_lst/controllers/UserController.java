package com.pdxcycle9.repair_lst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.services.VerifyUserService;
import com.pdxcycle9.repair_lst.util.Response;

@Controller
public class UserController {
	
	@Autowired
	private VerifyUserService verifyUserService;
	
	
	/**
	 * Method that accepts the userName and password
	 * @param userName
	 * @param password
	 * @return the userId
	 */
	@RequestMapping (value = "/user", params = {"userName", "password"},
			       method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> getUserId(
			@RequestParam(value = "userName") String userName, 
			@RequestParam(value = "password") String password) {		
		
		Response response = verifyUserService.verifyUser(userName, password);
		return new ResponseEntity<Object>(response.getResponseObject(),
				                          response.getStatusCode());
	}
}
