package com.ashish.shoplocator.service.impl;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.shoplocator.model.ShopDetailModel;
import com.ashish.shoplocator.service.RetailManagerService;

@Repository
@Transactional
public class RetailManagerServiceImpl implements RetailManagerService {
	private static final Logger logger = LoggerFactory.getLogger(RetailManagerServiceImpl.class);
	
	@Resource 
	List<ShopDetailModel> shopDetailRepository = new CopyOnWriteArrayList<ShopDetailModel>();
		
	@Override
	public ShopDetailModel createRetailManagerShop(
			ShopDetailModel shopDetailModel)
			throws RuntimeException {
		
		shopDetailRepository.add(shopDetailModel);
		return shopDetailModel;
	}

	@Override
	public ShopDetailModel getClosestShopDetails(
			String customerLatitude, String customerLongitude)
			throws RuntimeException {
		if(shopDetailRepository.isEmpty()) {
			throw new RuntimeException("No Shops Available");
		}
		TreeMap<Double, ShopDetailModel> shopDistanceMap = new TreeMap<Double, ShopDetailModel>();
		double latDiff = -1;
		double lngDiff = -1;
		for(ShopDetailModel shopDetailModel : shopDetailRepository) {
			latDiff = shopDetailModel.getShopLatitude() - Double.valueOf(customerLatitude);
			lngDiff = shopDetailModel.getShopLongitude() - Double.valueOf(customerLongitude);
			double closenessCoeff = Math.abs(latDiff + lngDiff); 
			shopDistanceMap.put(closenessCoeff, shopDetailModel);
			if(latDiff == 0 && lngDiff == 0){
				break;
			}
		}
		Set<Entry<Double, ShopDetailModel>> entrySet = shopDistanceMap.entrySet();
		Entry<Double, ShopDetailModel> closest = entrySet.iterator().next();
		return closest.getValue();
	}

}
