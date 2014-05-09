package com.pdxcycle9.repair_lst.subservices;

import java.math.BigDecimal;
import java.util.List;

import com.pdxcycle9.repair_lst.entities.Address;
import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



@Component
public class IsNotNull {
	/**
	 * This subservice checks if a null result is sent to a service.
	 * This should only be possible to initiate through the Advanced REST client
	 * @param string
	 * @param errors
	 * @return
	 */
	public boolean isFieldNotNull(String string, List<String> errors) {

		boolean result = false;

		if (string != null) {

			return true;
		} else {
			errors.add(Error.IS_NULL);
		}

		return result;

	}
	
	public boolean isFieldNotEmpty(double val, List<String> errors) {

		boolean result = false;

		if (val > 0) {

			return true;
		} else {
			errors.add(Error.IS_NULL);
		}

		return result;

	}
	
	public boolean isHourlyRateValid(BigDecimal val, List<String> errors) {

		boolean result = false;
		try {
			double doubleVal = val.doubleValue();
			if (doubleVal >= 0) {
				result = true;				
			}
		}
		catch (Exception e) {
			errors.add(Error.RATE_INVALID);
		}

		return result;

	}
	
	public boolean isAddressIdValid(Address address, List<String> errors, Response response) {

		boolean result = false;
		int intVal = address.getId();
			if (intVal > 0) {
				result = true;				
			} else {
				errors.add(Error.ADDRESSID_INVALID);
				failed(response, errors);
			}

		return result;

	}
	
	public void failed(Response response, List<String> errors) {

		response.setResponseObject(errors);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
	}


}
