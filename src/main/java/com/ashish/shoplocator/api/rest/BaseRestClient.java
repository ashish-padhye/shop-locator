package com.ashish.shoplocator.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class BaseRestClient {
	@Autowired
	public RestTemplate restTemplate;
	
	public RestTemplate getRestTemplate() {
	    return restTemplate;
	}
	
	public void setRestTemplate(RestTemplate restTemplate) {
	    this.restTemplate = restTemplate;
	}
}