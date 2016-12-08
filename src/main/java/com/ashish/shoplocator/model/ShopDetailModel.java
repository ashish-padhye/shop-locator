package com.ashish.shoplocator.model;

public class ShopDetailModel {

	private String shopName;
	private ShopAddressModel shopAddress;
	private Double shopLongitude;
	private Double shopLatitude;

	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ShopAddressModel getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(ShopAddressModel shopAddress) {
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
