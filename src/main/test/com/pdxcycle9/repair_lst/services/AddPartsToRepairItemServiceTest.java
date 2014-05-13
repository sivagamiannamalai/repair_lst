package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.pdxcycle9.repair_lst.DAO.PartDAO;
import com.pdxcycle9.repair_lst.DAO.RepairItemDAO;
import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.entities.RepairItem;
import com.pdxcycle9.repair_lst.util.Response;
import com.pdxcycle9.repair_lst.util.Error;

@RunWith(MockitoJUnitRunner.class)
public class AddPartsToRepairItemServiceTest {
	@Mock
	private PartDAO partDAO;

	@Mock
	private RepairItemDAO repairItemDAO;
	@InjectMocks
	private AddPartsToRepairItemService addPartsToRepairItemService = new AddPartsToRepairItemService();

	
	private Response response;
	private List<String> errors;
	private RepairItem repairItem;
	private Part part;
	private List<Part> partList;
	
	private int repairItemId;
	private int[] partId = new int[1];
	private int singlePart;
	
	@Before
	public void setUp() throws Exception {
		
		response = new Response();
		errors = new ArrayList<String>();
		repairItem = new RepairItem();
		part = new Part();
		partList = new ArrayList<Part>();
		
		repairItemId = 1;
		partId[0] = 1;
		singlePart = 1;
		
		when(repairItemDAO.retrieveRepairItemByID(repairItemId)).thenReturn(repairItem);
		
		when(partDAO.retrievePartById(partId[0])).thenReturn(part);
		
		when(repairItemDAO.updateRepairItemAddParts(repairItem)).thenReturn(repairItem);
		
	}

	@Test
	public void testGetValidRepairItem() throws Exception {

		repairItem = addPartsToRepairItemService.getRepairItem(repairItemId, repairItem, response, errors);
		
		assertEquals(RepairItem.class, repairItem.getClass());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetRepairItemFails() throws Exception {

		when(repairItemDAO.retrieveRepairItemByID(repairItemId)).thenThrow(new RuntimeException());
		
		repairItem = addPartsToRepairItemService.getRepairItem(repairItemId, repairItem, response, errors);
		
		errors = (List<String>) response.getResponseObject();
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.CANNOT_PERSIST, errors.get(0));
	}

	@Test
	public void testMakePartsList() throws Exception{
		
		partList = addPartsToRepairItemService.makePartsList(partId, response, errors);
		
		assertEquals(Part.class, partList.get(0).getClass());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMakePartListFail() throws Exception {

		when(partDAO.retrievePartById(singlePart)).thenThrow(new RuntimeException());
		
		partList = addPartsToRepairItemService.makePartsList(partId, response, errors);
		
		errors = (List<String>) response.getResponseObject();
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.CANNOT_PERSIST, errors.get(0));
	}
	
	@Test
	public void testUpdateRepairWithParts() throws Exception {
		
		response = addPartsToRepairItemService.addPartsToRepairItem(repairItemId, partId);
		
		assertEquals(RepairItem.class, response.getResponseObject().getClass());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateRepairWithPartsFail() throws Exception {

		when(repairItemDAO.updateRepairItemAddParts(repairItem)).thenThrow(new RuntimeException());
		
		response = addPartsToRepairItemService.addPartsToRepairItem(repairItemId, partId);
		
		errors = (List<String>) response.getResponseObject();
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.CANNOT_PERSIST, errors.get(0));
	}


}
