package com.ashish.shoplocator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retailmanager")
public class RetailManagerController {

	/**
	 * This is the test method for this Controller.
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
	public @ResponseBody String test() {
		return "Success";
	}

}
