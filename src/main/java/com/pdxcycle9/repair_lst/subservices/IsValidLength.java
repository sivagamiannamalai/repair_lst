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
	
	public boolean zipIsFive(String val, List<String> errors){
		
		boolean result = false;		
		
		if (val.length()==5) {	
			try {
				int zipInt = Integer.parseInt(val);
			} catch (NumberFormatException e) {
				errors.add(Error.ZIP_INVALID);
			}
			result = true;				
		} else {				
			errors.add(Error.IS_WRONG_LENGTH);				
		}
				
		return result;
		
	}
	
	

	public boolean isPhoneValidLength(String phone, List<String> errors)  {
		boolean result = false;
		if(phone.length() < 15) {
			result = true;
		} else {
			errors.add(Error.PHONE_INVALID);
		}
		return result;

	}
	
}
