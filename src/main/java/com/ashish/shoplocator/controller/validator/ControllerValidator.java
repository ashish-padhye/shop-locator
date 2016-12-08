package com.ashish.shoplocator.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ashish.shoplocator.dto.RetailManagerRequestDto;

@Component
@Scope("singleton")
public class ControllerValidator {
	
	@Autowired
	CreateShopDetailValidator createShopDetailValidator;

	public void validateRetailManagerRequestDto(RetailManagerRequestDto userRewardTransactionDto) throws RuntimeException {
		createShopDetailValidator.validate(userRewardTransactionDto);
	}
}
