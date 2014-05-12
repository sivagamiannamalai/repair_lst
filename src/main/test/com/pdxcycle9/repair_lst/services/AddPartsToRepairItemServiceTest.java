package com.pdxcycle9.repair_lst.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.pdxcycle9.repair_lst.DAO.PartDAO;
import com.pdxcycle9.repair_lst.DAO.RepairItemDAO;

@RunWith(MockitoJUnitRunner.class)
public class AddPartsToRepairItemServiceTest {
	@Mock
	private PartDAO partDAO;

	@Mock
	private RepairItemDAO repairItemDAO;
	@InjectMocks
	private AddPartsToRepairItemService addPartsToRepairItemService = new AddPartsToRepairItemService();

	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@Test
	public void testAddPartsToRepairItem() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetRepairItem() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testMakePartsList() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testUpdateRepairWithItems() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
