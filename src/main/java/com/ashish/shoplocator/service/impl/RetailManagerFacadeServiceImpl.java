package com.ashish.shoplocator.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.shoplocator.converter.RetailManagerDtoModelConverter;
import com.ashish.shoplocator.dto.CustomerResponseDto;
import com.ashish.shoplocator.dto.LocationCoordinatesDto;
import com.ashish.shoplocator.dto.RetailManagerRequestDto;
import com.ashish.shoplocator.dto.RetailManagerResponseDto;
import com.ashish.shoplocator.dto.ShopDetailDto;
import com.ashish.shoplocator.geocoding.api.GenericGeoCodingDelegate;
import com.ashish.shoplocator.model.ShopDetailModel;
import com.ashish.shoplocator.service.RetailManagerFacadeService;
import com.ashish.shoplocator.service.RetailManagerService;
import com.ashish.shoplocator.service.validator.ServiceValidator;

@Service
@Transactional
public class RetailManagerFacadeServiceImpl implements RetailManagerFacadeService {

	@Autowired
	RetailManagerDtoModelConverter dtoModelConverter;
	@Autowired
	RetailManagerService retailManagerService;
	//Using autowiring of delegate for simplicity, as we have only one geocoding delegate impl, as of now
	@Autowired
	GenericGeoCodingDelegate geoCodingDelegate; 
	@Autowired
	private ServiceValidator serviceValidator;
	
	@Override
	public RetailManagerResponseDto createRetailManagerShop(
			RetailManagerRequestDto retailManagerRequestDto)
			throws RuntimeException {
		ShopDetailDto shopDetailDto = new ShopDetailDto();
		shopDetailDto.setShopAddress(retailManagerRequestDto.getShopAddress());
		shopDetailDto.setShopName(retailManagerRequestDto.getShopName());
		ShopDetailModel shopDetailModel = dtoModelConverter.convertDtoToModel(shopDetailDto);
		try {
			String addressString = shopDetailDto.getShopAddress().getNumber()+" "+
						shopDetailDto.getShopAddress().getPostCode();
			LocationCoordinatesDto locationCoordinatesDto = geoCodingDelegate.getLocationCoordinates(addressString);
			if(locationCoordinatesDto!=null && locationCoordinatesDto.getLat()!=null && locationCoordinatesDto.getLng()!=null) {
				shopDetailModel.setShopLatitude(locationCoordinatesDto.getLat());
				shopDetailModel.setShopLongitude(locationCoordinatesDto.getLng());
			} else {
				handleGeoCodingException();
			}
		} catch(IOException ioe) {
			handleGeoCodingException();
		}
		//validate our model Object before Persisting.
		serviceValidator.validateCreateShopDetail(shopDetailModel);
		ShopDetailModel savedShopDetailModel = retailManagerService.createRetailManagerShop(shopDetailModel);
		ShopDetailDto savedShopDetailDto = dtoModelConverter.convertModelToDto(savedShopDetailModel);
		return new RetailManagerResponseDto(savedShopDetailDto);
	}
	
	@Override
	public CustomerResponseDto getClosestShopDetails(
			String customerLatitude, String customerLongitude)
			throws RuntimeException {
		ShopDetailModel closestShopDetailModel = retailManagerService.getClosestShopDetails(customerLatitude, customerLongitude);
		ShopDetailDto closestShopDetailDto = dtoModelConverter.convertModelToDto(closestShopDetailModel);
		return new CustomerResponseDto(closestShopDetailDto);

	}

	private void handleGeoCodingException() {
		//TODO: Create a BusinessException to throw here.
		throw new RuntimeException("Failure retrieving Geocoding details");
	}


}
