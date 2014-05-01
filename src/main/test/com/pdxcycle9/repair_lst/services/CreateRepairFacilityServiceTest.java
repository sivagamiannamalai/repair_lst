package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
	}
		
	public void testHappyPath() throws Exception {
 		response = createRepairFacilityService.createRepairFacility(repairFacility, specialization);
 		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(RepairFacility.class, response.getResponseObject().getClass());
		
	}

}
