package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.AddressDAO;
import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.util.Response;
import com.pdxcycle9.repair_lst.util.Error;

@Service
public class DeleteAddressService {
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Transactional
	public Response delete(int addressId) {
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		try {
			addressDAO.deleteAddress(addressId);
			response.setStatusCode(HttpStatus.OK);			
		} catch(Exception e) {			
			response.setStatusCode(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

}
