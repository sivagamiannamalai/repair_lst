package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.List;

import com.pdxcycle9.repair_lst.subservices.ValidateResults;
import com.pdxcycle9.repair_lst.DAO.SpecializationDAO;
import com.pdxcycle9.repair_lst.entities.Specialization;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveAllSpecializationsServiceTest {

	Specialization specialization;
	List<Specialization> allSpecializations;
	Response response;
	List<String> errors;

	@Mock
	private ValidateResults validateResults;
	@Mock
	private SpecializationDAO specializationDAO;
	@InjectMocks
	private RetrieveAllSpecializationsService retrieveAllSpecializationsService = new RetrieveAllSpecializationsService();

	@Before
	public void setUp() throws Exception {
		specialization = new Specialization();
		allSpecializations = new ArrayList<Specialization>();
		response = new Response();
		errors = new ArrayList<String>();
		retrieveAllSpecializationsService.setValidateResults(validateResults);
		when(specializationDAO.retrieveAllSpecializations()).thenReturn(
				allSpecializations);

	}

	@Test
	public void testRetrieveAllSpecializations() throws Exception {
		allSpecializations.add(specialization);
		response = retrieveAllSpecializationsService.retrieve();
		List<Specialization> currentResults = (ArrayList<Specialization>) response				.getResponseObject();
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
