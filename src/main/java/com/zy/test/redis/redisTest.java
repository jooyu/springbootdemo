//package com.zy.test.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//@Component
//public class redisTest {
//	
//	 	@Autowired
//	   private  RedisRepository redisMethod;
//
//
////@Scheduled(fixedDelay = 500)
//public void getDataFromRedis() {
//
//	
//    try {
//    	redisMethod.set("aaa", "111");
//		System.out.println( redisMethod.get("aaa"));
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//
//}
