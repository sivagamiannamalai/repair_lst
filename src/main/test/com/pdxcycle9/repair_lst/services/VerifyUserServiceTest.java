package com.pdxcycle9.repair_lst.services;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

import com.pdxcycle9.repair_lst.DAO.UserDAO;
import com.pdxcycle9.repair_lst.entities.User;

public class VerifyUserServiceTest {
	
	@Autowired
	UserDAO userDAO;
	
	User user;
	String userName;
	String password;

	@Before
	public void setUp() throws Exception {
		user = new User();
		userName = "user";
		password = "password";
		
		when(userDAO.findUser(userName, password)).thenReturn(user);
	}

	@Test
	public void getIdForValidUser() {
		
	}

}
