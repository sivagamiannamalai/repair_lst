package com.pdxcycle9.repair_lst.subservices;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pdxcycle9.repair_lst.util.Error;

@Component
public class IsValidLength {
	public boolean between1and255(String string, List<String> errors) {

		boolean result = false;

		if (string.length() > 0 && string.length() <= 255) {
			result = true;
		} else {
			errors.add(Error.IS_WRONG_LENGTH);
		}
		return result;
	}
	
	public boolean zipIsFive(String zip, List<String> errors){
		
		boolean result = false;	
		if(zip.length() == 5) {
			result = true;
		} else {
			errors.add(Error.ZIP_INVALID);
		}
		return result;
	}
	

	public boolean isPhoneValidLength(String phone, List<String> errors)  {
		boolean result = false;		
		
		if(phone.length() == 10) {
			result = true;
		} else {
			errors.add(Error.PHONE_INVALID);
		}
		return result;

	}
	
	public boolean isPartsValidLength(int[] array, List<String> errors)  {
		boolean result = false;		
		
		if(array.length > 0) {
			result = true;
		} else {
			errors.add(Error.NO_PARTS_ENTERED);
		}
		return result;
	}

	public boolean isValidUser(String input, List<String> errors) {
		boolean result = false;
		
		if(input.length() > 0 && input.length() <= 32) {
			result = true;
		} else {
			errors.add(Error.INVALID_USER);
		}
		return result;

	}
	
	public boolean isDateValidLength(Date date, List<String> errors) {

		boolean result = false;
		try {
			long longVal = date.getTime();
			if (longVal == 8) {
				result = true;				
			}
		}
		catch (Exception e) {
			errors.add(Error.DATE_INVALID);
		}

		return result;

	}
	
	public boolean isRatingValidLength(int rating, List<String> errors) {
		
		boolean result = false;		
		
		if(rating >= 1 && rating <= 5) {
			result = true;
		} else {
			errors.add(Error.RATING_INVALID);
		}
		return result;
		
	}
	
}
