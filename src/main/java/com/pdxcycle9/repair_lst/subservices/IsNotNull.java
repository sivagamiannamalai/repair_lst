package com.pdxcycle9.repair_lst.subservices;

import java.math.BigDecimal;
import java.util.List;

import com.pdxcycle9.repair_lst.util.Error;

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
		double doubleVal = val.doubleValue();

		if (doubleVal >= 0) {
			return true;
		} else {
			errors.add(Error.RATE_INVALID);
		}

		return result;

	}


}
