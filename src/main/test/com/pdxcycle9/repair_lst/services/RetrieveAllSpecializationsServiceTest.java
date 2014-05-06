package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.List;

import com.pdxcycle9.repair_lst.DAO.SpecializationDAO;
import com.pdxcycle9.repair_lst.entities.Specialization;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveAllSpecializationsServiceTest {

	Specialization specialization;
	List<Specialization> allSpecializations;
	Response response;

	@Mock
	private SpecializationDAO specializationDAO;
	@InjectMocks
	private RetrieveAllSpecializationsService retrieveAllSpecializationsService = new RetrieveAllSpecializationsService();

	@Before
	public void setUp() throws Exception {

		allSpecializations = new ArrayList<Specialization>();
		response = new Response();
		when(specializationDAO.retrieveAllSpecializations()).thenReturn(
				allSpecializations);

	}

	@Test
	public void testRetrieveAllSpecializations() throws Exception {
		response = retrieveAllSpecializationsService.retrieve();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ArrayList.class, response.getResponseObject().getClass());
	}

	@Test
	public void testFailedRetrieveAllSpecializations() throws Exception {
		when(specializationDAO.retrieveAllSpecializations()).thenThrow(
				new RuntimeException());
		response = retrieveAllSpecializationsService.retrieve();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
