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
import com.pdxcycle9.repair_lst.DAO.RepairTypeDAO;
import com.pdxcycle9.repair_lst.entities.RepairType;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveAllRepairTypesServiceTest {

	RepairType repairType;
	List<RepairType> allRepairTypes;
	Response response;
	List<String> errors;

	@Mock
	private ValidateResults validateResults;
	@Mock
	private RepairTypeDAO repairTypeDAO;
	@InjectMocks
	private RetrieveAllRepairTypesService retrieveAllRepairTypesService = new RetrieveAllRepairTypesService();

	@Before
	public void setUp() throws Exception {
		repairType = new RepairType();
		allRepairTypes = new ArrayList<RepairType>();
		response = new Response();
		errors = new ArrayList<String>();
		retrieveAllRepairTypesService.setValidateResults(validateResults);
		when(repairTypeDAO.retrieveAllRepairTypes()).thenReturn(
				allRepairTypes);

	}

	@Test
	public void testRetrieveAllRepairTypes() throws Exception {
		allRepairTypes.add(repairType);
		response = retrieveAllRepairTypesService.retrieve();
		List<RepairType> currentResults = (ArrayList<RepairType>) response.getResponseObject();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ArrayList.class, response.getResponseObject().getClass());
	}

	@Test
	public void testFailedRetrieveAllRepairTypes() throws Exception {
		when(repairTypeDAO.retrieveAllRepairTypes()).thenThrow(
				new RuntimeException());
		response = retrieveAllRepairTypesService.retrieve();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
