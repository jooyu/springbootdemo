package com.zy.test.aspectj;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.zy.test.aspectj.bean.TestAspectjService;
import com.zy.test.beans.ltw.LTWBean;
import com.zy.test.service.UserService;
import com.zy.test.serviceImp.UserServiceImpl;

/***
 * 运行时候编织进入
 * @author eaves.zhu
 *
 */
@Configurable(autowire = Autowire.BY_TYPE)
public class TestforAspectJ {

@Autowired
private TestAspectjService testAspectjService;

	   @PostConstruct
	    public void PostConstruct() {
		   
		   System.out.println(""
		   		+ "******this is class TestForAspectJ 的PostConstruct*****");
		   testAspectjService.hello();

	    }
	   public void cut()
	   {
		   System.out.println("this is cut");
		   testAspectjService.hello();
		 
	   }
	   
	   
	  

}
