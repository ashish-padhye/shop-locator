package com.ashish.shoplocator.api.validator;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * Abstract class for Validator classes
 */
public abstract class AbstractValidator<T> implements Validator<T>{
	
	/**
	 * Method to validate object.
	 * @param obj
	 * @throws Exception
	 */
	public abstract void validate(T obj) throws RuntimeException;
	
	/**
	 * Method to validate blank String (this method treats whitespace as invalid string)
	 * @param fieldName
	 * @param str
	 * @throws Exception
	 */
	public void validateBlankString(String fieldName, String str) throws RuntimeException{
		if(StringUtils.isBlank(str)){
			throw new RuntimeException("Field "+ fieldName + "cannot be empty");
		}
	}
		
}
