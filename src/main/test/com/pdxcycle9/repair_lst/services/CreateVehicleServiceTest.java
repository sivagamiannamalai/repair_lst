package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.hibernate.exception.ConstraintViolationException;

import com.pdxcycle9.repair_lst.subservices.IsValidMileage;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.entities.Vehicle;
import com.pdxcycle9.repair_lst.util.Response;
import com.pdxcycle9.repair_lst.DAO.VehicleDAO;

@RunWith(MockitoJUnitRunner.class)
public class CreateVehicleServiceTest {

	private String year;
	private String make;
	private String model;
	private String vin;
	private int mileage;
	private Response response;
	private Vehicle vehicle;
	List<String> errors = new ArrayList<String>();

	@Mock
	private VehicleDAO vehicleDAO;

	@Mock
	private IsValidMileage isValidMileage;

	@InjectMocks
	private CreateVehicleService createVehicleService = new CreateVehicleService();

	@Before
	public void setUp() throws Exception {
		response = new Response();
		errors = new ArrayList<String>();
		vehicle = new Vehicle();

		year = "1998";
		make = "Test";
		model = "car";
		vin = "WBANE53556B897354";
		mileage = 5;

		vehicle.setYear(year);
		vehicle.setMake(make);
		vehicle.setModel(model);
		vehicle.setVin(vin);
		vehicle.setMileage(mileage);

		when(isValidMileage.between0and999999(vehicle.getMileage()))
		.thenReturn(true);
		
	}

	@Test
	public void vehicleIsValid() throws Exception {

		when(vehicleDAO.persistVehicle(vehicle)).thenReturn(vehicle);
		response = createVehicleService.createVehicle(vehicle);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(Vehicle.class, response.getResponseObject().getClass());
	}



	@Test
	public void hitTheFirstCatchWithDuplicateRecord() {

		ConstraintViolationException e = new ConstraintViolationException(
				"String", null, "String");

		when(vehicleDAO.persistVehicle(vehicle)).thenThrow(e);
		response = createVehicleService.createVehicle(vehicle);
		errors =(ArrayList<String>) response.getResponseObject();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.DUPLICATE_RECORD, errors.get(0));
		
	}

	@Test
	public void hitTheSecondCatchWithCannotPersist() {

		when(vehicleDAO.persistVehicle(vehicle)).thenThrow(
				new RuntimeException());
		response = createVehicleService.createVehicle(vehicle);
		errors =(ArrayList<String>) response.getResponseObject();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.CANNOT_PERSIST, errors.get(0));
	}

	@Test
	public void hitTheElseInTheMileageValidation() {

		when(isValidMileage.between0and999999(vehicle.getMileage()))
		.thenReturn(false);
		
		response = createVehicleService.createVehicle(vehicle);
		errors =(ArrayList<String>) response.getResponseObject();
		assertEquals(Error.MILEAGE_IS_OUT_OF_RANGE, errors.get(0));
	}
	
}
