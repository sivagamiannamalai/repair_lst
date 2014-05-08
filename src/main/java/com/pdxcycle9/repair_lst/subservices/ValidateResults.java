package com.pdxcycle9.repair_lst.subservices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.pdxcycle9.repair_lst.util.Error;
import com.pdxcycle9.repair_lst.util.Response;

@Component
public class ValidateResults {

	public void isNotEmpty(List<String> errors, List<?> result,
			Response response) {

		if (result.isEmpty()) {
			errors.add(Error.IS_EMPTY);
			failed(response, errors);
		} else {
			response.setStatusCode(HttpStatus.OK);
			response.setResponseObject(result);
		}

	}

	public void failed(Response response, List<String> errors) {

		response.setResponseObject(errors);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
	}

}
