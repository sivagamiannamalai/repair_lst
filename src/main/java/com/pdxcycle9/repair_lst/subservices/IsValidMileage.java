package com.pdxcycle9.repair_lst.subservices;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pdxcycle9.repair_lst.util.Error;

@Component
public class IsValidMileage {

	public boolean between0and999999(int miles) {

		boolean result = false;

		if (miles >= 0 && miles <= 999999) {
			result = true;
		} 
		return result;

	}

}
