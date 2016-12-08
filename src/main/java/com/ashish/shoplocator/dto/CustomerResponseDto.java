package com.ashish.shoplocator.dto;

public class CustomerResponseDto extends ShopDetailDto {

	public CustomerResponseDto(ShopDetailDto dto) {
		this.setShopAddress(dto.getShopAddress());
		this.setShopLatitude(dto.getShopLatitude());
		this.setShopLongitude(dto.getShopLongitude());
		this.setShopName(dto.getShopName());
	}
	
}
