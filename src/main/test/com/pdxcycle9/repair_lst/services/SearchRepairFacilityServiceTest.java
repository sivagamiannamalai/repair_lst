package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.pdxcycle9.repair_lst.DAO.RepairFacilityDAO;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class SearchRepairFacilityServiceTest {

	RepairFacility singleRepairFacility;
	Response response;
	List<RepairFacility> allRepairFacilities;
	
	@Mock
	private RepairFacilityDAO repairFacilityDAO;
	
	@InjectMocks
	private SearchRepairFacilityService searchRepairFacilityService = new SearchRepairFacilityService();

	@Before
	public void setUp() throws Exception {		
		
		singleRepairFacility = new RepairFacility();
		response = new Response();
		allRepairFacilities = new ArrayList <RepairFacility>() ;
		int repairFacilityId = 1;
		
		when(repairFacilityDAO.retrieveAllRepairFacility()).thenReturn(allRepairFacilities);
		when(repairFacilityDAO.retrieveRepairFacilityByID(repairFacilityId)).thenReturn(singleRepairFacility);
				
	}

	@Test		
	public void gettingAllRepairFacilitiesWorkProperly() throws Exception {

 		response = searchRepairFacilityService.retrieveAll();
 		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ArrayList.class, response.getResponseObject().getClass());
		
	}
	
	@Test		
	public void gettingOneSingleRepairFacilityByID() throws Exception {
 		
		int repairFacilityId = 1;
		
		response = searchRepairFacilityService.retrieveByID(repairFacilityId);
 		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(RepairFacility.class, response.getResponseObject().getClass());
		
	}
	
	 @Test
	    public void gettingAllFailed() {               
	    
		 when(repairFacilityDAO.retrieveAllRepairFacility()).thenThrow(new RuntimeException());
		 response = searchRepairFacilityService.retrieveAll();
		 assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		 
	 }
	 
	 @Test
	    public void gettingOneFailed() {               
	    
		 int repairFacilityId = 1;
		 
		 when(repairFacilityDAO.retrieveRepairFacilityByID(repairFacilityId)).thenThrow(new RuntimeException());
		 response = searchRepairFacilityService.retrieveByID(repairFacilityId);
		 assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		 
	 }
	 
}
