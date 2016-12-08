package com.ashish.shoplocator.geocoding.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import com.ashish.shoplocator.dto.LocationCoordinatesDto;
import com.ashish.shoplocator.geocoding.api.GenericGeoCodingDelegate;
import com.ashish.shoplocator.geocoding.google.dto.GoogleGeoCodeResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GoogleGeoCodingDelegateImpl implements GenericGeoCodingDelegate {

	@Override
	public String fetchGeoCodeJsonResponse(String address) throws IOException {
		URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD3PRRjN1TXyhtE3M8nTf66NNWjGNrtIGA&new_forward_geocoder=false&address=" + address);
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		String jsonResult = "";
		while ((inputLine = in.readLine()) != null) {
		    jsonResult += inputLine;
		}
		in.close();
		return jsonResult; 		
	}

	@Override
	public LocationCoordinatesDto getLocationCoordinates(String address)
			throws IOException {
		LocationCoordinatesDto locationCoordinatesDto = new LocationCoordinatesDto();
		String addressUrlEncodedString = URLEncoder.encode(address,
			    java.nio.charset.StandardCharsets.UTF_8.toString()
			  );
		
		String jsonInOneString = fetchGeoCodeJsonResponse(addressUrlEncodedString);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GoogleGeoCodeResponse result = mapper.readValue(jsonInOneString,GoogleGeoCodeResponse.class);
		if(result!=null && result.results!=null && result.results.length>0 && result.results[0].geometry!=null 
				&& result.results[0].geometry.location!=null && result.results[0].geometry.location.lat!=null) {
			locationCoordinatesDto.setLat(Double.valueOf(result.results[0].geometry.location.lat));
			locationCoordinatesDto.setLng(Double.valueOf(result.results[0].geometry.location.lng));
		} 
		return locationCoordinatesDto;
	}

}
