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

import com.pdxcycle9.repair_lst.subservices.ValidateResults;
import com.pdxcycle9.repair_lst.DAO.PartDAO;
import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveAllPartsServiceTest {

	Part part;
	List<Part> allParts;
	Response response;
	List<String> errors;

	@Mock
	private ValidateResults validateResults;
	@Mock
	private PartDAO partDAO;
	@InjectMocks
	private RetrieveAllPartsService retrieveAllPartsService = new RetrieveAllPartsService();

	@Before
	public void setUp() throws Exception {
		part = new Part();
		allParts = new ArrayList<Part>();
		response = new Response();
		errors = new ArrayList<String>();
		retrieveAllPartsService.setValidateResults(validateResults);
		when(partDAO.retrieveAllParts()).thenReturn(
				allParts);

	}

	@Test
	public void testRetrieveAllParts() throws Exception {
		allParts.add(part);
		response = retrieveAllPartsService.retrieve();
		List<Part> currentResults = (ArrayList<Part>) response				.getResponseObject();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ArrayList.class, response.getResponseObject().getClass());
	}

	@Test
	public void testFailedRetrieveAllParts() throws Exception {
		when(partDAO.retrieveAllParts()).thenThrow(
				new RuntimeException());
		response = retrieveAllPartsService.retrieve();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
