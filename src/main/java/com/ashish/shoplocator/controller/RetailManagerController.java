package com.ashish.shoplocator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.shoplocator.controller.validator.ControllerValidator;
import com.ashish.shoplocator.dto.CustomerResponseDto;
import com.ashish.shoplocator.dto.RetailManagerRequestDto;
import com.ashish.shoplocator.dto.RetailManagerResponseDto;
import com.ashish.shoplocator.service.RetailManagerFacadeService;

@RestController
@RequestMapping("/retailmanager")
public class RetailManagerController {
	
	@Autowired
	ControllerValidator controllerValidator;
	@Autowired
	RetailManagerFacadeService facadeService;

	/**
	 * This is the test method for this Controller.
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
	public @ResponseBody String test() {
		return "Success";
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody RetailManagerResponseDto createShopDetail(@RequestBody RetailManagerRequestDto requestDto) throws RuntimeException {
		controllerValidator.validateRetailManagerRequestDto(requestDto);
		return facadeService.createRetailManagerShop(requestDto);
	}

	@RequestMapping(value = "/getClosestShop", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody CustomerResponseDto getClosestShop(@RequestParam(value = "customerLatitude", required = true) String customerLatitude,
			@RequestParam(value = "customerLongitude", required = true) String customerLongitude) throws RuntimeException {
		CustomerResponseDto closestShopDetails = facadeService.getClosestShopDetails(customerLatitude, customerLongitude);
		return closestShopDetails;
	}

}
