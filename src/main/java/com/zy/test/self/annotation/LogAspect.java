//package com.zy.test.self.annotation;
//
//import java.lang.reflect.Method;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
///**
// * 用途日志收集等等
// * @author eaves.zhu
// *
// */
//@Component
//@Aspect
//public class LogAspect {
//	   @Pointcut("@annotation(com.zy.test.self.annotation.Log)")
//	    public  void  annotationPointCut() {
//		   System.out.println("我是切点，开始注解");
//	    }
//
//	    @Before("annotationPointCut()")
//	    public void before(JoinPoint joinPoint){
//	       MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
//	       Method method = sign.getMethod();
//	       System.out.print("接受方法："+method.getName()+" 前置日志");
//	    }
//	    
//	    @Around("annotationPointCut()")
//	    public void advice(ProceedingJoinPoint joinPoint){
//	        System.out.println("环绕通知之开始");
//	        try {
//	        	//切点方法执行
//	            joinPoint.proceed();
//	        } catch (Throwable e) {
//	            e.printStackTrace();
//	        }
//	        System.out.println("环绕通知之结束");
//	    }
//}
