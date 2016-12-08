package com.ashish.shoplocator.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.ashish.shoplocator.dto.ShopAddressDto;
import com.ashish.shoplocator.dto.ShopDetailDto;
import com.ashish.shoplocator.model.ShopAddressModel;
import com.ashish.shoplocator.model.ShopDetailModel;

@Component
@Scope("singleton")
public class RetailManagerDtoModelConverter {

	@Autowired
	ConversionService conversionService;

	public ShopDetailDto convertModelToDto(ShopDetailModel shopDetailModel){
		ShopDetailDto shopDetailDto = conversionService.convert(shopDetailModel, ShopDetailDto.class);
		ShopAddressDto shopAddressDto = conversionService.convert(shopDetailModel.getShopAddress(), ShopAddressDto.class);
		shopDetailDto.setShopAddress(shopAddressDto);
		return shopDetailDto;
	}
	
	
	public ShopDetailModel convertDtoToModel(ShopDetailDto shopDetailDto){
		ShopDetailModel shopDetailModel = conversionService.convert(shopDetailDto, ShopDetailModel.class);
		ShopAddressModel shopAddressModel = conversionService.convert(shopDetailDto.getShopAddress(), ShopAddressModel.class);
		shopDetailModel.setShopAddress(shopAddressModel);
		return shopDetailModel;

	}

}
