package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.hibernate.exception.ConstraintViolationException;

import com.pdxcycle9.repair_lst.DAO.RatingDAO;
import com.pdxcycle9.repair_lst.entities.RepairFacility;
import com.pdxcycle9.repair_lst.subservices.IsNotNull;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class RepairFacilityRatingServiceTest {
	
	private String repairFacilityNameToSearch;
	List<String> errors = new ArrayList<String>();
	private Response response;
	private RepairFacility repairFacility; 
	private double rating;
	
	@Mock
	private RatingDAO ratingDAO;
	
	@Mock
	private IsNotNull isNotNull;

	@Mock
	private IsValidLength isValidLength;
	
	@InjectMocks
	private RepairFacilityRatingService repairFacilityRatingService = new RepairFacilityRatingService();

	@Before
	public void setUp() throws Exception {
		
		response = new Response();
		errors = new ArrayList<String>();
		repairFacility = new RepairFacility();
		rating = 3.5;
		repairFacility.setRating(rating);		
	}

	@Test
	public void validSearchReturnsResults() throws Exception {
		repairFacilityNameToSearch = "Valid";
		when(isNotNull.isFieldNotNull(repairFacilityNameToSearch, errors)).thenReturn(true);
		when(isValidLength.between1and255(repairFacilityNameToSearch, errors)).thenReturn(true);
		when(ratingDAO.getRepairFacilityRating(repairFacilityNameToSearch)).thenReturn(repairFacility);		
		response = repairFacilityRatingService.getRatingByName(repairFacilityNameToSearch);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(RepairFacility.class, response.getResponseObject().getClass());
		
	}
	
	@Test
	public void nullSearchThrowsISNULLError() throws Exception {
		repairFacilityNameToSearch = "";
		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		when(isValidLength.between1and255(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		response = repairFacilityRatingService.getRatingByName(repairFacilityNameToSearch);
		errors = (List<String>) response.getResponseObject();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.IS_NULL, errors.get(0));
	}

	@Test
	public void tooLongSearchThrowsISWRONGLENGTHError() throws Exception {
		repairFacilityNameToSearch = "Lorem ipsum dolor sit amet, nonummy ligula volutpat hac integer nonummy. Suspendisse ultricies, congue etiam tellus, erat libero, nulla eleifend, mauris pellentesque. Suspendisse integer praesent vel, integer gravida mauris, fringilla vehicula lacinia non!!!!!!!!";
		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		when(isValidLength.between1and255(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		response = repairFacilityRatingService.getRatingByName(repairFacilityNameToSearch);
		errors = (List<String>) response.getResponseObject();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.IS_WRONG_LENGTH, errors.get(0));
	}
	
	@Test
	public void noResultsfoundHitsTheCatch() throws Exception {
		repairFacilityNameToSearch = "Lorem";
		when(isNotNull.isFieldNotNull(repairFacilityNameToSearch, errors)).thenReturn(true);
		when(isValidLength.between1and255(repairFacilityNameToSearch, errors)).thenReturn(true);
		ConstraintViolationException e = new ConstraintViolationException("String", null, "String");
		when(ratingDAO.getRepairFacilityRating(repairFacilityNameToSearch)).thenThrow(e);
		response = repairFacilityRatingService.getRatingByName(repairFacilityNameToSearch);
		errors = (List<String>) response.getResponseObject();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.NO_RESULTS_FOUND, errors.get(0));
	}
}
