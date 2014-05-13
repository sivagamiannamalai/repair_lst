package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdxcycle9.repair_lst.DAO.PartDAO;
import com.pdxcycle9.repair_lst.DAO.RepairItemDAO;
import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.entities.RepairItem;
import com.pdxcycle9.repair_lst.subservices.IsValidLength;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class AddPartsToRepairItemService {

	@Autowired
	RepairItemDAO repairItemDAO;
	@Autowired 
	IsValidLength isValidLength;
	
	@Autowired
	PartDAO partDAO;
	
	/**
	 * Create a repair item object, calls makePartsList to set parts, then after validation
	 * makes a call to the DAO to persist the new part/repair item relationships
	 * @param repairItemId
	 * @param part
	 * @return response
	 */
	public Response addPartsToRepairItem(int repairItemId, int[] parts) {

		Response response = new Response();
		List<String> errors = new ArrayList<String>();	
		RepairItem repairItem = new RepairItem();
		
			
		repairItem = getRepairItem(repairItemId, repairItem, response, errors);
				
		repairItem.setParts(makePartsList(parts, response, errors));

		updateRepairWithParts(repairItem, response, errors);

		return response;
	}
	
	/**
	 * Passes an ID to the DAO function to find a repair item and return it
	 * so that a list of parts can be added
	 * @param repairItemId
	 * @param repairItem
	 * @param errors 
	 * @return
	 */
	@Transactional
	public RepairItem getRepairItem(int repairItemId, RepairItem repairItem, Response response, List<String> errors) {
		
		 try {
			 
			repairItem = repairItemDAO.retrieveRepairItemByID(repairItemId);
			
		} catch (Exception e) {
			
			errors.add(Error.CANNOT_PERSIST);
			failed(response, errors);
			e.printStackTrace();
		}
		 
		return repairItem; 
	}
	
	/**
	 * Creates an array list of parts with IDs passed from the controller	
	 * @param part
	 * @return partList
	 */
	@Transactional
	public ArrayList<Part> makePartsList(int[] parts, Response response, List<String> errors){
			
			ArrayList<Part> partList = new ArrayList<Part>();
			
			for(int i = 0; i < parts.length; i++) {
				
				
				try {
					
					Part partsToAdd = partDAO.retrievePartById(parts[i]);
					partList.add(partsToAdd);
					
				} catch (Exception e) {

					errors.add(Error.CANNOT_PERSIST);
					failed(response, errors);
					e.printStackTrace();
				}
				
			}
			
			return partList;
		}
	
	/**
	 * Calls DAO to update the Repair item, this should only add parts as all
	 * repair item info has been retrieved and none has been altered
	 * @param repairItem
	 * @param response
	 * @param errors
	 * @return
	 */
	@Transactional
	public Response updateRepairWithParts(RepairItem repairItem, Response response, List<String> errors) {
		
		try {
			
			repairItemDAO.updateRepairItemAddParts(repairItem);
			response.setResponseObject(repairItem);
			response.setStatusCode(HttpStatus.OK);
			
		} catch (Exception e) {
			
			errors.add(Error.CANNOT_PERSIST);
			failed(response, errors);
			e.printStackTrace();
			
		}
		
		return response;
		
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
