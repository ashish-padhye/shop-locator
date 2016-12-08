package com.ashish.shoplocator.api.validator;

public interface Validator<T>{
	
	/**
	 * Method to validate object.
	 * @param obj
	 * @throws Exception
	 */
	public void validate(T obj) throws RuntimeException;
	
}
