package com.ashish.shoplocator.geocoding.impl;

import java.io.IOException;
import java.net.URLEncoder;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ashish.shoplocator.dto.LocationCoordinatesDto;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/shop-locator-servlet-context.xml",
"file:src/main/webapp/WEB-INF/config/root-context.xml" })
public class GoogleGeoCodingDelegateImplTest extends AbstractTestNGSpringContextTests  {

	@InjectMocks
	private GoogleGeoCodingDelegateImpl geoCodingDelegateImpl = new GoogleGeoCodingDelegateImpl();
	
	@Override
	@BeforeSuite
	protected void springTestContextPrepareTestInstance() throws Exception {
		super.springTestContextPrepareTestInstance();
	}

	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetLocationCoordinates() throws IOException {
		String addressString = "Shivar Garden Pimple Saudagar Pune 411027 Maharashtra India";
		LocationCoordinatesDto locationCoordinatesDto = geoCodingDelegateImpl.getLocationCoordinates(addressString);
		Assert.notNull(locationCoordinatesDto.getLat(), "Invalid Latitude");
		Assert.notNull(locationCoordinatesDto.getLng(), "Invalid Longitude");
	}
	
	@Test(expectedExceptions = {IOException.class})
	public void testFetchGeoCodeJsonResponseWithNonEncodedAddress() throws IOException {
		String addressString = "Shivar Garden Pimple Saudagar Pune 411027 Maharashtra India";
		String jsonResponse = geoCodingDelegateImpl.fetchGeoCodeJsonResponse(addressString);
		Assert.notNull(jsonResponse, "Invalid response");
	}
	
	@Test
	public void testFetchGeoCodeJsonResponseWithEncodedAddress() throws IOException {
		String addressString = URLEncoder.encode("Shivar Garden Pimple Saudagar Pune 411027 Maharashtra India",
			    java.nio.charset.StandardCharsets.UTF_8.toString()
				  );
		String jsonResponse = geoCodingDelegateImpl.fetchGeoCodeJsonResponse(addressString);
		Assert.notNull(jsonResponse, "Invalid response");
	}
	
}
