package com.zy.test.beans.ltw;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zy.test.service.UserService;

//@Configurable(autowire = Autowire.BY_NAME)

@Component
public class LTWBean {  

	
	@PostConstruct
	public void init() 
	{
		System.out.println("init LTWBean~");
		
	
	}
	  
    public void run() {  
        System.out.println("LTWBean run...");  
    }  
    
    
    public void test()
    {
    	System.out.println("LTWBean hello");
  
    }
}