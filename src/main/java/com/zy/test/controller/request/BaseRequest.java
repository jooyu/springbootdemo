package com.zy.test.controller.request;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
public class BaseRequest {
	 private long id;
	   
	    @NotEmpty(message="姓名不能为空")
	    private String name;
	   
	    @NotEmpty(message="密码不能为空")
	    @Length(min=6,message="密码长度不能小于6位")
	    private String password;
	 
	    public long getId() {
	       return id;
	    }
	 
	    public void setId(long id) {
	       this.id = id;
	    }
	 
	    public String getName() {
	       return name;
	    }
	 
	    public void setName(String name) {
	       this.name = name;
	    }
	 
	    public String getPassword() {
	       return password;
	    }
	 
	    public void setPassword(String password) {
	       this.password = password;
	    }
	 
	    @Override
	    public String toString() {
	       return "Demo [id=" + id + ", name=" + name + ", password=" + password + "]";
	    }
}
