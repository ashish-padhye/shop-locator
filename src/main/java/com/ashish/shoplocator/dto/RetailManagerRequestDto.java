package com.ashish.shoplocator.dto;

public class RetailManagerRequestDto {
	
	private String shopName;
	private ShopAddressDto shopAddress;

	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ShopAddressDto getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(ShopAddressDto shopAddress) {
		this.shopAddress = shopAddress;
	}

}
