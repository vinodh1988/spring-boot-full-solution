package com.bootapps.utilities;

public class RecordAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Record with this id already exists";
	}


}
