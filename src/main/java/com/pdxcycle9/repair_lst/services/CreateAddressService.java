package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.AddressDAO;
import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.subservices.IsNotNull;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class CreateAddressService {
	@Autowired
	private	AddressDAO addressDAO;
	
	@Autowired
	IsValidLength isValidLength;
	
	@Autowired
	IsNotNull isNotNull;

	@Transactional
	public Response createAddress(Address address) {
		
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
    	boolean fieldsNotNull = false;
		boolean fieldsCorrectLength = false;		
				
		
		if(isNotNull.isFieldNotNull(address.getCity(), errors) && 
		   isNotNull.isFieldNotNull(address.getState(), errors) && 
		   isNotNull.isFieldNotNull(address.getStreet(), errors) && 
		   isNotNull.isFieldNotNull(address.getZip(), errors))   {
			
			fieldsNotNull = true;			
		}
		
		if(isValidLength.between1and255(address.getCity(), errors) &&
		   isValidLength.between1and255(address.getStreet(), errors) &&
		   isValidLength.zipIsFive(address.getZip(), errors))  {
			  fieldsCorrectLength = true;			  
		}		
				
				
		if(fieldsNotNull && fieldsCorrectLength) {			
			 persistAddress(address, response, errors);
		}  else {
			failed(response, errors);
		}
		
		return response;
	}
	
	public void failed(Response response, List<String> errors) {
		response.setResponseObject(errors);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
	}
	
	
	@Transactional
	public void persistAddress(Address address, Response response,
			                             List<String> errors)  {
		
		Address result = null;
		try {
		   result = addressDAO.persistAddress(address);
		   response.setResponseObject(result);
		   response.setStatusCode(HttpStatus.OK);
		}  catch (Exception e) {
			if (e.getCause().getClass() == ConstraintViolationException.class) {
                errors.add(Error.DUPLICATE_RECORD);			
			    failed(response, errors);
			}    
		}
		 
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

}
