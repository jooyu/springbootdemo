package com.zy.test.beans.ltw;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect  
public class MethodAroundAspect {  
    @Around("aroundMethod()")  
    public Object around(ProceedingJoinPoint pjp) throws Throwable {  
        System.out.println(pjp.getSignature().getName() + " begin...");  
        Object result = pjp.proceed();  
        System.out.println(pjp.getSignature().getName() + " end...");  
        return result;  
    }  
  
    @Pointcut("execution(public * com.zy.test.beans.ltw..*(..))")  
    public void aroundMethod() {  
    }  
} 