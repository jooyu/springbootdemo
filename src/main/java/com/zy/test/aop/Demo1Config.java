package com.zy.test.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//@Configuration
//@Aspect
//@Order(1)
//public class Demo1Config {
//	private final Logger logger = Logger.getLogger(getClass());
//	
//    @Pointcut("execution( * com.zy.test.controller.*.*(..))")
//	public void pointCutAt() {
//    	demo1Service();
//	}
//	
//	@Before("pointCutAt()")
//	public void beforeAction() {
//		logger.warn("在处理请求前，必须经过我！！！  demo1  order(1)");
//	}
//  
//
//    public Demo1Service demo1Service(){
//        System.out.println("demo1config 加载了");
//        return new Demo1Service();
//    }
//}