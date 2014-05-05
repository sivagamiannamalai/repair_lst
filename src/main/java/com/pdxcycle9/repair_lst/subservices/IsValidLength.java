package com.pdxcycle9.repair_lst.subservices;

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
		boolean isNumber = false;
		int phoneNum = 0;
		
		try {
			phoneNum = Integer.parseInt(phone);
			isNumber =  true;
		} catch (Exception e) {
			
		}

		if(phone.length() == 10 && isNumber) {
			result = true;
		} else {
			errors.add(Error.PHONE_INVALID);
		}
		return result;

	}
	
}
