package com.pdxcycle9.repair_lst.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import com.pdxcycle9.repair_lst.DAO.AddressDAO;


@RunWith(MockitoJUnitRunner.class)
public class DeleteAddressServiceTest {
	
	private int addressId;
	
	@Mock
	private AddressDAO addressDAO;
	@InjectMocks
	private DeleteAddressService deleteAddressService = new DeleteAddressService();

	@Before
	public void setUp() throws Exception {		
		addressId = 2;		
		doNothing().when(addressDAO).deleteAddress(addressId);
	}

	@Test
	public void testHappyPath() throws Exception {
		addressDAO.deleteAddress(addressId);		
	}
	
	@Test
	public void getErrorForDeleteAddress() {
		doThrow(new RuntimeException()).when(addressDAO).deleteAddress(addressId);		
	}

}
