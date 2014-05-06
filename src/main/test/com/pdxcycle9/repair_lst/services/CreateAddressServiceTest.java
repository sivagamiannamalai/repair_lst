package com.pdxcycle9.repair_lst.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.util.Response;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.DAO.AddressDAO;
import com.pdxcycle9.repair_lst.subservices.IsNotNull;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;

@RunWith(MockitoJUnitRunner.class)
public class CreateAddressServiceTest {
	
	private Address address;
	private String zip;
	private String state;
	private String street;
	private String city;
	private Response response;
	
	@Mock
	private AddressDAO addressDAO;

	@Mock
	private IsNotNull isNotNull;

	@Mock
	private IsValidLength isValidLength;
	@InjectMocks
	private CreateAddressService createAddressService = new CreateAddressService();

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		street = "Street 1";
		city = "Beaverton";
		state = "OR";
	    zip = "97229";
	    address = new Address();
		address.setCity(city);
		address.setStreet(street);
		address.setState(state);
		address.setZip(zip);
		
		
		when(addressDAO.persistAddress(address)).thenReturn(address);
		when(isValidLength.between1and255(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		when(isNotNull.isFieldNotNull(Matchers.anyString(), Matchers.anyList())).thenReturn(true);
		
	}
	
	
	@Test
	public void happyPathTest() throws Exception {
		response = createAddressService.createAddress(address);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(Address.class, response.getResponseObject().getClass());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void passEmptyZipGetNotOk() throws Exception  {
		zip = "";
		address.setZip(zip);
		when(isValidLength.between1and255(Matchers.anyString(), Matchers.anyList())).thenReturn(false);
		response = createAddressService.createAddress(address);		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
	
    @SuppressWarnings("unchecked")
    @Test
    public void getErrorForDuplicateAddress() {
    	when(createAddressService.createAddress(address)).thenThrow(new ConstraintViolationException("String", null, "String"));
    	response = createAddressService.createAddress(address);
    	assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    	assertEquals(Error.class, response.getResponseObject().getClass());
    }
}
