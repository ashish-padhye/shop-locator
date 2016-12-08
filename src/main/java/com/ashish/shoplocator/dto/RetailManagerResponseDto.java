package com.ashish.shoplocator.dto;

public class RetailManagerResponseDto extends ShopDetailDto {

	public RetailManagerResponseDto(ShopDetailDto dto) {
		this.setShopAddress(dto.getShopAddress());
		this.setShopLatitude(dto.getShopLatitude());
		this.setShopLongitude(dto.getShopLongitude());
		this.setShopName(dto.getShopName());
	}

}
