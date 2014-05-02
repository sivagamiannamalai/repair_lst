package com.pdxcycle9.repair_lst.subservices;

import java.util.List;

import com.pdxcycle9.repair_lst.util.Error;

public class IsValidMileage {
	
	public boolean between1and999999(int miles, List<String> errors) {

		boolean result = false;

		if (miles >= 0 && miles <= 999999) {
			result = true;
		} else {
			errors.add(Error.MILEAGE_IS_OUT_OF_RANGE);
		}

		return result;

	}

}
