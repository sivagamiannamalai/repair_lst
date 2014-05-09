package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.RepairItemDAO;
import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.entities.RepairItem;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class AddPartsToRepairItemService {

	@Autowired
	RepairItemDAO repairItemDAO;
	/**
	 * Create a repair item object, calls makePartsList to set parts, then after validation
	 * makes a call to the DAO to persist the new part/repair item relationships
	 * @param repairItemId
	 * @param part
	 * @return response
	 */
	@Transactional
	public Response addPartsToRepairItem(int repairItemId, int[] part) {

		Response response = new Response();
		List<String> errors = new ArrayList<String>();	
		
		RepairItem repairItem = repairItemDAO.retrieveRepairItemByID(repairItemId);
		
		repairItem.setParts(makePartsList(part));
		
		
		
		return response;
	}
	
/**
 * Creates an array list of parts with IDs passed from the controller	
 * @param part
 * @return partList
 */
public ArrayList<Part> makePartsList(int[] part){
		
		ArrayList<Part> partList = new ArrayList<Part>();
		
		for(int i = 0; i < part.length; i++) {
			
			Part partsToAdd = new Part(part[i]);
			
			partList.add(partsToAdd);
			
		}
		
		return partList;
	}

/**
 * function that sets the response object to the errors
 * @param response
 * @param errors
 */
public void failed(Response response, List<String> errors) {
	response.setResponseObject(errors);
	response.setStatusCode(HttpStatus.BAD_REQUEST);
}
	

}
