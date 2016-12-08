package com.ashish.shoplocator.controller.validator;

import org.springframework.stereotype.Component;

import com.ashish.shoplocator.api.validator.AbstractValidator;
import com.ashish.shoplocator.dto.RetailManagerRequestDto;

@Component
public class CreateShopDetailValidator extends AbstractValidator<RetailManagerRequestDto> {
	private static final String SHOP_NAME = "Shop Name";
	private static final String SHOP_ADDRESS_NUMBER = "Shop Number";
	private static final String SHOP_ADDRESS_POSTCODE = "Shop Post Code";

	@Override
	public void validate(RetailManagerRequestDto requestDto) throws RuntimeException {

		validateBlankString(SHOP_NAME, requestDto.getShopName());
		if(requestDto.getShopAddress() == null) {
			throw new RuntimeException("Invalid Address for shop");
		}
		validateBlankString(SHOP_ADDRESS_NUMBER, requestDto.getShopAddress().getNumber());
		validateBlankString(SHOP_ADDRESS_POSTCODE, requestDto.getShopAddress().getPostCode());
	}
}
