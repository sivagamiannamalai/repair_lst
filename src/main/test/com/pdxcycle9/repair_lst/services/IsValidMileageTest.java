package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.pdxcycle9.repair_lst.DAO.VehicleDAO;
import com.pdxcycle9.repair_lst.entities.Vehicle;
import com.pdxcycle9.repair_lst.services.CreateVehicleService;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.subservices.IsValidMileage;

@RunWith(MockitoJUnitRunner.class)
public class IsValidMileageTest {
	private Vehicle vehicle;
	private List<String> errors;

	@Mock
	private VehicleDAO vehicleDAO = new VehicleDAO();
	@Mock
	IsValidMileage isValidMileage;
	@InjectMocks
	private CreateVehicleService createVehicleService = new CreateVehicleService();

	@Before
	public void setUp() throws Exception {
		isValidMileage = new IsValidMileage();
		vehicle = new Vehicle();
		errors = new ArrayList<String>();
		}

	@Test
	public void testOne() throws Exception {
		vehicle.setMileage(1);
		assertEquals(true, isValidMileage.between0and999999(vehicle.getMileage()));
		

	}

	@Test
	public void testNegativeOne() throws Exception {
		vehicle.setMileage(-1);
		assertEquals(false,
				isValidMileage.between0and999999(vehicle.getMileage()));
	}

	@Test
	public void testOneMillion() throws Exception {
		vehicle.setMileage(1000000);
		assertEquals(false,
				isValidMileage.between0and999999(vehicle.getMileage()));
	}

}
