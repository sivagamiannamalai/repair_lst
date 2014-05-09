package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	
	private int[] specializationArray;
    private List<Specialization> specializationList;
    private Response response;
    private Address address;
    private RepairFacility original;
    private RepairFacility updated;
    private String name;
    private String phone;
    private BigDecimal hourlyRate;
    private Specialization specializationZero;
    private Specialization specializationOne;
    private Specialization specializationTwo;
	
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
		
		original = new RepairFacility();
        updated = new RepairFacility();
        specializationList = new ArrayList<Specialization>();

        response = new Response();
        specializationArray = new int[3];
        specializationArray[0] = 1;
        specializationArray[1] = 2;
        specializationArray[2] = 3;
        address = new Address(1);

        specializationZero = new Specialization(1);
        specializationOne = new Specialization(2);
        specializationTwo = new Specialization(3);

        specializationList.add(specializationZero);
        specializationList.add(specializationOne);
        specializationList.add(specializationTwo);

        name = "Autozone";
        phone = "9876543210";
        hourlyRate = new BigDecimal("20.00");

        updated.setName(name);
        updated.setPhone(phone);
        updated.setHourlyRate(hourlyRate);
        updated.setAddress(address);
        updated.setSpecializations(specializationList);

        original.setName("New Name");
        original.setPhone("0123456789");
        original.setHourlyRate(new BigDecimal("100.00"));
        original.setAddress(new Address(2));
        original.setSpecializations(new ArrayList<Specialization>());

		when(repairFacilityDAO.updateRepairFacility(original)).thenReturn(updated);
		when(repairFacilityDAO.retrieveRepairFacilityByID(Matchers.anyInt())).thenReturn(original).thenReturn(updated);
		when(isValidLength.between1and255(Matchers.anyString(),Matchers.anyList())).thenReturn(true);
		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		when(isNotNull.isBigDecimalValid((BigDecimal) Matchers.any(),Matchers.anyList())).thenReturn(true);
		when(isValidLength.isPhoneValidLength(Matchers.anyString(),Matchers.anyList())).thenReturn(true);

	}
	
	@Test
	public void repairFacilityUpdatesCorrectly() throws Exception {
		response = updateRepairFacilityService.updateRepairFacility(updated,
				specializationArray);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(RepairFacility.class, response.getResponseObject().getClass());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void giveNullforNameAndPhone() throws Exception {

		updated.setName("");
		updated.setPhone("");

		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		when(isValidLength.isPhoneValidLength(Matchers.anyString(),Matchers.anyList())).thenReturn(false);

		response = updateRepairFacilityService.updateRepairFacility(updated, specializationArray);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
