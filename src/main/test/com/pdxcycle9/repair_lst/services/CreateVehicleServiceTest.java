package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
		
		when(vehicleDAO.persistVehicle(vehicle)).thenReturn(vehicle);
	}

	@Test
	public void vehicleIsValid() throws Exception {
		response = createVehicleService.createVehicle(vehicle);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(Vehicle.class, response.getResponseObject().getClass());
	}
}
