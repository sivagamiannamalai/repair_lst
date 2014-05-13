package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.pdxcycle9.repair_lst.DAO.UserDAO;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.entities.User;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

public class VerifyUserServiceTest {
	
	@Mock
	private IsValidLength isValidLength;	
	@Mock
	private UserDAO userDAO;	
	@InjectMocks
	private VerifyUserService = new VerifyUserService();	
	
	User user;
	Response response;
	String userName;
	String password;
	List<String> errors;

	@Before
	public void setUp() throws Exception {
		user = new User();
		response = new Response();
		userName = "user";
		password = "password";
		errors = new ArrayList<String>();
		
		when(userDAO.findUser(userName, password)).thenReturn(user);
		when(isValidLength.isValidUser(Matchers.anyString(), Matchers.anyList()) &&
			 isValidLength.isValidUser(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		
		
	}

	@Test
	public void getOKForValidUser() {
		response = verifyUserService.verifyUser(userName, password);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(User.class, response.getResponseObject().getClass());
	}
	
	@Test
	public void passNothingGetError() {
		when(isValidLength.isValidUser(Matchers.anyString(), Matchers.anyList()) &&
			 isValidLength.isValidUser(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		response = verifyUserService.verifyUser(userName, password);
		errors =(ArrayList<String>) response.getResponseObject();
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.INVALID_USER, errors.get(0));
	}
	
	@Test
	public void getBadRequestForInvalidUser() {
		 when(userDAO.findUser(userName, password)).thenThrow(new NoResultException());
		 response = verifyUserService.verifyUser(userName, password);
		 errors =(ArrayList<String>) response.getResponseObject();
		 
		 assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());		
		 assertEquals(Error.INVALID_USER, errors.get(0));
	}

}
