package com.pdxcycle9.repair_lst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.services.CreateAddressService;
import com.pdxcycle9.repair_lst.services.FindAllAddressService;
import com.pdxcycle9.repair_lst.util.Response;

@Controller
public class AddressController {
	//
	@Autowired
	private CreateAddressService createAddressService;
	@Autowired
	private FindAllAddressService findAllAddressService;
	
	
	@RequestMapping(value = "/address", params = { "street", "city", "state",
			"zip" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> createAddress(
			@RequestParam(value = "street") String street,
			@RequestParam(value = "city") String city,
			@RequestParam(value = "state") String state,
			@RequestParam(value = "zip") String zip) {

		Address address = new Address();

		address.setCity(city);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);

		System.out.println("Inside Controller " + city + "," + state);

		Response response = getCreateAddressService().createAddress(address);
		
		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());

	}

	@RequestMapping(value = "/address", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> retrieveAllAddress() {

		Response response = findAllAddressService.retrieve();

		return new ResponseEntity<Object>(response.getResponseObject(),
				response.getStatusCode());
	}

	public CreateAddressService getCreateAddressService() {
		return createAddressService;
	}

	public void setCreateAddressService(
			CreateAddressService createAddressService) {
		this.createAddressService = createAddressService;
	}

}
