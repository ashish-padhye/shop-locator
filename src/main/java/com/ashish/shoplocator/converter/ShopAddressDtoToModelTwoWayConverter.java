package com.ashish.shoplocator.converter;

import com.ashish.shoplocator.api.converter.AbstractTwoWayConverter;
import com.ashish.shoplocator.dto.ShopAddressDto;
import com.ashish.shoplocator.model.ShopAddressModel;

public class ShopAddressDtoToModelTwoWayConverter extends AbstractTwoWayConverter<ShopAddressDto, ShopAddressModel> {

	@Override
	protected ShopAddressModel convert(ShopAddressDto shopAddressDto) {
		ShopAddressModel shopAddressModel = new ShopAddressModel();
		shopAddressModel.setNumber(shopAddressDto.getNumber());
		shopAddressModel.setPostCode(shopAddressDto.getPostCode());
		return shopAddressModel;
	}

	@Override
	protected ShopAddressDto convertBack(ShopAddressModel shopAddressModel) {
		ShopAddressDto shopAddressDto = new ShopAddressDto();
		shopAddressDto.setNumber(shopAddressModel.getNumber());
		shopAddressDto.setPostCode(shopAddressModel.getPostCode());
		return shopAddressDto;
	}

}
