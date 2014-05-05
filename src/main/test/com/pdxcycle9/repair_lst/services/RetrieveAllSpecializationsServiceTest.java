 package com.pdxcycle9.repair_lst.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import com.pdxcycle9.repair_lst.DAO.SpecializationDAO;
import com.pdxcycle9.repair_lst.entities.Specialization;
import com.pdxcycle9.repair_lst.util.Response;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveAllSpecializationsServiceTest {
	
	List<Specialization> allSpecializations;
	Response response;
	
	@Mock
	private SpecializationDAO specializationDAO;
	@InjectMocks
	private RetrieveAllSpecializationsService retrieveAllSpecializationsService;

	@Before
	public void setUp() throws Exception {
		
	allSpecializations = new ArrayList<Specialization>();
	response = new Response();
	when(specializationDAO.retrieveAllSpecializations()).thenReturn(allSpecializations);
		
	}

	@Test
	public void testSetSpecializationDAO() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testRetrieve() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
