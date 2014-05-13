package com.pdxcycle9.repair_lst.subservices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.expression.ParseException;
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
	
	public boolean between0and255(String string, List<String> errors) {

		boolean result = false;

		if (string.length() >= 0 && string.length() <= 255) {
			result = true;
		} else {
			errors.add(Error.IS_TOO_LONG);
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
	
	public boolean isDateValidLength(String dateData, List<String> errors) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		boolean result = false;
		Date testDate = null;
		try {
			testDate = formatter.parse(dateData);
		} catch (java.text.ParseException e) {
			errors.add(Error.DATE_INVALID);
			e.printStackTrace();
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
