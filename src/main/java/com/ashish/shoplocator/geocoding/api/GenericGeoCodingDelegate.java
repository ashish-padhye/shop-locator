package com.ashish.shoplocator.geocoding.api;

import java.io.IOException;

import com.ashish.shoplocator.dto.LocationCoordinatesDto;
/**
 * Generic Geocoding Delegate Interface - Allows plugging in different GeoCoding Implementations into the ShopLocator App.
 */
public interface GenericGeoCodingDelegate {

	String fetchGeoCodeJsonResponse(String address) throws IOException;
	
	LocationCoordinatesDto getLocationCoordinates(String address) throws IOException;
	
}
