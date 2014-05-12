package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.UserDAO;
import com.pdxcycle9.repair_lst.entities.User;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Response;
import com.pdxcycle9.repair_lst.util.Error;


@Service
public class VerifyUserService {
	
	@Autowired
	private IsValidLength isValidLength;
	
	@Autowired
	private UserDAO userDAO;

	
	 /**
	  * Method to verify the userName and password are valid
	  * @param userName
	  * @param password
	  * @returns the userId for that user
	  */
	 public Response verifyUser(String userName, String password) {
		 
		 Response response = new Response();
		 List<String> errors = new ArrayList<String>();
		 
		 if(isValidLength.isValidUser(userName, errors) &&
		    isValidLength.isValidUser(password, errors)) {			 
			 
			 findUser(userName, password, response, errors);
		 } else {
			 errors.add(Error.INVALID_INPUT);
			 failed(response, errors);
		 }
		 return response;
	 }
	 
	 
	 public void failed(Response response, List<String> errors) {
		 
		 response.setResponseObject(errors);
		 response.setStatusCode(HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 /**
	  * Method that accesses the DAO to retrieve the userId
	  * @param userName
	  * @param password
	  * @param response
	  * @param errors
	  */
	 @Transactional
	 public void findUser(String userName, String password, Response response, 
			              List<String> errors) {
		 
		 try {
			  User user = userDAO.findUser(userName, password);			 
			  response.setResponseObject(user);
			  response.setStatusCode(HttpStatus.OK);			
		 } catch (NoResultException e){
			  errors.add(Error.INVALID_USER);
	    	  failed(response, errors);
		 } catch (Exception e) {
			  if(e.getCause().getClass() == ConstraintViolationException.class) {
		    	  errors.add(Error.INVALID_USER);
		    	  failed(response, errors);		    	  
		     } 
		 }
	 }
}
