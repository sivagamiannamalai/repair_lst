package com.pdxcycle9.repair_lst.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.pdxcycle9.repair_lst.entities.Part;
import com.pdxcycle9.repair_lst.util.Response;

@Service
public class AddPartsToRepairItemService {

	public Response addPartsToRepairItem(int repairItemId, int[] part) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
public ArrayList<Part> makePartsList(int[] part){
		
		ArrayList<Part> partList = new ArrayList<Part>();
		
		for(int i = 0; i < part.length; i++) {
			
			Part partsToAdd = new Part(part[i]);
			
			partList.add(partsToAdd);
			
		}
		
		return partList;
	}
	

}
