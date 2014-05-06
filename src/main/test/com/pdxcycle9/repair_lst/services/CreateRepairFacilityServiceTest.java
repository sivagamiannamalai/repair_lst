package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.pdxcycle9.repair_lst.DAO.RepairFacilityDAO;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.subservices.IsNotNull;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class CreateRepairFacilityServiceTest {
	
	RepairFacility repairFacility;
	Response response;
	int[] specialization;
	
	@Mock
	private IsNotNull isNotNull;

	@Mock
	private IsValidLength isValidLength;

	@Mock
	private RepairFacilityDAO repairFacilityDAO;
	@InjectMocks
	private CreateRepairFacilityService createRepairFacilityService = new CreateRepairFacilityService();

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repairFacility = new RepairFacility();
		response = new Response();
		
		String name = "Facility25";
		String phone = "5127896541";
		BigDecimal hourlyRate = new BigDecimal("45.00");
		specialization = new int[3];
		specialization[0] =  1;
		specialization[1] =  3;
		specialization[2] =  4;
		
		repairFacility.setName(name);
		repairFacility.setPhone(phone);
		repairFacility.setHourlyRate(hourlyRate);
		
		when(repairFacilityDAO.persistRepairFacility(repairFacility)).thenReturn(repairFacility);
		
		when(isValidLength.between1and255(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		when(isNotNull.isHourlyRateValid((BigDecimal)Matchers.any(), Matchers.anyList())).thenReturn(true);
		when(isValidLength.isPhoneValidLength(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
	}
	
	
	
	@Test		
	public void testHappyPath() throws Exception {
 		response = createRepairFacilityService.createRepairFacility(repairFacility, specialization);
 		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(RepairFacility.class, response.getResponseObject().getClass());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void giveNullforNameandPhone() throws Exception {
		String name = "Facility25";
		String phone = "5127896541";
		repairFacility.setName(name);
		repairFacility.setPhone(phone);	
				
		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		when(isValidLength.isPhoneValidLength(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		
		response = createRepairFacilityService.createRepairFacility(repairFacility, specialization);
 		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
	
	@SupressWarnings("unchecked")
	@Test
	public void getErrorForDuplicateRepairFacility() {
		 when(repairFacilityDAO.persistRepairFacility(repairFacility)).thenThrow(new ConstraintViolationException());
		 response = createRepairFacilityService.createRepairFacility(repairFacility, specialization);
		 assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		 assertEquals(Error.class, response.getResponseObject().getClass());
	}

}
