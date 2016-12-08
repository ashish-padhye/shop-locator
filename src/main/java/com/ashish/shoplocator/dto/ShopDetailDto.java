package com.ashish.shoplocator.dto;

public class ShopDetailDto {
	
	private String shopName;
	private ShopAddressDto shopAddress;
	private Double shopLongitude;
	private Double shopLatitude;

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
	public Double getShopLongitude() {
		return shopLongitude;
	}
	public void setShopLongitude(Double shopLongitude) {
		this.shopLongitude = shopLongitude;
	}
	public Double getShopLatitude() {
		return shopLatitude;
	}
	public void setShopLatitude(Double shopLatitude) {
		this.shopLatitude = shopLatitude;
	}
	
}
