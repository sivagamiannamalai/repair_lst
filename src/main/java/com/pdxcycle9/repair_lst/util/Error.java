package com.pdxcycle9.repair_lst.util;

public class Error {

		public static final String IS_NULL = "Error: cannot be null.";		

		public static final String IS_WRONG_LENGTH = "Error: This field must be between 1 and 255 characters";
		
        public static final String CANNOT_PERSIST = "Error: Could not persist to the database";
        
        public static final String CANNOT_UPDATE = "Error: Could not update the database";
    	
    	public static final String IS_EMPTY = "No records retrieved";
    	
    	public static final String MILEAGE_IS_OUT_OF_RANGE = "Error: Mileage must be between 0 and 999999";
    	
    	public static final String DUPLICATE_ADDRESS = "Error: Address already exists";
    	
    	public static final String DUPLICATE_FACILITY = "Error: Facility already exists";
    	
    	public static final String DUPLICATE_RECORD = "Error: Record already exists";
    	
    	public static final String RATE_INVALID = "Error: Hourly Rate should be 0 or greater";
    	
    	public static final String ZIP_INVALID = "Error: Zip should be exactly 5 digits";
    	
    	public static final String PHONE_INVALID = "Error: Invalid phone number";
    	
    	public static final String NO_PARTS_ENTERED = "Error: Must indicate at least one part.";

    	public static final String MUST_BE_NUMBER = "Error: Must enter a value.";
		
}
