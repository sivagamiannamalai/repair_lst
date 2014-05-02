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
public class UpdateRepairFacilityServiceTest {
	
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
	private UpdateRepairFacilityService updateRepairFacilityService = new UpdateRepairFacilityService();

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		
		repairFacility = new RepairFacility();
		response = new Response();
		
		String name = "Autozone";
		String phone = "9876543210";
		BigDecimal hourlyRate = new BigDecimal("20.00");
		specialization = new int[3];
		specialization[0] =  1;
		specialization[1] =  3;
		specialization[2] =  4;
		
		repairFacility.setName(name);
		repairFacility.setPhone(phone);
		repairFacility.setHourlyRate(hourlyRate);
		
		when(repairFacilityDAO.updateRepairFacility(repairFacility)).thenReturn(repairFacility);
		when(isValidLength.between1and255(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		when(isNotNull.isHourlyRateValid((BigDecimal)Matchers.any(), Matchers.anyList())).thenReturn(true);
		when(isValidLength.isPhoneValidLength(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		
	}
	
	@Test		
	public void repairFacilityUpdatesCorrectly() throws Exception {
 		response = updateRepairFacilityService.updateRepairFacility(repairFacility, specialization);
 		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(RepairFacility.class, response.getResponseObject().getClass());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void giveNullforNameAndPhone() throws Exception {
		String name = "";
		String phone = "";
		repairFacility.setName(name);
		repairFacility.setPhone(phone);	
				
		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		when(isValidLength.isPhoneValidLength(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		
		response = updateRepairFacilityService.updateRepairFacility(repairFacility, specialization);
 		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
