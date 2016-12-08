package com.ashish.shoplocator.geocoding.impl;

import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/shop-locator-servlet-context.xml",
"file:src/main/webapp/WEB-INF/config/root-context.xml" })
public class GoogleGeoCodingDelegateImplTest extends AbstractTestNGSpringContextTests  {

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
	public void restFrameworkTest() {
		
	}
}
