package com.pdxcycle9.repair_lst.subservices;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pdxcycle9.repair_lst.util.Error;
@Component
public class IsValidMileage {
	
	
	boolean result = false;
	public boolean between0and999999(int miles, List<String> errors) {
		
		

		if (miles >= 0 && miles <= 999999) {
			result = true;
		} else {
			errors.add(Error.MILEAGE_IS_OUT_OF_RANGE);
		}

		return result;

	}

}
