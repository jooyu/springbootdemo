package com.zy.test.aspectj.bean;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;


@Component
public class TestAspectjService {
	
//不能加   @PostConstruct

	  @PostConstruct
	  public  void test()
	  {
		  System.out.println("TestAspectjService d的 @PostConstruct");
	  }
	  
public void hello()
{
	
System.out.println("我是注入的bean的方法");}
}
