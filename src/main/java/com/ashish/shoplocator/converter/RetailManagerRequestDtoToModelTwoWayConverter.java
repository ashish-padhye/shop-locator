package com.ashish.shoplocator.converter;

import com.ashish.shoplocator.api.converter.AbstractTwoWayConverter;
import com.ashish.shoplocator.dto.RetailManagerRequestDto;
import com.ashish.shoplocator.dto.ShopDetailDto;
import com.ashish.shoplocator.model.ShopDetailModel;

public class RetailManagerRequestDtoToModelTwoWayConverter extends AbstractTwoWayConverter<ShopDetailDto, ShopDetailModel> {

	@Override
	protected ShopDetailModel convert(ShopDetailDto shopDetailDto) {
		ShopDetailModel shopDetailModel = new ShopDetailModel();
		shopDetailModel.setShopName(shopDetailDto.getShopName());
		shopDetailModel.setShopLatitude(shopDetailDto.getShopLatitude());
		shopDetailModel.setShopLongitude(shopDetailDto.getShopLongitude());
		return shopDetailModel;
	}

	@Override
	protected ShopDetailDto convertBack(ShopDetailModel shopDetailModel) {
		ShopDetailDto shopDetailDto = new ShopDetailDto();
		shopDetailDto.setShopName(shopDetailModel.getShopName());
		shopDetailDto.setShopLatitude(shopDetailModel.getShopLatitude());
		shopDetailDto.setShopLongitude(shopDetailModel.getShopLongitude());
		return shopDetailDto;

	}

}
