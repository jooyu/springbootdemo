package com.zy.test.cache;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;



@Component
@CacheConfig(cacheNames="CityService")
public class CityService {


	//如果DAO层被平凡访问，但是数据变化不是特别平凡可以考虑 cache
	@Cacheable
	public CityInfo getCity(int id, String city) {

		System.out.println("DAO cache  id: "+id+"city: "+ city);
		return new CityInfo(id, city);
	}
}
