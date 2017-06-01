package com.zy.test.controller.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class GradeAndClassroomModel {  
	  private long id;  
	    @NotEmpty(message="姓名不能为空")  
	    private String name;  
	      
	    @NotEmpty(message="密码不能为空")  
	    @Length(min=6,message="密码长度不能小于6位")  
	    private String password;  
}