package com.ashish.shoplocator.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ashish.shoplocator.model.ShopDetailModel;

@Component
@Scope("singleton")
public class ServiceValidator{
	
	@Autowired
	CreateShopDetailModelValidator createShopDetailModelValidator;

	public void validateCreateShopDetail(ShopDetailModel shopDetailModel) throws RuntimeException {
		createShopDetailModelValidator.validate(shopDetailModel);
	}
}
