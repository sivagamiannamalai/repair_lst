package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.pdxcycle9.repair_lst.DAO.RepairFacilityDAO;
import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.entities.Specialization;
import com.pdxcycle9.repair_lst.subservices.IsNotNull;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class UpdateRepairFacilityServiceTest {
	
	static int[] specialization;
	private static final int[] Collection = specialization;
	RepairFacility repairFacility;
	Response response;
	Address address;
	RepairFacility original;
	RepairFacility updated;
	
	
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
		specialization = new int[3];
		specialization[0] = 1;
		specialization[1] = 2;
		specialization[2] = 3;
		address = 1;
		
		String name = "Autozone";
		String phone = "9876543210";
		BigDecimal hourlyRate = new BigDecimal("20.00");
		//specialization = new int[](specialization);
		
		repairFacility.setName(name);
		repairFacility.setPhone(phone);
		repairFacility.setHourlyRate(hourlyRate);
		//repairFacility.setSpecializations(specialization);
		repairFacility.setHourlyRate(hourlyRate);
		repairFacility.setAddress(address);
		//repairFacility.setSpecializations(Collection<specialization>);
		
		when(repairFacilityDAO.updateRepairFacility(repairFacility)).thenReturn(repairFacility);
		when(updateRepairFacilityService.updateRepairFacility(original, updated).thenReuturn(repairFacility));
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
