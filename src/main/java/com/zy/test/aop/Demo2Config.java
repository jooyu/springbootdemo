package com.zy.test.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//@Configuration
//@Aspect
//@Order(2)
//public class Demo2Config {
//	private final Logger logger = Logger.getLogger(getClass());
//	
//	@Pointcut("execution( * com.zy.test.controller.*.*(..))")
//	public void pointCutAt() {
//		demo2Service(); 
//	}
//	
//	@Before("pointCutAt()")
//	public void beforeAction() {
//		logger.warn("在处理请求前，必须经过我！！！ demo2  order(2)");
//	}
//	
//
//    public Demo2Service demo2Service(){
//        System.out.println("demo2config 加载了");
//        return new Demo2Service();
//    }
//
//}